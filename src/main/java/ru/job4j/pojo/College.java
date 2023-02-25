package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иван Иванович Иванов");
        student.setGroup(11);
        student.setDateOfAdmission(LocalDate.now());
        String ln = System.lineSeparator();
        System.out.println("Студент: "
                + student.getFullName() + "." + ln + "Группа: "
                + student.getGroup() + "." + ln + "Дата поступления: "
                + student.getDateOfAdmission() + ".");
    }
}
