package dev.clerdmy.sometasks.examcommittee.structured;

import dev.clerdmy.sometasks.examcommittee.basic.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerTest {

    private Examiner examiner;

    @BeforeEach
    public void setUp() {
        String fullName = "Иванов Петр Сидорович";
        List<Integer> slots = List.of(1,2,5);
        examiner = new Examiner(fullName, slots);
    }

    @Test
    void isFree() {
        assertFalse(examiner.isFree(1));
        assertFalse(examiner.isFree(5));
        assertTrue(examiner.isFree(3));
        assertTrue(examiner.isFree(6));
    }

    @Test
    void testToString() {
        assertEquals("Иванов Петр Сидорович", examiner.toString());
    }
}