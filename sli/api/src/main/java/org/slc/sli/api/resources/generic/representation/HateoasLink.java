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
package org.slc.sli.api.resources.generic.representation;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slc.sli.api.config.EntityDefinition;
import org.slc.sli.api.config.EntityDefinitionStore;
import org.slc.sli.api.constants.ResourceConstants;
import org.slc.sli.api.constants.ResourceNames;
import org.slc.sli.api.representation.EmbeddedLink;
import org.slc.sli.api.representation.EntityBody;
import org.slc.sli.api.resources.util.ResourceUtil;

/**
 * Helper class for adding hateoas links to entities
 *
 * @author srupasinghe
 * @author jstokes
 * @author pghosh
 */

@Component
public class HateoasLink {

    @Autowired
    private EntityDefinitionStore entityDefinitionStore;

    public List<EntityBody> add(final String resource, List<EntityBody> entities, final UriInfo uriInfo) {

        EntityDefinition definition = entityDefinitionStore.lookupByResourceName(resource);

        // for search, entities can have different types. need to look up definition for each.
        boolean isSearch = resource.equals(ResourceNames.SEARCH);

        for (EntityBody entity : entities) {

            List<EmbeddedLink> links = ResourceUtil.getLinks(entityDefinitionStore,
                    isSearch ? entityDefinitionStore.lookupByResourceName((String) entity.get("type")) : definition,
                    entity, uriInfo);

            if (!links.isEmpty()) {
                entity.put(ResourceConstants.LINKS, links);
            }
        }

        return entities;
    }
}
