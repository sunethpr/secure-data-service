package org.slc.sli.test.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.slc.sli.test.generators.interchange.InterchangeEdOrgGenerator;

/**
 * Utilities to help when using JAXB
 *
 * @author dduran
 *
 */
public class JaxbUtils {

    // this is very single threaded
    private static Marshaller streamMarshaller = null;
    
    public static Marshaller getStreamMarshaller() {
        return streamMarshaller;
    }

    public static XMLStreamWriter createInterchangeWriter(String xmlFilePath, Class interchange) {
        XMLStreamWriter writer = null;
        FileOutputStream xmlFos = null;
        JAXBContext context = null;
        
        if (streamMarshaller != null) {
            System.out.println("The previous interchange writer may not have called finishInterchangeWriter().");
        }
        
        try {
            context = JAXBContext.newInstance(interchange);
            streamMarshaller = context.createMarshaller();
            streamMarshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            streamMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        } catch (JAXBException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            xmlFos = new FileOutputStream(xmlFilePath);
            writer = XMLOutputFactory.newFactory().createXMLStreamWriter(xmlFos, "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");

            writer.setNamespaceContext(new NamespaceContext() {
                public Iterator getPrefixes(String namespaceURI) {
                    return null;
                }

                public String getPrefix(String namespaceURI) {
                    return "";
                }

                public String getNamespaceURI(String prefix) {
                    return null;
                }
            });
            
        } catch (XMLStreamException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FactoryConfigurationError e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return writer;
    }
    
    public static void finishInterchangeWriter(XMLStreamWriter writer) {
        
        try {
            writer.writeEndDocument();
            writer.close();
        } catch (XMLStreamException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        streamMarshaller = null;
    }

    /**
     * Marshal the provided object using the XMLStreamWriter specified
     *
     * @param objectToMarshal
     * @param outputStream
     * @throws JAXBException
     */
    public static void marshal(Object objectToMarshal, XMLStreamWriter outputStream) throws JAXBException {
        if (objectToMarshal != null) {
            long startTime = System.currentTimeMillis();

            streamMarshaller.marshal(objectToMarshal, outputStream);

            System.out.println("marshaled " + objectToMarshal.getClass() + " in: "
                    + (System.currentTimeMillis() - startTime));
        } else {
            throw new IllegalArgumentException("Cannot marshal null object");
        }
    }

    
    /**
     * Marshal the provided object using System.out
     *
     * @param objectToMarshal
     * @throws JAXBException
     */
    @Deprecated
    public static void marshal(Object objectToMarshal) throws JAXBException {
        marshal(objectToMarshal, System.out);
    }

    /**
     * Marshal the provided object using the OutputStream specified
     *
     * @param objectToMarshal
     * @param outputStream
     * @throws JAXBException
     */
    @Deprecated
    public static void marshal(Object objectToMarshal, OutputStream outputStream) throws JAXBException {
        if (objectToMarshal != null) {
            long startTime = System.currentTimeMillis();

            JAXBContext context = JAXBContext.newInstance(objectToMarshal.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(objectToMarshal, outputStream);

            System.out.println("marshaled " + objectToMarshal.getClass() + " in: "
                    + (System.currentTimeMillis() - startTime));
        } else {
            throw new IllegalArgumentException("Cannot marshal null object");
        }
    }

    // TODO: right now we will create a new Marshaller every time. We can optimize by caching a
    // Marshaller for every interchange (lazily)
}
