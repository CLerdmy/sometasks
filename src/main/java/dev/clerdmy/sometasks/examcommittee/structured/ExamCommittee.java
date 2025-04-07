package dev.clerdmy.sometasks.examcommittee.structured;

import java.util.*;


public class ExamCommittee {

    private List<Examiner> examiners;

    public ExamCommittee(List<String> records) {
        this.examiners = ScheduleParser.parseSchedule(records);
    }

    public void addExaminer(Examiner examiner) {
        examiners.add(examiner);
    }

    public int countFreeExaminers(int slot) {
        int count = 0;
        for (Examiner examiner : examiners) {
            if (examiner.isFree(slot)) {
                count++;
            }
        }
        return count;
    }

    public List<Examiner> getExaminers() {
        return examiners;
    }
}
