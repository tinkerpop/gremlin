package com.tinkerpop.gremlin.model.parser;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.OutputStream;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GraphMLWriter {

    public static void outputGraph(Graph graph, OutputStream graphMLOutputStream) throws XMLStreamException {

        XMLOutputFactory inputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = inputFactory.createXMLStreamWriter(graphMLOutputStream);


        writer.writeStartDocument();
        writer.writeStartElement(GraphMLTokens.GRAPHML);
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
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();

    }
}
