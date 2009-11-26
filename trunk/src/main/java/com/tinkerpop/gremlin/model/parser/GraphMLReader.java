package com.tinkerpop.gremlin.model.parser;

import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GraphMLReader {

    private static final String KEY = "key";
    private static final String ID = "id";
    private static final String ATTR_NAME = "attr.name";
    private static final String ATTR_TYPE = "attr.type";
    private static final String NODE = "node";
    private static final String EDGE = "edge";
    private static final String SOURCE = "source";
    private static final String TARGET = "target";
    private static final String DATA = "data";
    private static final String LABEL = "label";

    private static final String STRING = "string";
    private static final String FLOAT = "float";
    private static final String DOUBLE = "double";
    private static final String INT = "int";

    public static void inputGraph(Graph graph, InputStream xmlInputStream) throws XMLStreamException {

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlReader = inputFactory.createXMLStreamReader(xmlInputStream);

        Map<String, String> dataTypeMap = new HashMap<String, String>();
        Vertex currentVertex = null;
        Edge currentEdge = null;

        while (xmlReader.hasNext()) {

            Integer eventType = xmlReader.next();
            if (eventType.equals(XMLEvent.START_ELEMENT)) {
                String elementName = xmlReader.getName().getLocalPart();
                if (elementName.equals(KEY)) {
                    String attributeName = xmlReader.getAttributeValue(null, ATTR_NAME);
                    String attributeType = xmlReader.getAttributeValue(null, ATTR_TYPE);
                    dataTypeMap.put(attributeName, attributeType);
                } else if (elementName.equals(NODE)) {
                    String vertexId = xmlReader.getAttributeValue(null, ID);
                    currentVertex = graph.addVertex(vertexId);

                } else if (elementName.equals(EDGE)) {
                    String edgeId = xmlReader.getAttributeValue(null, ID);
                    String edgeLabel = xmlReader.getAttributeValue(null, LABEL);
                    String outId = xmlReader.getAttributeValue(null, SOURCE);
                    String inId = xmlReader.getAttributeValue(null, TARGET);

                    Vertex outVertex = graph.getVertex(outId);
                    Vertex inVertex = graph.getVertex(inId);
                    if (null == outVertex) {
                        outVertex = graph.addVertex(outId);
                    }
                    if (null == inVertex) {
                        inVertex = graph.addVertex(inId);
                    }
                    currentEdge = graph.addEdge(edgeId, outVertex, inVertex, edgeLabel);
                } else if (elementName.equals(DATA)) {
                    String key = xmlReader.getAttributeValue(null, KEY);
                    String value = xmlReader.getElementText();
                    if (currentVertex != null) {
                        currentVertex.setProperty(key, typeCastValue(key, value, dataTypeMap));
                    } else if (currentEdge != null) {
                        currentEdge.setProperty(key, typeCastValue(key, value, dataTypeMap));
                    }
                }
            } else if (eventType.equals(XMLEvent.END_ELEMENT)) {
                String elementName = xmlReader.getName().getLocalPart();
                if (elementName.equals(NODE))
                    currentVertex = null;
                else if (elementName.equals(EDGE))
                    currentEdge = null;

            }
        }
        xmlReader.close();
    }

    public static Object typeCastValue(String key, String value, Map<String, String> dataTypeMap) {
        String type = dataTypeMap.get(key);
        if (type.equals(STRING)) {
            return value;
        } else if (type.equals(FLOAT)) {
            return Float.valueOf(value);
        } else if (type.equals(INT)) {
            return Integer.valueOf(value);
        } else if (type.equals(DOUBLE)) {
            return Double.valueOf(value);
        } else {
            return value;
        }
    }
}
