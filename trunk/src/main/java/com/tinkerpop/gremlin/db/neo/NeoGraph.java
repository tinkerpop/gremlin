package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import org.neo4j.api.core.EmbeddedNeo;
import org.neo4j.api.core.NeoService;
import org.neo4j.api.core.Node;
import org.neo4j.api.core.Relationship;
import org.neo4j.util.index.IndexService;
import org.neo4j.util.index.LuceneIndexService;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoGraph implements Graph {

    private NeoService neo;
    private IndexService index;
    private String indexKey;

    public NeoGraph(String directory, String indexKey) {
        this.neo = new EmbeddedNeo(directory);
        this.index = new LuceneIndexService(neo);
        this.indexKey = indexKey;
    }

    public Vertex addVertex(Object id) {
        return new NeoVertex(neo.createNode());
    }

    public Vertex getVertex(Object id) {
        Node node = this.index.getSingleNode(this.indexKey, id);
        if (null != node) {
            return new NeoVertex(node);
        } else {
            return null;
        }
    }

    public void removeVertex(Vertex vertex) {
        Long id = (Long)vertex.getId();
        Node node = neo.getNodeById(id);
        if (null != node) {
            this.index.removeIndex(node, this.indexKey, node.getProperty(this.indexKey));
            node.delete();
        }
    }

    public Edge addEdge(Object id, Vertex outVertex, Vertex inVertex, String label) {
        return null;
    }

    public void removeEdge(Edge edge) {
        ((Relationship)((NeoEdge)edge).getRawElement()).delete();
    }

    public void shutdown() {
        this.neo.shutdown();
        this.index.shutdown();
    }
}
