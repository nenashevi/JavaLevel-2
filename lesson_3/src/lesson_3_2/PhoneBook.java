package lesson_3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> persons = new HashMap<>();
    public void add (String name, String phone) {
        if (persons.get(name) != null) {
            List<String> tempPhones = new ArrayList<>(persons.get(name));
            tempPhones.add(phone);
            persons.put(name, tempPhones);
        } else {
            List<String> tempPhones = new ArrayList<>();
            tempPhones.add(phone);
            persons.put(name, tempPhones);
        }
    }
    public List <String> get (String name) {
       List <String> tempPhones = new ArrayList<>();
       tempPhones = persons.get(name);
       return tempPhones;
    }
}
