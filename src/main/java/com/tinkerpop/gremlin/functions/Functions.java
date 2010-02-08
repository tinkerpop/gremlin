package com.tinkerpop.gremlin.functions;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Functions extends org.apache.commons.jxpath.Functions {

    public void addFunctions(Functions functions);

    public Map<String, Map<String,Function>> getFunctions();

}
