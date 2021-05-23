package com.ssu.Kuzmin.SportCentre.entity;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
public class Trainer extends User {

    @Column(name = "salary", nullable = false)
    private int salary;

    @OneToOne(mappedBy = "trainer")
    private Lesson lesson;

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public Lesson getLesson() { return lesson; }
    public void setLesson(Lesson lesson) { this.lesson = lesson; }
}
