package dev.clerdmy.sometasks.examcommittee.structured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleParserTest {

    private List<String> records;

    @BeforeEach
    void setUp() {
        records = new ArrayList<>();
        records.add("Иванов Петр Сидорович: 1, 2, 5");
        records.add("Премудрая Василиса Кощеевна: 1, 3, 5, 6");
    }

    @Test
    void parseSchedule() throws Exception {
        List<Examiner> examiners = ScheduleParser.parseSchedule(records);
        Examiner examiner1 = examiners.get(0);
        Examiner examiner2 = examiners.get(1);

        assertEquals("Иванов Петр Сидорович", examiner1.toString());
        assertEquals("Премудрая Василиса Кощеевна", examiner2.toString());

        Set<Integer> expected1 = new HashSet<>();
        expected1.add(1);
        expected1.add(2);
        expected1.add(5);
        Set<Integer> expected2 = new HashSet<>();
        expected2.add(1);
        expected2.add(3);
        expected2.add(5);
        expected2.add(6);

        Field busySlotsField = Examiner.class.getDeclaredField("busySlots");
        busySlotsField.setAccessible(true);

        Set<Integer> busySlots1 = (Set<Integer>) busySlotsField.get(examiner1);
        Set<Integer> busySlots2 = (Set<Integer>) busySlotsField.get(examiner2);

        assertEquals(expected1, busySlots1);
        assertEquals(expected2, busySlots2);
    }
}