package ru.databasePetProject.RestAppUniversityProject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "culture_house")
public class CultureHouse {
    @Column(name = "id_culture_house")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idCultureHouse;
    @NonNull
    @Column(name = "address")
    private String address;
    @Column(name = "rating")
    private double rating;
    @Column(name = "schedule")
    private String schedule;

    @OneToOne()
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    private University universityOwner;

    @OneToMany(mappedBy = "cultureHouseOwner", cascade = CascadeType.PERSIST)
    private List<CultureHouseActivity> cultureHouseActivities;
    public CultureHouse(String address, double rating, String schedule, University universityOwner) {
        this.address = address;
        this.rating = rating;
        this.schedule = schedule;
        this.universityOwner = universityOwner;
    }
}