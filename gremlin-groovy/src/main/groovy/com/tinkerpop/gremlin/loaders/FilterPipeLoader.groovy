package com.tinkerpop.gremlin.loaders

import com.tinkerpop.gremlin.Gremlin
import com.tinkerpop.gremlin.groovy.GremlinTokens
import com.tinkerpop.gremlin.groovy.GremlinTokens.T
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.gremlin.pipes.GremlinFluentPipeline

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class FilterPipeLoader {

    public static void load() {

        Gremlin.addStep(GremlinTokens.FILTER);
        GremlinFluentPipeline.metaClass.filter = {final Closure closure ->
            return ((GremlinFluentPipeline) delegate).filter(new GroovyPipeFunction(closure));;
        }

        Gremlin.addStep(GremlinTokens.UNIQUEPATH);
        Gremlin.addStep(GremlinTokens.UNIQUEOBJECT);
        Gremlin.addStep(GremlinTokens.ANDFILTER);
        Gremlin.addStep(GremlinTokens.ORFILTER);
        Gremlin.addStep(GremlinTokens.BACK);
        Gremlin.addStep(GremlinTokens.EXCEPT);
        Gremlin.addStep(GremlinTokens.RETAIN);
        Gremlin.addStep(GremlinTokens.RANDOM);

        Gremlin.addStep(GremlinTokens.PROPERTYFILTER);
        GremlinFluentPipeline.metaClass.propertyFilter = {final String key, final T t, final Object value ->
            if (key.equals(GremlinTokens.ID)) {
                return ((GremlinFluentPipeline) delegate).idFilter(value, Gremlin.mapFilter(t));
            } else if (key.equals(GremlinTokens.LABEL)) {
                return ((GremlinFluentPipeline) delegate).labelFilter((String) value, Gremlin.mapFilter(t));
            } else {
                return ((GremlinFluentPipeline) delegate).propertyFilter(key, Gremlin.mapFilter(t), value);
            }
        }


    }
}
