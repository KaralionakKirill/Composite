package com.epam.compositetask.parser.impl;

import com.epam.compositetask.composite.impl.Composite;
import com.epam.compositetask.composite.impl.Letter;
import com.epam.compositetask.parser.Parser;

public class LetterParser implements Parser {
    @Override
    public Composite parse(String line) {
        Composite composite = new Composite();
        char[] chars = line.toCharArray();
        for (Character c : chars) {
            composite.add(new Letter(c));
        }
        return composite;
    }
}
