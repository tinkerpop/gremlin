package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;

import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class XPathStatement extends SimpleStatement {

    private String xPath;
    //private CompiledExpression compiledXPath;

    public XPathStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(final String line) {
        super.compileTokens(line);
        this.xPath = line;
        /*try {
        this.compiledXPath = JXPathContext.compile(line);
        } catch(JXPathInvalidSyntaxException e) {
             throw new SyntaxException(e.getMessage().replace("Invalid XPath:", "Invalid statement:"));
        }*/
    }

    public List evaluate() {
        this.xPathEvaluator.setLastStatementLineNumber(this.lineNumber);
        return this.xPathEvaluator.evaluateList(this.xPath);
        /*List list = new ArrayList();
        Iterator itty = this.compiledXPath.iterate(this.xPathEvaluator.getGremlinPathContext());
        while(itty.hasNext()) {
            list.add(itty.next());
        }
        return list;*/
    }

    public Iterator evaluateIterator() {
        this.xPathEvaluator.setLastStatementLineNumber(this.lineNumber);
        return this.xPathEvaluator.evaluateIterator(this.xPath);
    }
}
