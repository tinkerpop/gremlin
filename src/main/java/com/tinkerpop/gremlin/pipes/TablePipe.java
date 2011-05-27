package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.gremlin.pipes.util.Table;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TablePipe<S> extends AbstractPipe<S, S> implements SideEffectPipe<S, S, Table> {

    private final Table table;
    private final List<Integer> indices;
    private final Closure[] closures;

    public TablePipe(final Table table, final List<Integer> indices, final Closure[] closures) {
        this.table = table;
        this.indices = indices;
        this.closures = closures;
    }

    public Table getSideEffect() {
        return this.table;
    }

    public S processNextStart() {
        final S start = this.starts.next();
        if (this.starts instanceof Pipe) {
            final List path = ((Pipe) this.starts).getPath();
            final List row = new ArrayList();
            int counter = 0;
            int i = 0;
            for (final Object object : path) {
                if (this.indices.contains(counter)) {
                    if (this.closures.length > 0) {
                        row.add(this.closures[i].call(object));
                        i++;
                    } else {
                        row.add(object);
                    }
                }
                counter++;
            }
            this.table.addRow(row);
        }
        return start;
    }
}
