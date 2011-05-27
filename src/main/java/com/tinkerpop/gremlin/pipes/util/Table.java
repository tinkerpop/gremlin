package com.tinkerpop.gremlin.pipes.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Table implements Iterable<List> {

    private final List<List> table = new ArrayList<List>();
    private int tableWidth = -1;

    public void addRow(List row) {
        if (this.tableWidth == -1) {
            this.tableWidth = row.size();
        } else {
            if (row.size() != tableWidth) {
                throw new RuntimeException("Table width is " + this.tableWidth + " and row width is " + row.size());
            }
        }
        this.table.add(row);
    }

    public int getRowCount() {
        return this.table.size();
    }

    public int getColumnCount() {
        return tableWidth;
    }

    public Object get(final int row, final int column) {
        return this.table.get(row).get(column);
    }

    public List getRow(final int row) {
        return this.table.get(row);
    }

    public List getColumn(final int column) {
        final List temp = new ArrayList();
        for (final List row : this.table) {
            temp.add(row.get(column));
        }
        return temp;
    }

    public Iterator<List> iterator() {
        return this.table.iterator();
    }

    public String toString() {
        return this.table.toString();
    }

    public void clear() {
        this.tableWidth = -1;
        this.table.clear();
    }
}
