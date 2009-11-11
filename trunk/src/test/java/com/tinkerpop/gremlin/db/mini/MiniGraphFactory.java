package com.tinkerpop.gremlin.db.mini;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class MiniGraphFactory {

    public static MiniGraph createTinkerGraph() {
        // see tinker-graph.pdf for a visualization of this graph

        MiniGraph graph = new MiniGraph();

        MiniVertex marko = new MiniVertex("1");
        marko.setProperty("name", "marko");
        marko.setProperty("age", 29);
        graph.addVertex(marko);

        MiniVertex vadas = new MiniVertex("2");
        vadas.setProperty("name", "vadas");
        vadas.setProperty("age", 27);
        graph.addVertex(vadas);

        MiniVertex lop = new MiniVertex("3");
        lop.setProperty("name", "lop");
        lop.setProperty("lang", "java");
        graph.addVertex(lop);

        MiniVertex josh = new MiniVertex("4");
        josh.setProperty("name", "josh");
        josh.setProperty("age", 32);
        graph.addVertex(josh);

        MiniVertex ripple = new MiniVertex("5");
        ripple.setProperty("name", "ripple");
        ripple.setProperty("lang", "java");
        graph.addVertex(ripple);

        MiniVertex peter = new MiniVertex("6");
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
