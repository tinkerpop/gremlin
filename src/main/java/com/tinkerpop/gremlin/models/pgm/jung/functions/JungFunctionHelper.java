package com.tinkerpop.gremlin.models.pgm.jung.functions;

import com.tinkerpop.gremlin.models.pgm.Edge;
import org.apache.commons.collections15.Transformer;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctionHelper {

    /*public static Transformer<Edge, Double> edgeLabelWeightChain(Map<String, Boolean> labelFilter, String weightPropertyKey) {
        EdgeLabelTransformer
    }*/

    public class EdgeLabelTransformer implements Transformer<Edge, Double> {
        private Map<String, Boolean> labelFilter;

        public EdgeLabelTransformer(Map<String, Boolean> labelFilter) {
            this.labelFilter = labelFilter;
        }

        public Double transform(Edge edge) {
            Boolean filter = labelFilter.get(edge.getLabel());
            if (filter == null)
                return 0.0d;
            else if (filter)
                return 0.0d;
            else
                return 1.0;
        }
    }

    public class EdgeWeightTransformer implements Transformer<Edge, Double> {
        private String weightPropertyKey;

        public EdgeWeightTransformer(String weightPropertyKey) {
            this.weightPropertyKey = weightPropertyKey;
        }

        public Double transform(Edge edge) {
            Object object = edge.getProperty(this.weightPropertyKey);
            if(object instanceof Number) {
                return ((Number)object).doubleValue();
            } else {
                return 0.0d;
            }
        }
    }

}
