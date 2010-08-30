package com.tinkerpop.gremlin.functions.jung;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import org.apache.commons.collections15.Transformer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class JungFunctionHelper {
    static final String ALPHA = "alpha";
    static final String LABELS = "labels";
    static final String FILTER = "filter";
    static final String WEIGHT_KEY = "weight-key";
    static final String NORMALIZE = "normalize";
    static final String INVERT = "invert";

    public static Set<String> makeSetList(final List list) {
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

    public static Transformer<Edge, Number> makeTransformer(final Set<String> labels, final Boolean filterLabels, final Number filterValue, final Boolean probability, final String weightKey, final Boolean normalizeWeights, final Boolean invertWeights) {
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

        public EdgeLabelWeightTransformer(final Set<String> labels, final Boolean filterLabels, final String weightKey, final Boolean normalizeWeights, final Boolean invertWeights) {
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

        public Double transform(final Edge edge) {
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
                            return weight / FunctionHelper.totalWeight(FunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filterLabels), this.weightKey);
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
                            return weight / FunctionHelper.totalWeight(FunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filterLabels), this.weightKey);
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

        public EdgeLabelTransformer(final Set<String> labels, final Boolean filterLabels, final Number filterValue, final Boolean probability) {
            this.labels = labels;
            if (null == filterLabels)
                this.filter = false;
            else
                this.filter = filterLabels;
            this.filterValue = filterValue;
            this.probability = probability;
        }

        public Number transform(final Edge edge) {
            if (labels.contains(edge.getLabel())) {
                if (filter) {
                    return this.filterValue;
                } else {
                    if (this.probability) {
                        List<Edge> allowedEdges = FunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filter);
                        return 1.0d / allowedEdges.size();
                    } else {
                        return 1.0d;
                    }
                }
            } else {
                if (filter) {
                    if (this.probability) {
                        List<Edge> allowedEdges = FunctionHelper.filterEdgeLabels(edge.getOutVertex().getOutEdges(), this.labels, filter);
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

        public EdgeWeightTransformer(final String weightKey, final Boolean normalizeWeights, final Boolean invertWeights) {
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

        public Double transform(final Edge edge) {
            Object object = edge.getProperty(this.weightKey);
            if (object instanceof Number) {
                Double weight = ((Number) object).doubleValue();
                if (this.invert)
                    weight = 1.0d / weight;
                if (this.normalize) {
                    return weight / FunctionHelper.totalWeight(edge.getOutVertex().getOutEdges(), this.weightKey);
                } else {
                    return weight;
                }
            } else {
                return 0.0d;
            }

        }
    }

}
