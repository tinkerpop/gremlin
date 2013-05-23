package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.pipes.util.structures.Row
import com.tinkerpop.pipes.util.structures.Table

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoader {

    public static void load() {

        Object.metaClass._ = { final Closure closure ->
            return new GremlinGroovyPipeline(delegate.iterator());
        }

        Map.metaClass.getAt = { final IntRange range ->
            final int size = delegate.size();
            int high = Math.min(size - 1, range.max());
            int low = Math.max(0, range.min());

            final Map tempMap = new LinkedHashMap();
            int c = 0;
            for (final Map.Entry entry : delegate.entrySet()) {
                if (c >= low && c <= high) {
                    tempMap.put(entry.getKey(), entry.getValue());
                }
                if (c > high) {
                    break;
                }
                c++;

            }
            return tempMap;


        }

        Table.metaClass.apply = { final Closure... closures ->
            return ((Table) delegate).apply(GroovyPipeFunction.generate(closures));

        }

        Table.metaClass.unique = { final Closure closure ->
            final Table temp = Table.cloneTableStructure((Table) delegate);
            for (final Row row : delegate.iterator().unique(closure)) {
                temp.addRow(row);
            }
            return temp;
        }

        Table.metaClass.sort = { final Closure closure ->
            final Table temp = Table.cloneTableStructure((Table) delegate);
            for (final Row row : delegate.iterator().sort(closure)) {
                temp.addRow(row);
            }
            return temp;
        }

        List.metaClass.isSimple = {
            return new HashSet(((List) delegate)).size() == ((List) delegate).size()
        }
    }
}