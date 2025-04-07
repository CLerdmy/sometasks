package dev.clerdmy.sometasks.minidb.command;

import dev.clerdmy.sometasks.minidb.core.DataBase;
import dev.clerdmy.sometasks.minidb.core.Table;

import java.util.List;

public class InsertCommand implements Command {

    private final DataBase dataBase;
    private final String input;

    public InsertCommand(DataBase dataBase, String input) {
        this.dataBase = dataBase;
        this.input = input;
    }

    @Override
    public void execute() {
        String[] tokens = input.split("\\s+", 3);
        if (tokens.length < 3) {
            System.out.println("Wrong syntax.");
            return;
        }

        String tableName = tokens[1];
        List<String> values = List.of(tokens[2].split("\\s+"));

        Table table = dataBase.getTable(tableName);
        if (table == null) {
            System.out.println("Table not found: " + tableName);
            return;
        }

        try {
            table.insert(values);
        } catch (Exception e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

}
