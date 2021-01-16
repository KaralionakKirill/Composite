package com.epam.compositetask.composite.impl;

import com.epam.compositetask.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    List<Component> list = new ArrayList<>();

    public Composite() {
    }

    public Composite(List<Component> list) {
        this.list = list;
    }

    @Override
    public String buildStr() {
        StringBuilder str = new StringBuilder();
        for (Component component : list) {
            str.append(component.buildStr());
            if (!(component instanceof Letter)) {
                str.append(" ");
            }
        }
        return str.toString();
    }

    @Override
    public Component getChild(int index) {
        return list.get(index);
    }

    @Override
    public List<Component> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public void remove(Component component) {
        list.remove(component);
    }

    @Override
    public int count() {
        return list.size();
    }
}
