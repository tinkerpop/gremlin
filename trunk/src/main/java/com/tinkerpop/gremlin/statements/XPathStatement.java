package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.jxpath.CompiledExpression;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class XPathStatement extends SimpleStatement {

   private String xPath;
   //private CompiledExpression compiledXPath;

    public XPathStatement(XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) {
        super.compileTokens(line);
        this.xPath = line;
        /*try {
        this.compiledXPath = JXPathContext.compile(line);
        } catch(JXPathInvalidSyntaxException e) {
             throw new SyntaxException(e.getMessage().replace("Invalid XPath:", "Invalid statement:"));
        }*/
    }

    public List evaluate() {
        return this.xPathEvaluator.evaluate(this.xPath);
        /*List list = new ArrayList();
        Iterator itty = this.compiledXPath.iterate(this.xPathEvaluator.getGremlinPathContext());
        while(itty.hasNext()) {
            list.add(itty.next());
        }
        return list;*/
    }
}
