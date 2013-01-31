/*
 * Copyright 2012 Shared Learning Collaborative, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.slc.sli.ingestion.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.EventReaderDelegate;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author dduran
 *
 */
@Component
public class EdfiEventReaderDelegate extends EventReaderDelegate implements ErrorHandler {

    public static final Logger LOG = LoggerFactory.getLogger(EdfiEventReaderDelegate.class);

    @Autowired
    private TypeProvider tp;

    Stack<Pair<String, Map<String, Object>>> complexTypeStack = new Stack<Pair<String, Map<String, Object>>>();
    String currentEntityName = null;
    boolean currentEntityValid = false;

    public EdfiEventReaderDelegate(XMLEventReader reader) {
        super(reader);
    }

    public EdfiEventReaderDelegate() { }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException {
        XMLEvent event = super.nextEvent();
        String eventName = extractTagName(event);


        if (!eventName.startsWith("Interchange")) {

            if (complexTypeStack.isEmpty() && event.isStartElement()) {
                initCurrentEntity(eventName);
            }

            if (currentEntityValid) {

                parseEvent(event);

            } else if (eventName.equals(currentEntityName) && event.isEndElement()) {
                LOG.info("Entity had validation problems: {}", currentEntityName);
                complexTypeStack.removeAllElements();
                currentEntityName = null;
            }
        }
        return event;
    }

    private void parseEvent(XMLEvent e) throws XMLStreamException {

        String eventName = extractTagName(e);

        if (e.isStartElement()) {

            parseStartElement(e.asStartElement(), eventName);

        } else if (e.isCharacters()) {

            parseCharacters(e.asCharacters());

        } else if (e.isEndElement() && eventName.equals(complexTypeStack.peek().getLeft())) {

            parseEndElement();
        }
    }

    @SuppressWarnings("unchecked")
    private void parseStartElement(StartElement e, String eventName) {
        // dump attributes
        Iterator<Attribute> it = e.getAttributes();
        while (it.hasNext()) {
            Attribute a = it.next();
            complexTypeStack.peek().getRight().put(a.getName().getLocalPart(), a.getValue());
        }

        // don't process for root entity element - we already pushed it in initCurrentEntity
        if (!currentEntityName.equals(eventName)) {
            Pair<String, Map<String, Object>> subElement = new ImmutablePair<String, Map<String, Object>>(eventName,
                    new InnerMap());
            complexTypeStack.peek().getRight().put(eventName, subElement.getRight());
            complexTypeStack.push(subElement);
        }
    }

    private void parseCharacters(Characters characters) {
        if (!characters.isIgnorableWhiteSpace() && !characters.isWhiteSpace()) {
            String text = characters.getData();
            complexTypeStack.peek().getRight().put("_value", text);
        }
    }

    private void parseEndElement() {
        if (complexTypeStack.size() > 1) {
            complexTypeStack.pop();
        } else if (complexTypeStack.size() == 1) {
            // completed parsing an entity
            Map<String, Object> entity = complexTypeStack.pop().getRight();

            LOG.info("Parsed entity: {} - {}", currentEntityName, entity);
            currentEntityName = null;
        }
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        LOG.warn("Warning: ", exception);
        // currentEntityValid = false;
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        // LOG.error("Error: ", exception);
        // currentEntityValid = false;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        // LOG.error("FatalError: ", exception);
        // currentEntityValid = false;
    }

    private void initCurrentEntity(String eventName) {
        complexTypeStack.push(new ImmutablePair<String, Map<String, Object>>(eventName, new InnerMap()));
        currentEntityName = eventName;
        currentEntityValid = true;
    }

    @SuppressWarnings({ "unchecked", "serial" })
    private static class InnerMap extends HashMap<String, Object> {
        @Override
        public Object put(String key, Object value) {
            Object result;
            if (this.containsKey(key)) {
                Object stored = this.get(key);
                if (List.class.isAssignableFrom(stored.getClass())) {
                    List<Object> storage = (List<Object>) stored;
                    storage.add(value);
                    result = storage;
                } else {
                    result = super.put(key, new ArrayList<Object>(Arrays.asList(stored, value)));
                }
            } else {
                result = super.put(key, value);
            }
            return result;
        }
    }

    private static String extractTagName(XMLEvent e) {
        String result = "";
        if (e.isEndElement()) {
            result = e.asEndElement().getName().getLocalPart();
        } else if (e.isStartElement()) {
            result = e.asStartElement().getName().getLocalPart();
        }
        return result;
    }

}
