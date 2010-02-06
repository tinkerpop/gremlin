package com.tinkerpop.gremlin.models.pgm.parser;

import com.tinkerpop.gremlin.models.pgm.Edge;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.Vertex;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GraphMLWriter {

    public static void outputGraph(final Graph graph, final OutputStream graphMLOutputStream, final Map<String, String> vertexKeyTypes, final Map<String, String> edgeKeyTypes) throws XMLStreamException {

        XMLOutputFactory inputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = inputFactory.createXMLStreamWriter(graphMLOutputStream);

        writer.writeStartDocument();
        writer.writeStartElement(GraphMLTokens.GRAPHML);
        writer.writeAttribute(GraphMLTokens.XMLNS, GraphMLTokens.GRAPHML_XMLNS);
        //<key id="weight" for="edge" attr.name="weight" attr.type="float"/>
        for (Map.Entry<String, String> entry : vertexKeyTypes.entrySet()) {
            writer.writeStartElement(GraphMLTokens.KEY);
            writer.writeAttribute(GraphMLTokens.ID, entry.getKey());
            writer.writeAttribute(GraphMLTokens.FOR, GraphMLTokens.NODE);
            writer.writeAttribute(GraphMLTokens.ATTR_NAME, entry.getKey());
            writer.writeAttribute(GraphMLTokens.ATTR_TYPE, entry.getValue());
            writer.writeEndElement();
        }
        for (Map.Entry<String, String> entry : edgeKeyTypes.entrySet()) {
            writer.writeStartElement(GraphMLTokens.KEY);
            writer.writeAttribute(GraphMLTokens.ID, entry.getKey());
            writer.writeAttribute(GraphMLTokens.FOR, GraphMLTokens.EDGE);
            writer.writeAttribute(GraphMLTokens.ATTR_NAME, entry.getKey());
            writer.writeAttribute(GraphMLTokens.ATTR_TYPE, entry.getValue());
            writer.writeEndElement();
        }


        writer.writeStartElement(GraphMLTokens.GRAPH);
        writer.writeAttribute(GraphMLTokens.ID, GraphMLTokens.G);
        writer.writeAttribute(GraphMLTokens.EDGEDEFAULT, GraphMLTokens.DIRECTED);

        for (Vertex vertex : graph.getVertices()) {
            writer.writeStartElement(GraphMLTokens.NODE);
            writer.writeAttribute(GraphMLTokens.ID, vertex.getId().toString());
            for (String key : vertex.getPropertyKeys()) {
                writer.writeStartElement(GraphMLTokens.DATA);
                writer.writeAttribute(GraphMLTokens.KEY, key);
                writer.writeCharacters(vertex.getProperty(key).toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            for (Edge edge : vertex.getOutEdges()) {
                writer.writeStartElement(GraphMLTokens.EDGE);
                writer.writeAttribute(GraphMLTokens.ID, edge.getId().toString());
                writer.writeAttribute(GraphMLTokens.SOURCE, edge.getOutVertex().getId().toString());
                writer.writeAttribute(GraphMLTokens.TARGET, edge.getInVertex().getId().toString());
                writer.writeAttribute(GraphMLTokens.LABEL, edge.getLabel());

                for (String key : edge.getPropertyKeys()) {
                    writer.writeStartElement(GraphMLTokens.DATA);
                    writer.writeAttribute(GraphMLTokens.KEY, key);
                    writer.writeCharacters(edge.getProperty(key).toString());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
            }

        }
        writer.writeEndElement(); // graph
        writer.writeEndElement(); // graphml
        writer.writeEndDocument();

        writer.flush();
        writer.close();

    }

    public static void outputGraph(final Graph graph, final OutputStream graphMLOutputStream) throws XMLStreamException {
        Map<String, String> vertexKeyTypes = new HashMap<String, String>();
        Map<String, String> edgeKeyTypes = new HashMap<String, String>();

        for (Vertex vertex : graph.getVertices()) {
            for (String key : vertex.getPropertyKeys()) {
                if (!vertexKeyTypes.containsKey(key)) {
                    vertexKeyTypes.put(key, GraphMLWriter.getStringType(vertex.getProperty(key)));
                }
            }
            for (Edge edge : vertex.getOutEdges()) {
                for (String key : edge.getPropertyKeys()) {
                    if (!edgeKeyTypes.containsKey(key)) {
                        edgeKeyTypes.put(key, GraphMLWriter.getStringType(edge.getProperty(key)));
                    }
                }
            }
        }
        GraphMLWriter.outputGraph(graph, graphMLOutputStream, vertexKeyTypes, edgeKeyTypes);
    }

    private static String getStringType(final Object object) {
        if (object instanceof String)
            return GraphMLTokens.STRING;
        else if (object instanceof Integer)
            return GraphMLTokens.INT;
        else if (object instanceof Long)
            return GraphMLTokens.LONG;
        else if (object instanceof Float)
            return GraphMLTokens.FLOAT;
        else if (object instanceof Double)
            return GraphMLTokens.DOUBLE;
        else if (object instanceof Boolean)
            return GraphMLTokens.BOOLEAN;
        else
            return GraphMLTokens.STRING;
    }

}
