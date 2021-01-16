package com.epam.compositetask.composite.impl;

import com.epam.compositetask.composite.Component;

import java.util.List;

public class Letter implements Component {
    private final Character letter;

    public Letter(Character letter) {
        this.letter = letter;
    }

    @Override
    public String buildStr() {
        return Character.toString(letter);
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public List<Component> getList() {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public int count() {
        return 1;
    }
}
