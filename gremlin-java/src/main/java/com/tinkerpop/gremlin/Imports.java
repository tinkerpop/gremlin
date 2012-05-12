package com.tinkerpop.gremlin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Imports {

    private static final List<String> imports = new ArrayList<String>();

    static {
        // gremlin
        imports.add("com.tinkerpop.gremlin.*");
        imports.add("com.tinkerpop.gremlin.java.*");
        imports.add("com.tinkerpop.gremlin.pipes.*");
        imports.add("com.tinkerpop.gremlin.pipes.filter.*");
        imports.add("com.tinkerpop.gremlin.pipes.transform.*");

        // blueprints
        imports.add("com.tinkerpop.blueprints.pgm.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.tg.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.neo4j.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.orientdb.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.dex.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.rexster.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.neo4jbatch.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.sail.*");
        imports.add("com.tinkerpop.blueprints.pgm.impls.sail.impls.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.io.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.io.graphml.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.io.graphson.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.wrappers.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.wrappers.batch.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.wrappers.event.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.wrappers.event.listener.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.wrappers.id.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.wrappers.readonly.*");
        imports.add("com.tinkerpop.blueprints.pgm.util.wrappers.partition.*");
        imports.add("com.tinkerpop.blueprints.pgm.oupls.sail.*");
        imports.add("com.tinkerpop.blueprints.pgm.oupls.jung.*");

        // pipes
        imports.add("com.tinkerpop.pipes.*");
        imports.add("com.tinkerpop.pipes.branch.*");
        imports.add("com.tinkerpop.pipes.filter.*");
        imports.add("com.tinkerpop.pipes.sideeffect.*");
        imports.add("com.tinkerpop.pipes.transform.*");
        imports.add("com.tinkerpop.pipes.util.*");
        imports.add("com.tinkerpop.pipes.util.iterators.*");
        imports.add("com.tinkerpop.pipes.util.structures.*");
    }

    public static List<String> getImports() {
        return Imports.imports;
    }
}
