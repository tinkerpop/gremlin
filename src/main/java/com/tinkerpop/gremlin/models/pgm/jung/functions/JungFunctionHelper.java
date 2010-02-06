package com.tinkerpop.gremlin.models.pgm.jung.functions;

import com.tinkerpop.gremlin.models.pgm.Edge;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ChainedTransformer;

import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctionHelper {

    public Transformer<Edge, Double> edgeLabelWeightTransformer(Set<String> labels, boolean filter, String weightPropertyKey) {
        return new ChainedTransformer<Edge, Double>(new Transformer[]{new EdgeLabelTransformer(labels, filter), new EdgeWeightTransformer(weightPropertyKey)});
    }

    public class EdgeLabelTransformer implements Transformer<Edge, Edge> {
        private Set<String> labels;
        private boolean filter;

        public EdgeLabelTransformer(Set<String> labels, boolean filter) {
            this.labels = labels;
            this.filter = filter;
        }

        public Edge transform(Edge edge) {
            if (labels.contains(edge.getLabel())) {
                if (filter) {
                    return null;
                } else {
                    return edge;
                }
            } else {
                if (filter) {
                    return edge;
                } else {
                    return null;
                }
            }
        }
    }

    public class EdgeWeightTransformer implements Transformer<Edge, Double> {
        private String weightPropertyKey;

        public EdgeWeightTransformer(String weightPropertyKey) {
            this.weightPropertyKey = weightPropertyKey;
        }

        public Double transform(Edge edge) {
            if (null != edge) {
                Object object = edge.getProperty(this.weightPropertyKey);
                if (object instanceof Number) {
                    return ((Number) object).doubleValue();
                } else {
                    return 0.0d;
                }
            } else {
                return 0.0;
            }
        }
    }

}
