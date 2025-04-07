package dev.clerdmy.sometasks.minidb.command;

import dev.clerdmy.sometasks.minidb.core.DataBase;
import dev.clerdmy.sometasks.minidb.core.Row;
import dev.clerdmy.sometasks.minidb.core.Table;

import java.util.List;

public class ShowCommand implements Command {

    private final DataBase dataBase;
    private final String input;

    public ShowCommand(DataBase dataBase, String input) {
        this.dataBase = dataBase;
        this.input = input;
    }

    @Override
    public void execute() {
        String[] tokens = input.split("\\s+");
        if (tokens.length != 2) {
            System.out.println("Wrong syntax.");
            return;
        }

        String tableName = tokens[1];
        Table table = dataBase.getTable(tableName);
        List<Row> rows = table.getRows();
        for (Row row : rows) {
            System.out.println(row.toString());
        }
    }

}
