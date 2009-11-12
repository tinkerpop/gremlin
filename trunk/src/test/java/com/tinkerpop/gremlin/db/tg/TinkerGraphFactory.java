package com.tinkerpop.gremlin.db.tg;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TinkerGraphFactory {

    public static TinkerGraph createTinkerGraph() {
        // see tinker-graph.pdf for a visualization of this graph

        TinkerGraph graph = new TinkerGraph();

        TinkerVertex marko = new TinkerVertex("1");
        marko.setProperty("name", "marko");
        marko.setProperty("age", 29);
        graph.addVertex(marko);

        TinkerVertex vadas = new TinkerVertex("2");
        vadas.setProperty("name", "vadas");
        vadas.setProperty("age", 27);
        graph.addVertex(vadas);

        TinkerVertex lop = new TinkerVertex("3");
        lop.setProperty("name", "lop");
        lop.setProperty("lang", "java");
        graph.addVertex(lop);

        TinkerVertex josh = new TinkerVertex("4");
        josh.setProperty("name", "josh");
        josh.setProperty("age", 32);
        graph.addVertex(josh);

        TinkerVertex ripple = new TinkerVertex("5");
        ripple.setProperty("name", "ripple");
        ripple.setProperty("lang", "java");
        graph.addVertex(ripple);

        TinkerVertex peter = new TinkerVertex("6");
        peter.setProperty("name", "peter");
        peter.setProperty("age", 35);
        graph.addVertex(peter);

        marko.createOutEdge(vadas, "knows").setProperty("weight", 0.5);
        marko.createOutEdge(josh, "knows").setProperty("weight", 1.0);
        marko.createOutEdge(lop, "created").setProperty("weight", 0.4);

        josh.createOutEdge(lop, "created").setProperty("weight", 0.4);
        josh.createOutEdge(ripple, "created").setProperty("weight", 1.0);

        peter.createOutEdge(lop, "created").setProperty("weight", 0.2);

        return graph;

    }

}
