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

package org.slc.sli.stamper.mapreduce.map;

import java.io.IOException;

import com.mongodb.hadoop.io.BSONWritable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import org.slc.sli.stamper.mapreduce.map.key.IdFieldEmittableKey;
import org.slc.sli.stamper.util.BSONUtilities;

/**
 * IDMapper
 *
 * A basic mapper that emits the unique identifiers for a provided collection.
 *
 * Map input / output:
 * IdFieldEmittableKey - Input key type. Defines the fields that represent a key in the entity.
 * BSONOBject - Entity to examine.
 * EmittableKey - Output key for the mapper.
 * BSONObject -- The entity the key corresponds to.
 */
public class IDMapper extends Mapper<IdFieldEmittableKey, BSONWritable, IdFieldEmittableKey, BSONWritable> {

    @Override
    public void map(IdFieldEmittableKey id, BSONWritable entity, Context context) throws IOException, InterruptedException {

        IdFieldEmittableKey identifier = new IdFieldEmittableKey();

        // Values in the getIdNames Set are dot-separated Mongo field names.
        Text[] idFieldNames = id.getFieldNames();
        for (Text field : idFieldNames) {
            String value = BSONUtilities.getValue(entity, field.toString());
            if (value != null) {
                identifier.setFieldName(field.toString());
                identifier.setId(new Text(value));
            }
        }
        context.write(identifier, entity);
    }
}
