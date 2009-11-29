package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.util.JXPath11CompatibleTypeConverter;

import java.util.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinTypeConverter extends JXPath11CompatibleTypeConverter {


    protected Collection unmodifiableCollection(Collection collection) {
       return collection;
    }
}
