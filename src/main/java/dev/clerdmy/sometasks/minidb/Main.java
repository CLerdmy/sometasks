package dev.clerdmy.sometasks.minidb;

import dev.clerdmy.sometasks.minidb.command.CommandProcessor;
import dev.clerdmy.sometasks.minidb.core.DataBase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DataBase db = new DataBase();
        CommandProcessor processor = new CommandProcessor(db);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (!processor.process(input)) break;
        }

        System.out.println("End...");

    }

}
