package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иван Иванович Иванов");
        student.setGroup(11);
        student.setDateOfAdmission(LocalDate.now());
        System.out.println("Студент: "
                + student.getFullName() + ".\nГруппа: "
                + student.getGroup() + ".\nДата поступления: "
                + student.getDateOfAdmission() + ".");
    }
}
