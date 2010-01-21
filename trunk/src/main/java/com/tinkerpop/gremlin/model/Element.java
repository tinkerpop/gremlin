package com.tinkerpop.gremlin.model;

import java.util.Set;

/**
 * An element is the base class for both vertices and edges.
 * An element has an identifier that must be unique to its inhereting classes (vertex or edges).
 * An element can maintain a collection of key/value properites.
 * Keys are always strings and values can be any object.
 * Particular implemenations can reduce the space of objects that can be values.
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract interface Element {

    /**
     * Return the object value associated with the provided string key.
     *
     * @param key the key of the key/value property
     * @return the object value related to the string key
     */
    public Object getProperty(String key);

    /**
     * Return all the keys associated with the element.
     *
     * @return the set of all string keys associated with the element
     */
    public Set<String> getPropertyKeys();

    /**
     * Assign a key/value property to the element.
     * If a value already exists for this key, then the previous key/value is overwritten.
     *
     * @param key   the string key of the property
     * @param value the object value o the property
     */
    public void setProperty(String key, Object value);

    /**
     * Unassigns a key/value property from the element.
     * The object value of the removed property is returned.
     *
     * @param key the key of the property to remove from the element
     * @return the object value associated with that key prior to removal
     */
    public Object removeProperty(String key);

    /**
     * An identifier that is unique to its inhereting class.
     * All vertices of a graph must have unique identifers.
     * All edges of a graph must have unique identifiers.
     * It is legal for the two classe instances to share the same address space.
     *
     * @return the identifier of the element
     */
    public Object getId();

}
