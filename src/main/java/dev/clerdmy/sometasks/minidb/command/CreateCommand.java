package dev.clerdmy.sometasks.minidb.command;

import dev.clerdmy.sometasks.minidb.core.Column;
import dev.clerdmy.sometasks.minidb.core.DataBase;
import dev.clerdmy.sometasks.minidb.types.DataType;

import java.util.ArrayList;
import java.util.List;

public class CreateCommand implements Command {

    private final DataBase dataBase;
    private final String input;

    public CreateCommand(DataBase dataBase, String input) {
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
        String[] columnDefs = tokens[2].split("\\s+");

        List<Column> columns = new ArrayList<>();
        for (String def : columnDefs) {
            String[] parts = def.split(":");
            if (parts.length != 2) {
                System.out.println("Wrong syntax.");
                return;
            }
            columns.add(new Column(parts[0], DataType.valueOf(parts[1])));
        }

        dataBase.createTable(tableName, columns);
    }

}
