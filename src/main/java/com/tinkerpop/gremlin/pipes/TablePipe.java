package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.gremlin.pipes.util.Table;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TablePipe<S> extends AbstractPipe<S, S> implements SideEffectPipe<S, S, Table> {

    private final Table table;
    private final Closure[] closures;
    private final List<AsPipe> asPipes;
    private final boolean doClosures;

    public TablePipe(final Table table, final GremlinPipeline pipeline, final Closure... closures) {
        this.table = table;
        this.closures = closures;
        this.doClosures = this.closures.length > 0;
        final List<String> columnNames = new ArrayList<String>();
        this.asPipes = pipeline.getAsPipes();
        for (final AsPipe asPipe : this.asPipes) {
            columnNames.add(asPipe.getName());
        }
        if (columnNames.size() > 0)
            table.setColumnNames(columnNames.toArray(new String[columnNames.size()]));

    }

    public Table getSideEffect() {
        return this.table;
    }

    public S processNextStart() {
        final S s = this.starts.next();
        final List row = new ArrayList();
        int i = 0;
        for (final AsPipe asPipe : this.asPipes) {
            if (doClosures) {
                row.add(this.closures[i].call(asPipe.getCurrentEnd()));
                i++;
            } else {
                row.add(asPipe.getCurrentEnd());
            }
        }
        this.table.addRow(row);
        return s;
    }
}
