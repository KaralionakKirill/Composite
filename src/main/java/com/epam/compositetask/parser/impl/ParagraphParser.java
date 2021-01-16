package com.epam.compositetask.parser.impl;

import com.epam.compositetask.composite.impl.Composite;
import com.epam.compositetask.constant.ParserConstant;
import com.epam.compositetask.parser.Parser;

public class ParagraphParser implements Parser {
    private final Parser successor = new SentenceParser();

    @Override
    public Composite parse(String line) {
        Composite composite = new Composite();
        String[] arr = line.split(ParserConstant.PARAGRAPH_SPLIT);
        for (String par : arr) {
            if(par.length() > 0){
                Composite paragraph = successor.parse(par);
                composite.add(paragraph);
            }
        }
        return composite;
    }
}
