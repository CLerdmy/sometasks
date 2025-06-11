package dev.clerdmy.sometasks.stacktask;

import java.util.Stack;

public class Solution {

    public boolean isPossibleSequence(String sequence, int n) {

        Stack<Integer> stack = new Stack<>();
        int pushCounter = 0;

        for (int i = 0; i < sequence.length();) {
            int current = Character.getNumericValue(sequence.charAt(i));
            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                i++;
            } else {
                if (pushCounter > n) return false;
                stack.push(pushCounter);
                pushCounter++;
            }
        }
        return stack.isEmpty();
    }

}
