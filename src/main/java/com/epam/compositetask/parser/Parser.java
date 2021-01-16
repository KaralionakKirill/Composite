package com.epam.compositetask.parser;

import com.epam.compositetask.composite.impl.Composite;

public interface Parser {
    Composite parse(String line);
}
