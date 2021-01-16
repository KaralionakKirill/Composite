package com.epam.compositetask.composite.impl;

import com.epam.compositetask.composite.Component;

import java.util.List;

public class Punctuation implements Component {
    private final Character punctuation;

    public Punctuation(Character punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String buildStr() {
        return Character.toString(punctuation);
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
