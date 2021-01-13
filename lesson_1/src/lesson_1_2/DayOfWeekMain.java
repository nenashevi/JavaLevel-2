package lesson_1_2;

public class DayOfWeekMain {
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.MONDAY;

        getWorkingHours(day);
        day = DayOfWeek.FRIDAY;
        getWorkingHours(day);
        day = DayOfWeek.SATURDAY;
        getWorkingHours(day);
    }
    public static int getWorkingHours(DayOfWeek day) {
        int workHours =0;

        if (day.index == 6 || day.index == 7) {
            System.out.println("Сегодня выходной");
            return workHours;
        }
        workHours = 8 * (6 - day.index);
        System.out.println("Количество рабочих часов до конца недели равно: " + workHours);
        return workHours;
    }
}
