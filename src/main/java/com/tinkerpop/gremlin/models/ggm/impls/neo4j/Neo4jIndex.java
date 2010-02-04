package com.tinkerpop.gremlin.models.ggm.impls.neo4j;

import com.tinkerpop.gremlin.models.ggm.Element;
import com.tinkerpop.gremlin.models.ggm.Index;
import org.neo4j.graphdb.Node;
import org.neo4j.index.IndexService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Neo4jIndex implements Index {

    private IndexService indexService;
    private Neo4jGraph graph;
    public Set<String> indexKeys;

    public boolean indexAll = true;


    public Neo4jIndex(final IndexService indexService, final Neo4jGraph graph) {
        this.indexService = indexService;
        this.graph = graph;
        this.indexKeys = new HashSet<String>();
    }

    public void put(final String key, final Object value, final Element element) {
        if (this.indexAll || this.indexKeys.contains(key)) {
            if (element instanceof Neo4jVertex) {
                Node node = (Node) ((Neo4jVertex) element).getRawElement();
                this.indexService.index(node, key, value);
            }
        }
    }

    public Iterable<Element> get(final String key, final Object value) {
        Iterable<Node> itty = this.indexService.getNodes(key, value);
        if (null != itty) {
            Iterator<Node> itty2 = itty.iterator();
            if (itty2.hasNext()) {
                Set<Element> elements = new HashSet<Element>();
                while (itty2.hasNext()) {
                    elements.add(new Neo4jVertex(itty2.next(), this, this.graph));
                }
                return elements;
            }
        }
        return null;
    }

    public void remove(final String key, final Object value, final Element element) {
        if (element instanceof Neo4jVertex) {
            Node node = (Node) ((Neo4jVertex) element).getRawElement();
            this.indexService.removeIndex(node, key, value);
        }
    }

    public void indexAll(final boolean indexAll) {
        this.indexAll = indexAll;
    }

    public void addIndexKey(final String key) {
        this.indexKeys.add(key);
    }

    public void removeIndexKey(final String key) {
        this.indexKeys.remove(key);
        // TODO: drop index in LuceneIndexService
    }

    protected void shutdown() {
        indexService.shutdown();
    }
}
