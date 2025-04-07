package dev.clerdmy.sometasks.minidb.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

    private final Map<String, Table> tables = new HashMap<>();

    public void createTable(String name, List<Column> columns) {
        tables.put(name, new Table(name, columns));
    }

    public Table getTable(String name) {
        return tables.get(name);
    }

    public void dropTable(String name) {
        tables.remove(name);
    }

    public boolean tableExists(String name) {
        return tables.containsKey(name);
    }

    public Collection<Table> getAllTables() {
        return tables.values();
    }

}
