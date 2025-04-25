package dev.clerdmy.sometasks.freeintervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    void test1() {
        List<String> schedules = new ArrayList<>();
        schedules.add("Сидоров Алексей Петрович: 10-11, 15-18");
        schedules.add("Ким Марат Николаевич: 9-11, 14-15, 17-19");
        int queryStart = 12;
        int queryEnd = 13;

        int expected = 2;

        assertEquals(expected, solution.solve(schedules, queryStart, queryEnd), "Wrong answer!");
    }

    @Test
    void test2() {
        List<String> schedules = new ArrayList<>();
        schedules.add("Сидоров Алексей Петрович: 10-11, 15-18");
        schedules.add("Ким Марат Николаевич: 9-11, 14-15, 17-19");
        int queryStart = 13;
        int queryEnd = 14;

        int expected = 1;

        assertEquals(expected, solution.solve(schedules, queryStart, queryEnd), "Wrong answer!");
    }

    @Test
    void test3() {
        List<String> schedules = new ArrayList<>();
        schedules.add("Сидоров Алексей Петрович: 10-11, 15-18");
        schedules.add("Ким Марат Николаевич: 9-11, 14-15, 17-19");
        int queryStart = 9;
        int queryEnd = 10;

        int expected = 0;

        assertEquals(expected, solution.solve(schedules, queryStart, queryEnd), "Wrong answer!");
    }

}