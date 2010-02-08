package com.tinkerpop.gremlin.functions.xpath;

import com.tinkerpop.gremlin.XPathEvaluator;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class XPathFunctionTest extends TestCase {

    public void testXPathFunctions() {
        XPathEvaluator xe = new XPathEvaluator();
        assertEquals(xe.evaluateList("g:list(1,2,3)[last()]").get(0), 3.0);
        assertEquals(xe.evaluateList("g:list(1,2,3)[position() = 2]").get(0), 2.0);
        assertEquals(xe.evaluateList("count(g:list(1,2,3))").get(0), 3.0);
        //
        assertEquals(xe.evaluateList("string(1)").get(0), "1");
        assertEquals(xe.evaluateList("concat('marko','rodriguez')").get(0), "markorodriguez");
        assertEquals(xe.evaluateList("starts-with('markorodriguez','marko')").get(0), true);
        assertEquals(xe.evaluateList("contains('marko123','marko')").get(0), true);
        assertEquals(xe.evaluateList("substring-before('markorodriguez','rodriguez')").get(0), "marko");
        assertEquals(xe.evaluateList("substring-after('markorodriguez','marko')").get(0), "rodriguez");
        assertEquals(xe.evaluateList("substring('markorodriguez',2)").get(0), "arkorodriguez");
        assertEquals(xe.evaluateList("string-length('marko')").get(0), 5.0);
        assertEquals(xe.evaluateList("normalize-space('   marko   ')").get(0), "marko");
        assertEquals(xe.evaluateList("translate('marko','ar','ie')").get(0), "mieko");
        //
        assertEquals(xe.evaluateList("boolean('true')").get(0), true);
        assertEquals(xe.evaluateList("not(true())").get(0), false);
        assertEquals(xe.evaluateList("true()").get(0), true);
        assertEquals(xe.evaluateList("false()").get(0), false);
        //
        assertEquals(xe.evaluateList("number('1.0')").get(0), 1.0);
        //assertEquals(xe.evaluateList("sum(g:list(1,2,3))").get(0), 6.0);  TODO: why is this broken?
        assertEquals(xe.evaluateList("floor(1.2)").get(0), 1.0);
        assertEquals(xe.evaluateList("ceiling(1.2)").get(0), 2.0);
        assertEquals(xe.evaluateList("round(1.2)").get(0), 1.0);
        //
        assertEquals(xe.evaluateList("matches('marko', '[m][a][r][k][o]')").get(0), true);
        assertEquals(xe.evaluateList("replace('marko', 'ma', 'aa')").get(0), "aarko");
        //
        assertEquals(xe.evaluateList("name()").get(0), "root");
        assertEquals(xe.evaluateList("local-name()").get(0), "root");
        assertEquals(xe.evaluateList("null()").size(), 0);
    }
}
