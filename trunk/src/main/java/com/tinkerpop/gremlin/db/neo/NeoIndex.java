package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Index;
import org.neo4j.api.core.Node;
import org.neo4j.util.index.IndexService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoIndex implements Index {

    private IndexService index;

    public NeoIndex(IndexService index) {
        this.index = index;
    }

    public Set<Element> get(String key, Object value) {
        Iterable<Node> itty = this.index.getNodes(key, value);
        if (null != itty) {
            Iterator<Node> itty2 = itty.iterator();
            if (itty2.hasNext()) {
                Set<Element> elements = new HashSet<Element>();
                while (itty2.hasNext()) {
                    elements.add(new NeoVertex(itty2.next(), this));
                }
                return elements;
            }
        }
        return null;
    }

    public void put(String key, Object value, Element element) {
        if (element instanceof NeoVertex) {
            Node node = (Node) ((NeoVertex) element).getRawElement();
            this.index.index(node, key, value);
        }
    }

    public void remove(String key, Object value, Element element) {
        if (element instanceof NeoVertex) {
            Node node = (Node) ((NeoVertex) element).getRawElement();
            this.index.removeIndex(node, key, value);
        }
    }

    protected void shutdown() {
        index.shutdown();
    }
}
