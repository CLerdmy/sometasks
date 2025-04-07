package dev.clerdmy.sometasks.examcommittee.basic;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    /**
     * Принимает массив строк и временной слот. Возвращает число свободных членов экзаменационной комиссии в заданный слот.
     *
     * @param records Массив записей.
     * @param slot Временной слот.
     * @return Число свободных членов экзаменационной комиссии.
     */

    public int solve(List<String> records, int slot) {
        int recordsNumber = records.size();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Pattern pattern = Pattern.compile("\\d+");

        //парсинг и подсчет
        for (String record : records) {
            Matcher matcher = pattern.matcher(record);
            while (matcher.find()) {
                String matchedNumber = matcher.group();
                int number = Integer.parseInt(matchedNumber);
                hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
            }
        }

        return recordsNumber - hashMap.getOrDefault(slot, 0);
    }
}
