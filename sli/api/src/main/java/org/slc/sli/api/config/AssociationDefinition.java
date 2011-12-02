package org.slc.sli.api.config;

import java.util.List;

import org.slc.sli.api.service.Treatment;
import org.slc.sli.api.service.Validator;

/**
 * Definition of an association resource
 * 
 * @author nbrown
 * 
 */
public class AssociationDefinition extends EntityDefinition {
    private final EntityDefinition sourceEntity;
    private final EntityDefinition targetEntity;
    
    public AssociationDefinition(String type, String collectionName, String resourceName, List<Treatment> treatments,
            List<Validator> validators, EntityDefinition sourceEntity, EntityDefinition targetEntity) {
        super(type, collectionName, resourceName, treatments, validators);
        this.sourceEntity = sourceEntity;
        this.targetEntity = targetEntity;
    }
    
    /**
     * The source of the association
     * 
     * @return
     */
    public EntityDefinition getSourceEntity() {
        return sourceEntity;
    }
    
    /**
     * The target of the association
     * 
     * @return
     */
    public EntityDefinition getTargetEntity() {
        return targetEntity;
    }
    
    /**
     * Create a builder for an entity definition with the same collection and resource name
     * 
     * @param entityName
     *            the collection/resource name
     * @return the builder to create the entity definition
     */
    public static Builder makeAssoc(String entityName) {
        return new Builder(entityName);
    }
    
    /**
     * Create a builder for an entity definition
     * 
     * @param collectionName
     *            the name of the entity in the db
     * @param resourceName
     *            the name of the entity in the ReST uri
     * @return the builder to create the entity definition
     */
    public static Builder makeAssoc(String type, String collectionName, String resourceName) {
        return new Builder(type);
    }
    
    public static class Builder extends EntityDefinition.Builder {
        private EntityDefinition sourceEntity;
        private EntityDefinition targetEntity;
        
        /**
         * Create a builder for an association definition
         * 
         * @param collectionName
         *            the name of the association in the db
         * @param resourceName
         *            the name of the association in the ReST uri
         */
        public Builder(String type) {
            super(type);
        }
        
        /**
         * Sets the source definition
         * 
         * @param source
         *            the source of the association
         * @return the builder
         */
        public Builder from(EntityDefinition source) {
            this.sourceEntity = source;
            return this;
        }
        
        /**
         * Sets the target definition
         * 
         * @param target
         *            the target definition
         * @return the builder
         */
        public Builder to(EntityDefinition target) {
            this.targetEntity = target;
            return this;
        }
        
        @Override
        public Builder withTreatments(Treatment... treatments) {
            super.withTreatments(treatments);
            return this;
        }
        
        @Override
        public Builder withValidators(Validator... validators) {
            super.withValidators(validators);
            return this;
        }
        
        @Override
        public Builder storeIn(String collectionName) {
            super.storeIn(collectionName);
            return this;
        }
        
        @Override
        public Builder exposeAs(String resourceName) {
            super.exposeAs(resourceName);
            return this;
        }
        
        @Override
        public AssociationDefinition build() {
            return new AssociationDefinition(getType(), getCollectionName(), getResourceName(), getTreatments(),
                    getValidators(), sourceEntity, targetEntity);
        }
        
    }
}
