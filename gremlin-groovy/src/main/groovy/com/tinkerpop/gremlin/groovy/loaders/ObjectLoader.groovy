package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline
import com.tinkerpop.gremlin.groovy.GroovyPipeFunction
import com.tinkerpop.pipes.util.Table
import com.tinkerpop.pipes.util.Row

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class ObjectLoader {

    public static void load() {

        Object.metaClass._ = {final Closure closure ->
            return new GremlinGroovyPipeline(delegate.iterator());
        }

        Map.metaClass.getAt = {final IntRange range ->
            final int size = delegate.size();
            int high = Math.min(size - 1, range.max());
            int low = Math.max(0, range.min());

            final Map tempMap = new LinkedHashMap();
            int c = 0;
            for (final Map.Entry entry: delegate.entrySet()) {
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

        Table.metaClass.apply = {final Closure... closures ->
            return ((Table) delegate).apply(GroovyPipeFunction.generate(closures));

        }

        Table.metaClass.unique = {
            final Table temp = ObjectLoader.cloneTable((Table) delegate);
            for (final Row row: delegate.iterator().unique()) {
                temp.addRow(row);
            }
            return temp;
        }


        Table.metaClass.unique = {final Closure closure ->
            final Table temp = ObjectLoader.cloneTable((Table) delegate);
            for (final Row row: delegate.iterator().unique(closure)) {
                temp.addRow(row);
            }
            return temp;
        }

        Table.metaClass.unique = {final Comparator comparator ->
            final Table temp = ObjectLoader.cloneTable((Table) delegate);
            for (final Row row: delegate.iterator().unique(comparator)) {
                temp.addRow(row);
            }
            return temp;
        }

        Table.metaClass.sort = {
            final Table temp = ObjectLoader.cloneTable((Table) delegate);
            for (final Row row: ((Table) delegate).iterator().sort()) {
                temp.addRow(row);
            }
            return temp;
        }

        Table.metaClass.sort = {final Closure closure ->
            final Table temp = ObjectLoader.cloneTable((Table) delegate);
            for (final Row row: delegate.iterator().sort(closure)) {
                temp.addRow(row);
            }
            return temp;
        }

        Table.metaClass.sort = {final Comparator comparator ->
            final Table temp = ObjectLoader.cloneTable((Table) delegate);
            for (final Row row: delegate.iterator().sort(comparator)) {
                temp.addRow(row);
            }
            return temp;
        }

    }

    private static Table cloneTable(final Table table) {
        if (table.getColumnNames().size() > 0)
            return new Table(table.columnNames.toArray(new String[table.columnNames.size()]));
        else
            return new Table();
    }
}