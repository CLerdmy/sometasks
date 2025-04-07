package dev.clerdmy.sometasks.minidb.command;

import dev.clerdmy.sometasks.minidb.core.DataBase;

public class CommandProcessor {

    private final DataBase dataBase;

    public CommandProcessor(DataBase db) {
        this.dataBase = db;
    }

    public boolean process(String input) {
        if (input.startsWith("/create")) {
            new CreateCommand(dataBase, input).execute();
        } else if (input.startsWith("/insert")) {
            new InsertCommand(dataBase, input).execute();
        } else if (input.startsWith("/delete")) {
            new DeleteCommand(dataBase, input).execute();
        } else if (input.startsWith("/drop")) {
            new DropCommand(dataBase, input).execute();
        } else if (input.startsWith("/show")) {
            new ShowCommand(dataBase, input).execute();
        } else if (input.startsWith("/exit")) {
            return false;
        } else {
            System.out.println("Unknown command");
        }
        return true;
    }

}
