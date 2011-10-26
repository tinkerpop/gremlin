package com.tinkerpop.gremlin.loaders

import com.tinkerpop.blueprints.pgm.Edge
import com.tinkerpop.blueprints.pgm.Vertex
import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import com.tinkerpop.pipes.util.PipeHelper

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class PipeLoader {

    public static void load() {

        Gremlin.addStep(Tokens.STEP);
        // filter steps
        Gremlin.addStep(Tokens.FILTER);
        Gremlin.addStep(Tokens.SIMPLEPATH);
        Gremlin.addStep(Tokens.DEDUP);
        Gremlin.addStep(Tokens.AND);
        Gremlin.addStep(Tokens.OR);
        Gremlin.addStep(Tokens.BACK);
        Gremlin.addStep(Tokens.EXCEPT);
        Gremlin.addStep(Tokens.RETAIN);
        Gremlin.addStep(Tokens.RANDOM);
        Gremlin.addStep(Tokens.PROPERTYFILTER);
        // sideeffect steps
        Gremlin.addStep(Tokens.SIDEEFFECT);
        Gremlin.addStep(Tokens.AGGREGATE);
        Gremlin.addStep(Tokens.GROUPCOUNT);
        Gremlin.addStep(Tokens.OPTIONAL)
        Gremlin.addStep(Tokens.TABLE);
        Gremlin.addStep(Tokens.AS)
        /*[Graph, Vertex, Edge].each {
            it.metaClass.as = {final String name ->
                return new GremlinGroovyPipeline(delegate).as(name);
            }
        }*/
        // transform steps
        Gremlin.addStep(Tokens.TRANSFORM);
        Gremlin.addStep(Tokens.COPYSPLIT);
        Gremlin.addStep(Tokens.FAIRMERGE);
        Gremlin.addStep(Tokens.EXHAUSTMERGE);
        Gremlin.addStep(Tokens.ID);
        Gremlin.addStep(Tokens.IFTHENELSE);
        Gremlin.addStep(Tokens.CAP);
        Gremlin.addStep(Tokens.LABEL);
        Gremlin.addStep(Tokens.LOOP);
        Gremlin.addStep(Tokens.MAP);
        Gremlin.addStep(Tokens.MEMOIZE);
        Gremlin.addStep(Tokens.GATHER);
        Gremlin.addStep(Tokens.SCATTER);
        Gremlin.addStep(Tokens.PATHS);
        Gremlin.addStep(Tokens.OUT);

        Vertex.metaClass.out = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).out(labels);
        }

        Gremlin.addStep(Tokens.OUTE);
        Vertex.metaClass.outE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).outE(labels);
        }

        Gremlin.addStep(Tokens.IN);
        Vertex.metaClass.in = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).in(labels);
        }

        Gremlin.addStep(Tokens.INE);
        Vertex.metaClass.inE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).inE(labels);
        }

        Gremlin.addStep(Tokens.BOTH);
        Vertex.metaClass.both = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).both(labels);
        }

        Gremlin.addStep(Tokens.BOTHE);
        Vertex.metaClass.bothE = {final String... labels ->
            return new GremlinGroovyPipeline(delegate).bothE(labels);
        }

        Gremlin.addStep(Tokens.INV);
        Edge.metaClass.inV = {->
            return new GremlinGroovyPipeline(delegate).inV();
        }

        Gremlin.addStep(Tokens.OUTV);
        Edge.metaClass.outV = {->
            return new GremlinGroovyPipeline(delegate).outV();
        }

        Gremlin.addStep(Tokens.BOTHV);
        Edge.metaClass.bothV = {->
            return new GremlinGroovyPipeline(delegate).bothV();
        }


        GremlinGroovyPipeline.metaClass.propertyMissing = {final String name ->
            if (Gremlin.isStep(name)) {
                return delegate."$name"();
            } else {
                return ((GremlinGroovyPipeline) delegate).property(name);
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.count = {
                return PipeHelper.counter(delegate.iterator());
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.mean = {
                double counter = 0;
                double sum = 0;
                delegate.each {counter++; sum += it;}
                return sum / counter;
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.rightShift = {final Collection collection ->
                final Iterator itty;
                if (delegate instanceof Iterable) {
                    itty = delegate.iterator();
                } else {
                    itty = (Iterator) delegate;
                }
                PipeHelper.fillCollection(itty, collection);
                return collection;
            }
        }

        [Iterable, Iterator].each {
            it.metaClass.rightShift = {final Integer count ->
                final Iterator itty;
                if (delegate instanceof Iterable) {
                    itty = delegate.iterator();
                } else {
                    itty = (Iterator) delegate;
                }

                if (count == -1) {
                    PipeHelper.iterate(itty);
                    return null;
                } else if (count == 1) {
                    return itty.next();
                } else {
                    final List list = new LinkedList();
                    PipeHelper.fillCollection(itty, list, count);
                    return list;
                }
            }
        }


        GremlinGroovyPipeline.metaClass.getAt = {final Integer index ->
            return ((GremlinGroovyPipeline) delegate).range(index, index);
        }


        GremlinGroovyPipeline.metaClass.getAt = {final Range range ->
            return ((GremlinGroovyPipeline) delegate).range(range.getFrom() as Integer, range.getTo() as Integer);
        }
    }
}
