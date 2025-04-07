package dev.clerdmy.sometasks.examcommittee.structured;

import java.util.*;
import java.util.regex.*;


public class ScheduleParser {

    private ScheduleParser() {}

    private static List<Integer> getNums(String string) {
        List<Integer> slots = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            slots.add(Integer.parseInt(matcher.group()));
        }
        return slots;
    }

    static Examiner parseRecord(String record) {
        String[] parts = record.split(":");
        String fullName = parts[0].trim();
        String slotsString = parts[1].trim();
        List<Integer> slots = getNums(slotsString);
        return new Examiner(fullName, slots);
    }

    public static List<Examiner> parseSchedule(List<String> records) {
        List<Examiner> examiners = new ArrayList<>();
        for (String record : records) {
            examiners.add(parseRecord(record));
        }
        return examiners;
    }

}
