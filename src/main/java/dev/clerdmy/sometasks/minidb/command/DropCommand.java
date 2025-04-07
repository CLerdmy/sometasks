package dev.clerdmy.sometasks.minidb.command;

import dev.clerdmy.sometasks.minidb.core.DataBase;

public class DropCommand implements Command {

    private final DataBase dataBase;
    private final String input;

    public DropCommand(DataBase dataBase, String input) {
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
        dataBase.dropTable(tableName);
    }

}
