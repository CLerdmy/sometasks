package dev.clerdmy.sometasks.minidb.core;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final String name;
    private final List<Column> columns;
    private final List<Row> rows = new ArrayList<>();

    public Table(String name, List<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public void insert(List<String> rawValues) {
        if (rawValues.size() != columns.size()) {
            throw new IllegalArgumentException("Wrong number of values");
        }

        List<Object> parsedValues = new ArrayList<>();
        for (int i = 0; i < columns.size(); i++) {
            Column col = columns.get(i);
            parsedValues.add(col.getType().parse(rawValues.get(i)));
        }

        rows.add(new Row(parsedValues));
    }

    public void delete(List<String> rawValues) {
        List<Row> toRemove = new ArrayList<>();

        for (Row row : rows) {
            boolean match = true;
            List<Object> values = row.getValues();

            for (int i = 0; i < rawValues.size(); i++) {
                Object parsed = columns.get(i).getType().parse(rawValues.get(i));
                if (!parsed.equals(values.get(i))) {
                    match = false;
                    break;
                }
            }

            if (match) {
                toRemove.add(row);
            }
        }

        rows.removeAll(toRemove);
    }

    public String getName() {
        return name;
    }

    public List<Row> getRows() {
        return rows;
    }

}
