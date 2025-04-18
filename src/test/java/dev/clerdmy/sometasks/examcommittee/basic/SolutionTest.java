package dev.clerdmy.sometasks.examcommittee.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    void whenNumsNineAndMaxOperationsTwoThenMinimumSizeThree() {
        List<String> records = new ArrayList<>();
        int slot = 3;
        records.add("Иванов Петр Сидорович: 1, 2, 5");
        records.add("Премудрая Василиса Кощеевна: 1, 3, 5, 6");

        int expected = 1;

        assertEquals(expected, solution.solve(records, slot), "Wrong answer!");
    }

    @Test
    void whenNumsNineAndMaxOperationsTwoThenMinimumSizeThree1() {
        List<String> records = new ArrayList<>();
        int slot = 4;
        records.add("Иванов Петр Сидорович: 1, 2, 5");
        records.add("Премудрая Василиса Кощеевна: 1, 3, 5, 6");

        int expected = 2;

        assertEquals(expected, solution.solve(records, slot), "Wrong answer!");
    }

    @Test
    void whenNumsNineAndMaxOperationsTwoThenMinimumSizeThree3() {
        List<String> records = new ArrayList<>();
        int slot = 5;
        records.add("Иванов Петр Сидорович: 1, 2, 5");
        records.add("Премудрая Василиса Кощеевна: 1, 3, 5, 6");

        int expected = 0;

        assertEquals(expected, solution.solve(records, slot), "Wrong answer!");
    }

}