package dev.clerdmy.sometasks.stacktask;

import dev.clerdmy.sometasks.stacktask.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    void test1() {
        String sequence = "3425170986";
        int n = 9;
        assertFalse(solution.isPossibleSequence(sequence, n));
    }

    @Test
    void test2() {
        String sequence = "1230547869";
        int n = 9;
        assertTrue(solution.isPossibleSequence(sequence, n));
    }

    @Test
    void test3() {
        String sequence = "2103456789";
        int n = 9;
        assertTrue(solution.isPossibleSequence(sequence, n));
    }

    @Test
    void test4() {
        String sequence = "4532671098";
        int n = 9;
        assertTrue(solution.isPossibleSequence(sequence, n));
    }

    @Test
    void test5() {
        String sequence = "0365427918";
        int n = 9;
        assertFalse(solution.isPossibleSequence(sequence, n));
    }

}