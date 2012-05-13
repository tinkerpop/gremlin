package com.tinkerpop.gremlin.groovy.branch

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory
import com.tinkerpop.gremlin.groovy.Gremlin
import com.tinkerpop.gremlin.test.ComplianceTest

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SplitMergeStepsTest extends com.tinkerpop.gremlin.test.branch.SplitMergeStepsTest {

    Graph g = TinkerGraphFactory.createTinkerGraph();
    static {
        Gremlin.load();
    }

    public void testCompliance() {
        ComplianceTest.testCompliance(this.getClass());
    }

    public void test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge() {
        super.test_g_v1_out_copySplitXpropertyXnameX__propertyXageXX_fairMerge(g.v(1).out.copySplit(_().name, _().age).fairMerge);
    }

    public void test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge() {
        super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge(g.v(1).out('knows').copySplit(_().name, _().age).exhaustMerge);
    }

    public void test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path() {
        super.test_g_v1_outXknowsX_copySplitXpropertyXnameX__propertyXageXX_exhaustMerge_path(g.v(1).out('knows').copySplit(_().name, _().age).exhaustMerge.path);
    }

    /*public void testPlay() {
        System.out.println(g.v(1).out('knows','created').loop(1){println(it.object.toString() + "!!" + it.loops);it.loops < 3}.toList());
        System.out.println("\n")
        System.out.println(g.v(1).copySplit(_().out('knows'), _().out('created')).fairMerge.loop(2){println(it.object.toString() + "!!" + it.loops); it.loops < 3}.toList());
    }*/
}
