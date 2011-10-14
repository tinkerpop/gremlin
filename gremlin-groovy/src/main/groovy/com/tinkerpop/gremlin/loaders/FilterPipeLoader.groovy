package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.Tokens
import com.tinkerpop.gremlin.Tokens.T
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.gremlin.pipes.GremlinPipeline
import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class FilterPipeLoader {

    public static void load() {

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
        /*GremlinGroovyPipeline.metaClass.propertyFilter = {final String key, final T t, final Object value ->
            if (key.equals(Tokens.ID)) {
                return ((GremlinPipeline) delegate).idFilter(value, Gremlin.mapFilter(t));
            } else if (key.equals(Tokens.LABEL)) {
                return ((GremlinPipeline) delegate).labelFilter((String) value, Gremlin.mapFilter(t));
            } else {
                return ((GremlinPipeline) delegate).propertyFilter(key, Gremlin.mapFilter(t), value);
            }
        }*/


    }
}
