package com.epam.compositetask.parser.impl;

import com.epam.compositetask.composite.impl.Composite;
import com.epam.compositetask.composite.impl.Punctuation;
import com.epam.compositetask.constant.ParserConstant;
import com.epam.compositetask.parser.Parser;

public class WordParser implements Parser {
    private final Parser successor = new LetterParser();

    @Override
    public Composite parse(String line) {
        Composite composite = new Composite();
        String[] lexemes = line.split(ParserConstant.WORD_SPLIT);
        for (String lexeme : lexemes) {
            if (lexeme.matches(ParserConstant.WORD_REGEX)) {
                composite.add(successor.parse(lexeme));
            }else if (lexeme.matches(ParserConstant.LEXEME_REGEX)) {
                composite.add(successor.parse(lexeme.substring(0, lexeme.length() - 1)));
                composite.add(new Punctuation(lexeme.charAt(lexeme.length() - 1)));
            }else{
                if(lexeme.length() > 0){
                    composite.add(new Punctuation(lexeme.charAt(lexeme.length() - 1)));
                }
            }
        }
        return composite;
    }
}
