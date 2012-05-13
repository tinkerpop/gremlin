package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.impls.sail.SailGraph

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SailGraphLoader {

    public static void load() {

        SailGraph.metaClass.uri {final String prefix ->
            return ((SailGraph) delegate).expandPrefix(prefix)
        }

        SailGraph.metaClass.qn {final String uri ->
            return ((SailGraph) delegate).prefixNamespace(uri)
        }

        SailGraph.metaClass.loadRDF = {final def fileObject, final String format ->
            try {
                ((SailGraph) delegate).loadRDF(new URL(fileObject).openStream(), "", format, null);
            } catch (MalformedURLException e) {
                ((SailGraph) delegate).loadRDF(new FileInputStream(fileObject), "", format, null);
            }
        }
    }
}
