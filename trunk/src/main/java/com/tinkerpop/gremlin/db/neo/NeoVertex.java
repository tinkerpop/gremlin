package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Vertex;
import org.neo4j.api.core.Node;
import org.neo4j.api.core.Relationship;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoVertex extends NeoElement implements Vertex {

    public static final HashMap<Direction, org.neo4j.api.core.Direction> directionMap =
            new HashMap<Direction, org.neo4j.api.core.Direction>();

    static {
        directionMap.put(Direction.OUT, org.neo4j.api.core.Direction.OUTGOING);
        directionMap.put(Direction.IN, org.neo4j.api.core.Direction.INCOMING);
        directionMap.put(Direction.BOTH, org.neo4j.api.core.Direction.BOTH);
    }

    public NeoVertex(Node node) {
        this.element = node;
    }

    public Set<Edge> getEdges(Direction direction) {
        Set<Edge> edges = new HashSet<Edge>();
        for (Relationship r : ((Node) this.element).getRelationships(directionMap.get(direction))) {
            edges.add(new NeoEdge(r));
        }
        return edges;
    }
}
