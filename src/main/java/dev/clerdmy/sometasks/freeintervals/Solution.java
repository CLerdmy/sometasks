package dev.clerdmy.sometasks.freeintervals;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private boolean isAvailable(String schedule, int start, int end) {

        String[] nameAndIntervals = schedule.split(": ");
        String[] intervals = nameAndIntervals[1].split(", ");

        for (String interval : intervals) {
            String[] parts = interval.split("-");
            int intervalStart = Integer.parseInt(parts[0]);
            int intervalEnd = Integer.parseInt(parts[1]);

            if (intervalStart <= end && intervalEnd >= start) return false;
        }

        return true;
    }

    private boolean isAvailableRegex(String schedule, int start, int end) {

        Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
        Matcher matcher = pattern.matcher(schedule);

        while (matcher.find()) {
            int intervalStart = Integer.parseInt(matcher.group(1));
            int intervalEnd = Integer.parseInt(matcher.group(2));

            if (intervalStart <= end && intervalEnd >= start) return false;
        }

        return true;
    }

    public int solve(List<String> schedules, int start, int end) {

        int count = 0;

        for (String schedule : schedules) {
            if (isAvailable(schedule, start, end) && isAvailableRegex(schedule, start, end)) {
                count++;
            }
        }

        return count;
    }

}