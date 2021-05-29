package com.ssu.Kuzmin.SportCentre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "gym_id", nullable = false)
    private Gym gym;

    @Column(name = "beginning", nullable = false)
    private Date beginning;

    @Column(name = "duration", nullable = false)
    private int duration;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Group getGroup() { return group1; }
    public void setGroup(Group group) { this.group1 = group; }

    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }

    public Gym getGym() { return gym; }
    public void setGym(Gym gym) { this.gym = gym; }

    public Date getBeginning() { return beginning; }
    public void setBeginning(Date beginning) { this.beginning = beginning; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}
