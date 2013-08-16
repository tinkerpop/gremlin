package com.tinkerpop.gremlin.groovy.console;

/**
 * Those wanting to extend the Gremlin Console can extend this class to provide custom imports and extension
 * methods to the language itself.  Gremlin Console uses ServiceLoader to install plugins.  It is necessary for
 * projects wishing to extend the Console to include a com.tinkerpop.gremlin.groovy.console.ConsolePlugin file in
 * META-INF/services of their packaged project which includes the full class names of the implementations of this
 * interface to install.
 *
 * @author Stephen Mallette (http://stephen.genoprime.com)
 */
public interface ConsolePlugin {

    /**
     * The name of the plugin.  This name should be unique as naming clashes will prevent proper plugin operations.
     */
    String getName();

    /**
     * Implementors will typically execute imports of classes within their project that they want available in the
     * console.  They may use groovy meta programming to introduce new extensions to the Gremlin.
     */
    void pluginTo(final ConsoleGroovy groovy, final ConsoleIO io);
}
