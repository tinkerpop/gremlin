package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.gremlin.functions.g.graph.GraphFunctionHelper;
import org.apache.commons.collections15.Transformer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctionHelper {

    public static Set<String> makeSetList(List list) {
        Set<String> set = null;
        if (null != list) {
            set = new HashSet<String>();
            for (Object label : list) {
                if (label instanceof String) {
                    set.add((String) label);
                }
            }
        }
        return set;
    }

    public static Transformer<Edge, Number> makeTransformer(Set<String> labels, Boolean filterLabels, Number filterValue, Boolean probability, String weightKey, Boolean normalizeWeights, Boolean invertWeights) {
        if (labels != null && weightKey != null) {
            return new EdgeLabelWeightTransformer(labels, filterLabels, weightKey, normalizeWeights, invertWeights);
        } else if (labels != null) {
            return new EdgeLabelTransformer(labels, filterLabels, filterValue, probability);
        } else if (weightKey != null) {
            return new EdgeWeightTransformer(weightKey, normalizeWeights, invertWeights);
        } else {
            return null;
        }
    }

    public static class EdgeLabelWeightTransformer implements Transformer<Edge, Number> {
        private Set<String> labels;
        private Boolean filterLabels;
        private String weightKey;
        private Boolean normalizeWeights;
        private Boolean invertWeights;

        public EdgeLabelWeightTransformer(Set<String> labels, Boolean filterLabels, String weightKey, Boolean normalizeWeights, Boolean invertWeights) {
            this.labels = labels;
            if (null == filterLabels)
                this.filterLabels = false;
            else
                this.filterLabels = filterLabels;
            this.weightKey = weightKey;
            if (null == normalizeWeights)
                this.normalizeWeights = false;
            else
                this.normalizeWeights = normalizeWeights;
            if (null == invertWeights)
                this.invertWeights = false;
            else
                this.invertWeights = invertWeights;

        }

        public Double transform(Edge edge) {
            if (labels.contains(edge.getLabel())) {
                if (filterLabels) {
                    return 0.0d;
                } else {
                    Object object = edge.getProperty(this.weightKey);
                    if (object instanceof Number) {
                        Double weight = ((Number) object).doubleValue();
                        if (this.invertWeights)
                            weight = 1 / weight;
                        if (this.normalizeWeights) {
                            return weight / GraphFunctionHelper.totalWeight(GraphFunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filterLabels), this.weightKey);
                        } else {
                            return weight;
                        }
                    } else {
                        return 0.0d;
                    }
                }
            } else {
                if (filterLabels) {
                    Object object = edge.getProperty(this.weightKey);
                    if (object instanceof Number) {
                        Double weight = ((Number) object).doubleValue();
                        if (this.invertWeights)
                            weight = 1 / weight;
                        if (this.normalizeWeights) {
                            return weight / GraphFunctionHelper.totalWeight(GraphFunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filterLabels), this.weightKey);
                        } else {
                            return weight;
                        }
                    } else {
                        return 0.0d;
                    }
                } else {
                    return 0.0d;
                }
            }
        }
    }

    public static class EdgeLabelTransformer implements Transformer<Edge, Number> {
        private Set<String> labels;
        private Boolean filter;
        private Number filterValue;
        private Boolean probability;

        public EdgeLabelTransformer(Set<String> labels, Boolean filterLabels, Number filterValue, Boolean probability) {
            this.labels = labels;
            if (null == filterLabels)
                this.filter = false;
            else
                this.filter = filterLabels;
            this.filterValue = filterValue;
            this.probability = probability;
        }

        public Number transform(Edge edge) {
            if (labels.contains(edge.getLabel())) {
                if (filter) {
                    return this.filterValue;
                } else {
                    if (this.probability) {
                        List<Edge> allowedEdges = GraphFunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filter);
                        return 1.0d / allowedEdges.size();
                    } else {
                        return 1.0d;
                    }
                }
            } else {
                if (filter) {
                    if (this.probability) {
                        List<Edge> allowedEdges = GraphFunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filter);
                        return 1.0d / allowedEdges.size();
                    } else {
                        return 1.0d;
                    }
                } else {
                    return this.filterValue;
                }
            }
        }

    }

    public static class EdgeWeightTransformer implements Transformer<Edge, Number> {
        private String weightKey;
        private Boolean normalize;
        private Boolean invert;

        public EdgeWeightTransformer(String weightKey, Boolean normalizeWeights, Boolean invertWeights) {
            this.weightKey = weightKey;
            if (null == normalizeWeights)
                this.normalize = false;
            else
                this.normalize = normalizeWeights;
            if (null == invertWeights)
                this.invert = false;
            else
                this.invert = invertWeights;
        }

        public Double transform(Edge edge) {
            Object object = edge.getProperty(this.weightKey);
            if (object instanceof Number) {
                Double weight = ((Number) object).doubleValue();
                if (this.invert)
                    weight = 1.0d / weight;
                if (this.normalize) {
                    return weight / GraphFunctionHelper.totalWeight(edge.getOutVertex().getOutEdges(), this.weightKey);
                } else {
                    return weight;
                }
            } else {
                return 0.0d;
            }

        }
    }

}
