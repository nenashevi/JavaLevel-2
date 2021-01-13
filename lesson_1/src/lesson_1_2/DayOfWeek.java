package lesson_1_2;

public enum DayOfWeek {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
    int index;
    DayOfWeek(int index) {
        this.index = index;
    }
}
