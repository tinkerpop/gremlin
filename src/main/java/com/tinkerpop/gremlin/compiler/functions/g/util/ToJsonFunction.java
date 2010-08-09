package com.tinkerpop.gremlin.compiler.functions.g.util;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ToJsonFunction extends AbstractFunction<String> {

    public static final String FUNCTION_NAME = "to-json";
    private static final String _ID = "_id";
    private static final String _PROPERTIES = "_properties";
    private static final String _TYPE = "_type";
    private static final String EDGE = "edge";
    private static final String VERTEX = "vertex";

    public Atom<String> compute(final List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {
        if (parameters.size() == 1) {
            Object object = parameters.get(0).compute().getValue();
            if (object instanceof List) {
                return new Atom<String>(createJSONList((List) object).toJSONString());
            } else if (object instanceof Map) {
                return new Atom<String>(createJSONMap((Map) object).toJSONString());
            } else if (object instanceof Element) {
                return new Atom<String>(createJSONElement((Element) object).toJSONString());
            } else {
                return new Atom<String>(object.toString());
            }
        }

        throw new RuntimeException(this.createUnsupportedArgumentMessage());

    }

    private static JSONArray createJSONList(List list) {
        JSONArray jsonList = new JSONArray();
        for (Object item : list) {
            if (item instanceof Element) {
                jsonList.add(createJSONElement((Element) item));
            } else if (item instanceof List) {
                jsonList.add(createJSONList((List) item));
            } else if (item instanceof Map) {
                jsonList.add(createJSONMap((Map) item));
            } else {
                jsonList.add(item);
            }
        }
        return jsonList;
    }

    private static JSONObject createJSONMap(Map map) {
        JSONObject jsonMap = new JSONObject();
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            if (value instanceof List) {
                value = createJSONList((List) value);
            } else if (value instanceof Map) {
                value = createJSONMap((Map) value);
            } else if (value instanceof Element) {
                value = createJSONElement((Element) value);
            }

            if (key instanceof List) {
                key = createJSONList((List) key);
            } else if (key instanceof Map) {
                key = createJSONMap((Map) key);
            } else if (key instanceof Element) {
                key = createJSONElement((Element) key);
            }
            jsonMap.put(key, value);
        }
        return jsonMap;

    }

    private static JSONObject createJSONElement(Element element) {
        JSONObject jsonElement = new JSONObject();
        jsonElement.put(_ID, element.getId());
        jsonElement.put(_PROPERTIES, createJSONMap(createPropertyMap(element)));
        if (element instanceof Vertex) {
            Vertex vertex = (Vertex) element;
            jsonElement.put(_TYPE, VERTEX);
            JSONArray jsonArrayOut = new JSONArray();
            for (Edge edge : vertex.getOutEdges()) {
                jsonArrayOut.add(edge.getId());
            }
            jsonElement.put(Tokens.OUT_E, jsonArrayOut);
            JSONArray jsonArrayIn = new JSONArray();
            for (Edge edge : vertex.getInEdges()) {
                jsonArrayIn.add(edge.getId());
            }
            jsonElement.put(Tokens.IN_E, jsonArrayIn);
        } else if (element instanceof Edge) {
            Edge edge = (Edge) element;
            jsonElement.put(_TYPE, EDGE);
            jsonElement.put(Tokens.OUT_V, edge.getOutVertex().getId());
            jsonElement.put(Tokens.IN_V, edge.getInVertex().getId());

        }
        return jsonElement;
    }

    private static Map createPropertyMap(Element element) {
        Map map = new HashMap();
        for (String key : element.getPropertyKeys()) {
            map.put(key, element.getProperty(key));
        }
        return map;
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }

}
