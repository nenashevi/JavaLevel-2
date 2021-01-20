package lesson_3_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AppMain {
    public static void main(String[] args) {
        // Повторения: Екатеринбург - 4, Астрахань - 3, Саратов -2, Санкт-Петербург -2
        String[] words = {"Москва", "Астрахань", "Екатеринбург", "Санкт-Петербург", "Омск", "Тверь", "Саратов", "Владивосток",
                "Астрахань", "Екатеринбург", "Санкт-Петербург", "Иркутск", "Саратов", "Екатеринбург", "Астрахань", "Казань",
                "Ялта", "Самара", "Ярославль", "Екатеринбург"};


        System.out.println(writeWords(words));

    }

    public static Map<String, Integer> writeWords (String[] words) {
        Map<String, Integer> words2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words2.get(words[i]) != null) {
                int number = words2.get(words[i]) + 1;
                words2.put(words[i], number);
            } else {
                words2.put(words[i], 1);
            }
        }
        return words2;

    }


}
