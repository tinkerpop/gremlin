package com.tinkerpop.gremlin.compiler.util;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StringHelper {

    private static final String EMPTY_STRING = "";
    private static final char DOUBLE_QUOTE = '"';
    private static final char SINGLE_QUOTE = '\'';

    public static String clearQuotes(String string) {
        String result = EMPTY_STRING;
        for (int i = 0; i < string.length(); i++) {
            final Character currentCharacter = string.charAt(i);
            if ((i == 0 || i == string.length() - 1) && (currentCharacter.equals(DOUBLE_QUOTE) || currentCharacter.equals(SINGLE_QUOTE)))
                continue;
            result += string.charAt(i);
        }
        return result;
    }
}
