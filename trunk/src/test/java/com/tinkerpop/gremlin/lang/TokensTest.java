package com.tinkerpop.gremlin.lang;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class TokensTest extends BaseTest {

    public void testWhiteSpaceRegEx() {
        assertTrue(" ".matches(Tokens.WHITESPACE_REGEX));
        assertTrue("    ".matches(Tokens.WHITESPACE_REGEX));
        assertTrue("     ".matches(Tokens.WHITESPACE_REGEX));
        assertTrue("     ".matches(Tokens.WHITESPACE_REGEX));
        assertTrue("         ".matches(Tokens.WHITESPACE_REGEX));
        assertFalse(" a   ".matches(Tokens.WHITESPACE_REGEX));
        assertFalse(" \n".matches(Tokens.WHITESPACE_REGEX));
    }

    public void testVariableRegEx() {
        assertTrue("$i".matches(Tokens.VARIABLE_REGEX));
        assertTrue("$a0Z".matches(Tokens.VARIABLE_REGEX));
        assertFalse("$9AB".matches(Tokens.VARIABLE_REGEX));
        assertTrue("$_ab0912".matches(Tokens.VARIABLE_REGEX));
        assertTrue("$_".matches(Tokens.VARIABLE_REGEX));
        assertTrue("$_last".matches(Tokens.VARIABLE_REGEX));
        assertFalse("$123".matches(Tokens.VARIABLE_REGEX));
        assertFalse("a0Z".matches(Tokens.VARIABLE_REGEX));
    }
}
