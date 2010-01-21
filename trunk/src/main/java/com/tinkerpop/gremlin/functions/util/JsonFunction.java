package com.tinkerpop.gremlin.functions.util;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Element;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class JsonFunction implements Function {

    public static final String FUNCTION_NAME = "json";
    private static final String ID = "_id";
    private static final String TYPE = "type";
    private static final String EDGE = "edge";
    private static final String VERTEX = "vertex";

    public String invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof List) {
                JSONArray jsonArray = new JSONArray();
                jsonArray.addAll((List) object);
                return jsonArray.toJSONString();
            } else if (object instanceof Map) {
                JSONObject jsonMap = new JSONObject();
                jsonMap.putAll((Map) object);
                return jsonMap.toJSONString();
            } else if (object instanceof Element) {
                JSONObject jsonElement = new JSONObject();
                Element element = (Element) object;
                jsonElement.put(ID, element.getId());
                for (String key : element.getPropertyKeys()) {
                    jsonElement.put(key, element.getProperty(key));
                }
                if (object instanceof Vertex) {
                    Vertex vertex = (Vertex) element;
                    jsonElement.put(TYPE, VERTEX);
                    JSONArray jsonArrayOut = new JSONArray();
                    for (Edge edge : vertex.getOutEdges()) {
                        jsonArrayOut.add(edge.getId());
                    }
                    jsonElement.put(Tokens.OUT_EDGES, jsonArrayOut);
                    JSONArray jsonArrayIn = new JSONArray();
                    for (Edge edge : vertex.getInEdges()) {
                        jsonArrayIn.add(edge.getId());
                    }
                    jsonElement.put(Tokens.IN_EDGES, jsonArrayIn);
                } else if (object instanceof Edge) {
                    Edge edge = (Edge) element;
                    jsonElement.put(TYPE, EDGE);
                    jsonElement.put(Tokens.OUT_VERTEX, edge.getOutVertex().getId());
                    jsonElement.put(Tokens.IN_VERTEX, edge.getInVertex().getId());

                }
                return jsonElement.toJSONString();
            } else {
                return object.toString();
            }
        }

        throw EvaluationException.createException(FunctionHelper.makeFunctionName(GremlinFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
