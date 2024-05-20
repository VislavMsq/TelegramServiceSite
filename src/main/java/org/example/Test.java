package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;


public class Test {
    public static void main(String[] args) {
        List<LocalDateTime> dateTimes = new ArrayList<>();


        dateTimes.add(LocalDateTime.of(2024, 5, 5, 9, 55));

        dateTimes.add(LocalDateTime.of(2024, 5, 5, 10, 5));
        dateTimes.add(LocalDateTime.of(2024, 5, 5, 10, 6));
//        dateTimes.add(LocalDateTime.of(2024, 5, 5, 10, 8));
//        dateTimes.add(LocalDateTime.of(2024, 5, 5, 10, 9));
//        dateTimes.add(LocalDateTime.of(2024, 5, 5, 10, 11));
//        dateTimes.add(LocalDateTime.of(2024, 5, 5, 10, 15));

        System.out.println(avgDates(dateTimes, 20));
    }

    private static int avgDates(List<LocalDateTime> dates, int interval) {
        dates.sort(LocalDateTime::compareTo);
        int j = 0;
        List<Integer> integers = new ArrayList<>();
        while (j<dates.size()-1) {
            long counter = interval;
            int count = 0;
            for (int i = j; i < dates.size()-1; i++) {

                if (counter < 1) {
                    j++;
                    integers.add(count);
                    break;
                }

                counter -= ChronoUnit.MINUTES.between(dates.get(i), dates.get(i+1));
                count++;
            }
            integers.add(count);
            break;
        }
        int result = integers.stream().mapToInt(Integer::intValue).sum();
        return integers.size() == 0 ? 0 : result/integers.size();
    }
}
