package dev.clerdmy.sometasks.examcommittee.structured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExamCommitteeTest {

    private ExamCommittee examCommittee;

    @BeforeEach
    public void setUp() {
        List<String> records = new ArrayList<>();
        records.add("Иванов Петр Сидорович: 1, 2, 5");
        records.add("Премудрая Василиса Кощеевна: 1, 3, 5, 6");

        examCommittee = new ExamCommittee(records);
    }

    @Test
    void addExaminer() {
        Examiner newExaminer = new Examiner("Сидоров Иван Петрович", List.of(2, 4));
        int initialSize = examCommittee.getExaminers().size();

        examCommittee.addExaminer(newExaminer);

        assertEquals(initialSize + 1, examCommittee.getExaminers().size());
        assertTrue(examCommittee.getExaminers().contains(newExaminer));
    }

    @Test
    void countFreeExaminers() {
        assertEquals(0, examCommittee.countFreeExaminers(1));
        assertEquals(1, examCommittee.countFreeExaminers(2));
        assertEquals(2, examCommittee.countFreeExaminers(4));
    }
}