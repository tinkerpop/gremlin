package com.tinkerpop.gremlin.statements;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class RootStatement extends SimpleStatement {

    private List<String> rootStrings = new ArrayList<String>();

    private static final Pattern rootPattern = Pattern.compile("^" + Tokens.ZEROPLUS_WHITESPACE_REGEX + Tokens.ROOT +
            Tokens.WHITESPACE_REGEX + Tokens.NONWHITESPACE_REGEX);

    /*
    root 1 2 '3' $four
    */

    public RootStatement(final XPathEvaluator xPathEvaluator) {
        super(xPathEvaluator);
    }

    public void compileTokens(String line) throws SyntaxException {
        super.compileTokens(line);
        line = line.substring(Tokens.ROOT.length() + 1);
        String[] tempRoots = line.split(Tokens.SINGLESPACE);
        for (String tempRoot : tempRoots) {
            if (tempRoot.length() > 0) {
                this.rootStrings.add(tempRoot);
            }
        }
    }

    public List evaluate() {
        List roots = new ArrayList();
        Graph graph;
        if (this.rootStrings.size() > 0) {
            Object firstObject = this.xPathEvaluator.evaluateList(rootStrings.get(0)).get(0);
            if (firstObject instanceof Graph) {
                graph = (Graph) firstObject;
                for (int i = 1; i < this.rootStrings.size(); i++) {
                    Object r = this.xPathEvaluator.evaluateList(rootStrings.get(i)).get(0);
                    roots.add(graph.getVertex(r));
                }
            } else {
                graph = (Graph) xPathEvaluator.getVariable(Tokens.GRAPH_VARIABLE);
                for (String rootString : this.rootStrings) {
                    Object r = this.xPathEvaluator.evaluateList(rootString).get(0);
                    roots.add(graph.getVertex(r));

                }
            }
        }

        if (roots.size() > 0) {
            if (roots.size() == 1)
                this.xPathEvaluator.setVariable(Tokens.AT_VARIABLE, roots.get(0));
            else
                this.xPathEvaluator.setVariable(Tokens.AT_VARIABLE, roots);
        }

        return roots;
    }

    public static boolean isStatement(final String firstLine) {
        return rootPattern.matcher(firstLine).find();
    }
}
