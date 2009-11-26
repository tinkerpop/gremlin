package com.tinkerpop.gremlin.db.tg;

import com.tinkerpop.gremlin.model.Vertex;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphFactory {

    public static TinkerGraph createTinkerGraph() {
        // see graph-example-1.pdf for a visualization of this graph

        TinkerGraph graph = new TinkerGraph();

        TinkerVertex marko = new TinkerVertex("1");
        marko.setProperty("name", "marko");
        marko.setProperty("age", 29);
        graph.addVertex(marko);

        Vertex vadas = graph.addVertex("2");
        vadas.setProperty("name", "vadas");
        vadas.setProperty("age", 27);

        Vertex lop = graph.addVertex("3");
        lop.setProperty("name", "lop");
        lop.setProperty("lang", "java");

        Vertex josh = graph.addVertex("4");
        josh.setProperty("name", "josh");
        josh.setProperty("age", 32);

        Vertex ripple = graph.addVertex("5");
        ripple.setProperty("name", "ripple");
        ripple.setProperty("lang", "java");

        Vertex peter = graph.addVertex("6");
        peter.setProperty("name", "peter");
        peter.setProperty("age", 35);

        graph.addEdge("7", marko, vadas, "knows").setProperty("weight", 0.5);
        graph.addEdge("8", marko, josh, "knows").setProperty("weight", 1.0);
        graph.addEdge("9", marko, lop, "created").setProperty("weight", 0.4);

        graph.addEdge("10", josh, ripple, "created").setProperty("weight", 1.0);
        graph.addEdge("11", josh, lop, "created").setProperty("weight", 0.4);
        
        graph.addEdge("12", peter, lop, "created").setProperty("weight", 0.2);

        return graph;

    }

}
