package dev.clerdmy.sometasks.examcommittee.structured;

import java.util.*;


public class TerminalInterface {

    private ExamCommittee examCommittee;
    private Scanner scanner;

    public TerminalInterface(List<String> initialRecords) {
        this.examCommittee = new ExamCommittee(initialRecords);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addScheduleRecord();
                    break;
                case "2":
                    findFreeExaminers();
                    break;
                case "3":
                    printAllExaminers();
                    break;
                case "0":
                    System.out.println("Выполняется выход...");
                    return;
                default:
                    System.out.println("Некорректный ввод.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nУправление экзаменационной комиссией:");
        System.out.println("1. Добавить запись");
        System.out.println("2. Найти свободных членов экзаменационной комиссии в данный слот");
        System.out.println("3. Вывести всех членов экзаменационной комиссии");
        System.out.println("0. Выход");
        System.out.print("Выберите вариант: ");
    }


    private void addScheduleRecord() {
        System.out.print("Введите запись (например, Иванов Петр Сидорович: 1, 2, 5): ");
        String record = scanner.nextLine();
        Examiner examiner = ScheduleParser.parseRecord(record);
        examCommittee.addExaminer(examiner);
        System.out.println("Запись добавлена.");
    }

    private void findFreeExaminers() {
        System.out.print("Введите временной слот: ");
        try {
            int slot = Integer.parseInt(scanner.nextLine());
            int freeCount = examCommittee.countFreeExaminers(slot);
            System.out.println("Число свободных членов экзаменационной комиссии во временном слоте " + slot + ": " + freeCount);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод.");
        }
    }

    private void printAllExaminers() {
        System.out.println("\nВсе члены экзаменационной комиссии:");
        for (Examiner examiner : examCommittee.getExaminers()) {
            System.out.println(examiner);
        }
    }

    public static void main(String[] args) {
        List<String> records = new ArrayList<>();
        records.add("Иванов Петр Сидорович: 1, 2, 5");
        records.add("Премудрая Василиса Кощеевна: 1, 3, 5, 6");

        TerminalInterface terminal = new TerminalInterface(records);
        terminal.run();
    }

}
