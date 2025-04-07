package dev.clerdmy.sometasks.minidb.core;

import java.util.List;

public class Row {

    private final List<Object> values;

    public Row(List<Object> values) {
        this.values = values;
    }

    public List<Object> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return values.toString();
    }

}
