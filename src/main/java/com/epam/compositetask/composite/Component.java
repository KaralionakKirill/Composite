package com.epam.compositetask.composite;

import java.util.List;

public interface Component {
    String buildStr();

    Component getChild(int index);

    List<Component> getList();

    void add(Component component);

    void remove(Component component);

    int count();
}
