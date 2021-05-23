package com.ssu.Kuzmin.SportCentre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gym")
public class Gym implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "beginning", nullable = false)
    private Date beginning;

    @Column(name = "duration", nullable = false)
    private int duration;

    @OneToMany(mappedBy = "gym")
    private List<Lesson> lessons;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getBeginning() { return beginning; }
    public void setBeginning(Date beginning) { this.beginning = beginning; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public List<Lesson> getLessons() { return lessons; }
    public void setLessons(List<Lesson> lessons) { this.lessons = lessons; }
}
