package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.Map;
import java.util.HashMap;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class AssignKeyFunctionTest extends TestCase {

    public void testAssignKeyFunction() {
         XPathEvaluator xe = new XPathEvaluator();
        Map map = new HashMap();
        map.put("marko", 1.0);
        map.put("jen", 2.0);
        xe.setVariable("$i", map);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 1.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("(1+2)[g:assign-key($i,'marko')]").get(0), 3.0);
        assertEquals(xe.evaluateList("$i/@marko").get(0), 3.0);
        assertEquals(xe.evaluateList("$i/@jen").get(0), 2.0);
        assertEquals(xe.evaluateList("(1000)[g:assign-key($i,'peter')]").get(0), 1000.0);
        assertEquals(xe.evaluateList("$i/@peter").get(0), 1000.0);
    }
}
