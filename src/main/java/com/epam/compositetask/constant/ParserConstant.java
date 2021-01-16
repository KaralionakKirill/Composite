package com.epam.compositetask.constant;

public class ParserConstant {
    public static final String PARAGRAPH_SPLIT = "\\s{4}";
    public static final String SENTENCE_REGEX = "[а-яА-Яa-zA-Z,\\-;'\"\\s]+[.{1,3}?!]";
    public static final String WORD_SPLIT = "\\s";
    public static final String WORD_REGEX = "[а-яА-Яa-zA-Z]+";
    public static final String LEXEME_REGEX = "[а-яА-Яa-zA-Z]+[,.?!]";
}
