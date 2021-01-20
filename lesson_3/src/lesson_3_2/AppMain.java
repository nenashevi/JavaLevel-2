package lesson_3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMain {
    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();

        // Демонстрация работы методов add, get
        System.out.println("Телефонные номера для фамилии Иванов: " + pb.get("Иванов"));
        pb.add("Иванов", "+7 923 425 22 69");
        System.out.println("Телефонные номера для фамилии Иванов: " + pb.get("Иванов"));
        pb.add("Иванов", "+7 934 835 73 98");
        System.out.println("Телефонные номера для фамилии Иванов: " + pb.get("Иванов"));
        System.out.println("Телефонные номера для фамилии Петров: " + pb.get("Петров"));
        pb.add("Петров", "+7 111 111 11 11");
        System.out.println("Телефонные номера для фамилии Петров: " + pb.get("Петров"));
        pb.add("Петров", "+7 222 222 22 22");
        System.out.println("Телефонные номера для фамилии Петров: " + pb.get("Петров"));


    }
}
