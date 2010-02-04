package com.tinkerpop.gremlin.statements;

import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class TokensTest extends TestCase {

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

    public void testNonWhitespaceRegEx() {
        assertTrue(".".matches(Tokens.NONWHITESPACE_REGEX));
        assertTrue("/".matches(Tokens.NONWHITESPACE_REGEX));
        assertTrue("a".matches(Tokens.NONWHITESPACE_REGEX));
        assertTrue("$".matches(Tokens.NONWHITESPACE_REGEX));
        assertTrue("x".matches(Tokens.NONWHITESPACE_REGEX));
        assertFalse(" ".matches(Tokens.NONWHITESPACE_REGEX));
        assertFalse("   ".matches(Tokens.NONWHITESPACE_REGEX));
        assertFalse("/t".matches(Tokens.NONWHITESPACE_REGEX));
    }
}
