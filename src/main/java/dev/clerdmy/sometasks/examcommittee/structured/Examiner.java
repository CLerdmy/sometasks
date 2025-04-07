package dev.clerdmy.sometasks.examcommittee.structured;

import java.util.*;


public class Examiner {

    private String fullName;
    private Set<Integer> busySlots;

    public Examiner(String fullName, List<Integer> slots) {
        this.fullName = fullName;
        this.busySlots = new HashSet<>(slots);
    }

    public boolean isFree(int slot) {
        return !busySlots.contains(slot);
    }

    @Override
    public String toString() {
        return fullName;
    }

}
