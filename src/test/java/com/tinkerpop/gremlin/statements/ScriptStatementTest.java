package com.tinkerpop.gremlin.statements;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ScriptStatementTest extends TestCase {

    public void testScriptStatementSyntax() {
        assertTrue(ScriptStatement.isStatement("script 'filename.grm'"));
        assertTrue(ScriptStatement.isStatement("script $x        "));
        assertTrue(ScriptStatement.isStatement("  script $x/aPath"));
        assertFalse(ScriptStatement.isStatement("script"));
        assertFalse(ScriptStatement.isStatement("script "));
        assertFalse(ScriptStatement.isStatement("script       "));
    }
}
