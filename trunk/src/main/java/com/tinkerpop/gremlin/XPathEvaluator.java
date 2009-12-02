package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.SyntaxException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class XPathEvaluator {

    protected int codeDepth = 0;

    private GremlinPathContext baseContext;

    public XPathEvaluator() {
        this.baseContext = GremlinPathContext.newContext(null);
        this.baseContext.setLenient(false);

    }

    public void incrDepth() {
        this.codeDepth++;
    }

    public void decrDepth() {
        this.codeDepth--;
    }

    public int getDepth() {
        return this.codeDepth;
    }

    public List evaluate(String xPathString) throws SyntaxException, EvaluationException {
        try {
            if (this.baseContext.rootChanged()) {
                this.baseContext = GremlinPathContext.newContext(this.baseContext, this.baseContext.getRoot());
            }
            List results = this.baseContext.selectNodes(xPathString);
            this.setVariable(Tokens.LAST_VARIABLE, results);
            return results;
        } catch (JXPathInvalidSyntaxException e) {
            throw new SyntaxException(e.getMessage().replace("Invalid XPath:", "Invalid statement:"));
        } catch (JXPathException e) {
            throw new EvaluationException(EvaluationException.MESSAGE_HEADER + e.getMessage().replace("Undefined variable: ", "undefined variable $").replace("Undefined function:", "undefined function"));
        } catch (SyntaxException e) {
            throw e;
        } catch (EvaluationException e) {
            throw e;
        } catch (Exception e) {
            throw new EvaluationException(EvaluationException.MESSAGE_HEADER + e.getMessage());
        }
    }

    public void setVariable(String variable, Object value) {
        this.baseContext.setVariable(variable, value);
    }

    public Object getVariable(String variable) {
        return this.baseContext.getVariable(variable);
    }

    public void setRoot(Object root) {
        this.baseContext.setRoot(root);
    }

    public Object getRoot() {
        return this.baseContext;
    }
}
