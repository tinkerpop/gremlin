package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.JXPathContextFactory;
import org.apache.commons.jxpath.JXPathContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinPathContextFactory { //extends JXPathContextFactory {

    public JXPathContext newContext(JXPathContext parentContext, Object contextBean) {
        return GremlinPathContext.newContext(parentContext, contextBean);
    }

    public static JXPathContextFactory newInstance() {
        return null;
        //return new GremlinPathContextFactory();
    }
}
