package com.tinkerpop.gremlin;

import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.PrintStream;


/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Evaluator {

    protected JXPathContext baseContext;
    protected Map<String, Variable> variableMap = new HashMap<String, Variable>();
    protected PrintStream output;

    public Evaluator() {
        FunctionLibrary library = new FunctionLibrary();
        library.addFunctions(new ClassFunctions(TestFunctions.class, "g"));
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
        this.baseContext = JXPathContext.newContext(null);
        this.baseContext.setFunctions(library);
    }

    public Evaluator(PrintStream output) {
        this();
        this.output = output;
    }

    public Variable setVariable(String name, String type, String value) {
        Variable var = null;
        name = name.replace("$","");
        if (type.equals(Variable.Type.NATURAL.toString())) {
            var = new Variable<Integer>(Variable.Type.NATURAL, Integer.valueOf(value));
        } else if (type.equals(Variable.Type.REAL.toString())) {
            var = new Variable<Float>(Variable.Type.REAL, Float.valueOf(value));
        } else if (type.equals(Variable.Type.STRING.toString())) {
            var = new Variable<String>(Variable.Type.STRING, value);
        } else if (type.equals(Variable.Type.PATH.toString())) {
            var = new Variable<String>(Variable.Type.PATH, value);
        }

        if (null != var) {
            this.baseContext.getVariables().declareVariable(name, var.getValue());
            this.variableMap.put(name, var);
        }

        if(null != var)
            this.println(var.toString());
        return var;
    }

    public void setVariable(String name, Variable variable) {
        this.variableMap.put(name, variable);

    }

    public Variable getVariable(String name) {
        return this.variableMap.get(name);
    }

    public void println(String toPrint) {
        if(null != this.output)
            this.output.println(toPrint);
    }


    public Iterator evaluate(Element startElement, String path) {
        JXPathContext context = JXPathContext.newContext(baseContext, startElement);
        Iterator itty = context.iterate(path);
        while(itty.hasNext()) {
            this.println(itty.next().toString());
        }
        return null;
        //return context.iterate(path);
    }

    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        evaluator.setVariable("$i", "NATURAL", "123");
        Iterator itty = evaluator.evaluate(null, "$i");
        while(itty.hasNext()) {
            System.out.println(itty.next());
        }
    }


}
