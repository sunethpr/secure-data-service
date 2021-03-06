/*
 * Copyright 2012-2013 inBloom, Inc. and its affiliates.
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
package org.slc.sli.dal.template;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.ReadPreference;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.QueryMapper;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Iterator;
/**
 *
 * @author ablum npandey
 *
 */
public class MongoEntityTemplate extends MongoTemplate {

    private QueryMapper mapper;
    private final MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext;

    public MongoEntityTemplate(MongoDbFactory mongoDbFactory, MongoConverter mongoConverter) {
        super(mongoDbFactory, mongoConverter);
        this.mapper = new QueryMapper(mongoConverter);
        mappingContext = mongoConverter.getMappingContext();
    }

    public <T> Iterator<T> findEach(final Query query, final Class<T> entityClass, String collectionName) {
       MongoPersistentEntity<?> entity = mappingContext.getPersistentEntity(entityClass);

       DBCollection collection = getDb().getCollection(collectionName);

       prepareCollection(collection);

       DBObject dbQuery = mapper.getMappedObject(query.getQueryObject(), entity);
       final DBCursor cursor;

       if (query.getFieldsObject() == null) {
           cursor = collection.find(dbQuery);
       } else {
           cursor = collection.find(dbQuery, query.getFieldsObject());
       }

       return new Iterator<T>() {
           @Override
           public boolean hasNext() {
               // TODO Auto-generated method stub
               return cursor.hasNext();
           }

           @Override
           public T next() {
               return getConverter().read(entityClass, cursor.next());
           }

           @Override
           public void remove() {
               cursor.remove();
           }
       };
    }
}
