package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ExpressionContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TestFunctions {
    public static boolean updateMap(NodeSet nodeSet) {
        System.out.println(nodeSet);
        return true;
    }

    public void test() {
        System.out.println("here");
    }

}
