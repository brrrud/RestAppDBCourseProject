package ru.databasePetProject.RestAppUniversityProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "gym")
public class Gym {
    @Column(name = "id_gym")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idGym;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "rating")
    @NotNull
    private double rating;

    @Column(name = "schedule")
    private String schedule;

    @ManyToOne
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    private University universityOwner;

    @OneToMany(mappedBy = "gymOwner", cascade = CascadeType.PERSIST)
    private List<GymActivity> gymActivities;

    public Gym(String address, double rating, String schedule, University universityOwner) {
        this.address = address;
        this.rating = rating;
        this.schedule = schedule;
        this.universityOwner = universityOwner;
    }
}
