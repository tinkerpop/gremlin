package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;

import java.util.List;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Evaluator {

    protected GremlinPathContext baseContext = (GremlinPathContext) GremlinPathContext.newContext(null);

    /*static {
        System.setProperty("org.apache.commons.jxpath.JXPathContextFactory", "com.tinkerpop.gremlin.GremlinPathContextFactory");
    }*/

    public List evaluate(String path) throws JXPathInvalidSyntaxException, JXPathInvalidAccessException {

        //System.out.println("Evaluating: " + path);

        if (this.baseContext.rootChanged()) {
            //System.out.println("new root.");
            this.baseContext = (GremlinPathContext) GremlinPathContext.newContext(this.baseContext, this.baseContext.getContextBean());
        }

        List results = this.baseContext.selectNodes(path);
        this.baseContext.getVariables().declareVariable("_", results);
        return results;
    }

    public void setVariable(String variable, Object value) {
        this.baseContext.getVariables().declareVariable(FunctionHelper.getVariable(variable), value);
    }

    public Object getVariable(String variable) {
        return this.baseContext.getVariables().getVariable(FunctionHelper.getVariable(variable));
    }

    public void setRoot(Object rootObject) {
        this.baseContext.setContextBean(rootObject);
    }

    /*public static void main(String args[]) throws Exception {
        //GremlinLexer lex = new GremlinLexer(new ANTLRFileStream("/Users/marko/software/gremlin/trunk/src/test/resources/com/tinkerpop/gremlin/lang/gremlin-examples.txt"));
        GremlinLexer gremlinLexer = new GremlinLexer(new ANTLRStringStream("substring($i)"));
        GremlinParser gremlinParser = new GremlinParser(new CommonTokenStream(gremlinLexer));
        GremlinParser.statement_return parserResult = gremlinParser.statement();
        CommonTree inputTree = (CommonTree) parserResult.getTree();
        try {
            System.out.println("tree: " + inputTree.toStringTree());
            GremlinTree gremlinTree = new GremlinTree(new CommonTreeNodeStream(inputTree), new Evaluator());
            gremlinTree.statement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
