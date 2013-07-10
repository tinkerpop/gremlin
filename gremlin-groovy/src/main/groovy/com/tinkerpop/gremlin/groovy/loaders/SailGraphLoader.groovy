package com.tinkerpop.gremlin.groovy.loaders

import com.tinkerpop.blueprints.impls.sail.SailGraph

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
class SailGraphLoader {

    public static void load() {

        SailGraph.metaClass.uri { final String prefix ->
            return ((SailGraph) delegate).expandPrefix(prefix)
        }

        SailGraph.metaClass.qn { final String uri ->
            return ((SailGraph) delegate).prefixNamespace(uri)
        }

        SailGraph.metaClass.loadRDF = { final def fileObject, final String format ->
            try {
                ((SailGraph) delegate).loadRDF(new URL(fileObject).openStream(), "", format, null);
            } catch (MalformedURLException e) {
                ((SailGraph) delegate).loadRDF(new FileInputStream(fileObject), "", format, null);
            }
        }

        SailGraph.metaClass.saveRDF = { final def fileObject, final String format ->
            if (fileObject instanceof String) {
                ((SailGraph) delegate).saveRDF(new FileOutputStream(new File(fileObject)), format);
            } else if (fileObject instanceof File) {
                ((SailGraph) delegate).saveRDF(new FileOutputStream(fileObject), format);
            } else if (fileObject instanceof OutputStream) {
                ((SailGraph) delegate).saveRDF(fileObject, format);
            }
        }
    }
}
