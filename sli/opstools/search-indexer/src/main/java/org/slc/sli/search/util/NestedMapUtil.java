package org.slc.sli.search.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * Operations for nested maps
 *
 */
public class NestedMapUtil {
    private static final String _DOT = ".";
    private static final String DOT_REGEX = "[" + _DOT + "]";

    /**
     * Move field specified from node from to node to
     * @param fieldChainFrom - path to the nested field to move from
     * @param fieldChainTo - new path
     * @param entity - nested map
     */
    public static void rename(List<String> fieldChainFrom, List<String> fieldChainTo, Map<String, Object> entity) {
        put(fieldChainTo, remove(fieldChainFrom, entity), entity);
    }
    /**
     * Remove field specified by its pathname
     * @param fieldChain - path to the nested field
     * @param entity - nested map
     * @return - removed object if found
     */
    public static Object remove(List<String> fieldChain, Map<String, Object> entity) {
        return findRecursively(new ArrayList<String>(fieldChain), entity, true, 0);
    }
    
    /**
     * Remove field specified by its pathname
     * @param fieldChain - path to the nested field
     * @param entity - nested map
     * @return - removed object if found
     */
    public static Object get(List<String> fieldChain, Map<String, Object> entity) {
        return findRecursively(new ArrayList<String>(fieldChain), entity, false, 0);
    }
    
    /**
     * Put field specified by a pathname chain into a map 
     * @param fieldChain - path to the nested field
     * @param value - what to add
     * @param entity - where to add
     */
    public static void put(List<String> fieldChain, Object value, Map<String, Object> entity) {
        insertRecursively(new ArrayList<String>(fieldChain), value, entity, 0);
    }
    

    /**
     * Merge entities
     * @param fieldChain - path to the nested field
     * @param value - what to add
     * @param entity - where to add
     */
    public static void merge(Map<String, Object> entityTo, Map<String, Object> entityFrom) {
        Map<String, Object> map = toFlatMap(entityFrom);
        for (String key: map.keySet()) {
            put(getPathLinkFromDotNotation(key), map.get(key), entityTo);
        }
    }
    
    public static List<String> getPathLinkFromDotNotation(String dotNotationFieldName) {
        return Collections.unmodifiableList(new ArrayList<String>(Arrays.asList(dotNotationFieldName.split(DOT_REGEX))));
    }
    
    /**
     * Filter out entries unless the key is in the list
     * @param nodeNames - list f keys to preserve
     * @param entity - entity to filter out from
     */
    public static void filterExcept(List<String> nodeNames, Map<String, Object> entity) {
        filterExceptRecursively(nodeNames, entity, 0);
    }
    
    public static Map<String, Object> toFlatMap(Map<String, Object> entity) {
        Map<String , Object> flatMap = new HashMap<String, Object>();
        toFlatMapRecursively(new ArrayList<String>(), entity, flatMap, 0);
        return flatMap;
    }
    
    @SuppressWarnings("unchecked")
    private static Object findRecursively(List<String> fieldChain, Object entity, boolean delete, int count) {
        if (fieldChain.isEmpty()) return entity;
        if (count > 10) throw new IllegalArgumentException("Recursion too deep");
        if (entity instanceof Map) {
            Map<String, Object> map = (Map<String, Object>)entity;
            String field = fieldChain.remove(0);
            if (fieldChain.isEmpty()) {
                return (delete) ? map.remove(field) : map.get(field);
            }
            entity = findRecursively(fieldChain, map.get(field), delete, count ++);
            Object obj = map.get(field);
            if (delete && obj != null && obj instanceof Map) {
                Map<String, Object> sub = (Map<String, Object>)obj;
                if (sub.isEmpty()) {
                    map.remove(field);
                }
            }
            return entity;
        } 
        return null;
    }
    
    @SuppressWarnings("unchecked")
    private static void insertRecursively(List<String> fieldChain, Object value, Object entity, int count) {
        if (fieldChain.isEmpty()) return;
        if (count > 10) throw new IllegalArgumentException("Recursion too deep");
        String field = fieldChain.remove(0);
        if (entity instanceof Map) {
            Map<String, Object> map = (Map<String, Object>)entity;
            if (fieldChain.isEmpty()) {
                map.put(field, value);
                return;
            } else {
                Object tmp = map.get(field);
                if (tmp == null) {
                    tmp = new HashMap<String, Object>();
                    map.put(field, tmp);
                }
                if (tmp instanceof Map) {
                    insertRecursively(fieldChain, value, tmp, count);
                    return;
                } 
            }
        } 
        throw new IllegalArgumentException("Unable to rename a value: node exists and not a map");
    }
    
    @SuppressWarnings("unchecked")
    private static void filterExceptRecursively(List<String> nodeNames, Object entity, int count) {
        if (entity == null) return;
        if (count > 10) throw new IllegalArgumentException("Recursion too deep");
        if (entity instanceof Map) {
            Map<String, Object> map = (Map<String, Object>)entity;
            Set<String> toDelete = new HashSet<String>(map.keySet());
            toDelete.removeAll(nodeNames);
            for (String s : toDelete) {
                map.remove(s);
            }
            Object tmp;
            for (String key: map.keySet()) {
                tmp = map.get(key);
                if (tmp != null)
                    filterExceptRecursively(nodeNames, tmp, count++);
            }
        } else if (entity instanceof List) {
            List<Object> arrayElems = (List<Object>)entity;
            for (Object o : arrayElems) {
                if (o instanceof Map) {
                    filterExceptRecursively(nodeNames, (Map<String, Object>)o, count);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    private static void toFlatMapRecursively(List<String> nodeNames, Object entity, Map<String, Object> flatMap, int count) {
        if (entity == null) return;
        if (count > 10) throw new IllegalArgumentException("Recursion too deep");
        if (entity instanceof Map) {
            Map<String, Object> map = (Map<String, Object>)entity;
            Object tmp;
            int lastElemIndex = nodeNames.size();
            for (String key: map.keySet()) {
                tmp = map.get(key);
                if (tmp != null) {
                    nodeNames.add(key);
                    toFlatMapRecursively(nodeNames, tmp, flatMap, ++count);
                    nodeNames.remove(lastElemIndex);
                }
            }
        } else {
            flatMap.put(StringUtils.join(nodeNames, _DOT), entity);
        }
    }
    
}
