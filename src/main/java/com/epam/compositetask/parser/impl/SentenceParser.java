package com.epam.compositetask.parser.impl;

import com.epam.compositetask.composite.impl.Composite;
import com.epam.compositetask.constant.ParserConstant;
import com.epam.compositetask.parser.Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {
    private final Parser successor = new WordParser();

    @Override
    public Composite parse(String line) {
        Composite composite = new Composite();
        Pattern pattern = Pattern.compile(ParserConstant.SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            Composite sentence = successor.parse(matcher.group());
            composite.add(sentence);
        }
        return composite;
    }
}
