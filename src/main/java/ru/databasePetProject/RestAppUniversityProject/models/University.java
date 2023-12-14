package ru.databasePetProject.RestAppUniversityProject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "university")
public class University {
    @Column(name = "id_university")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversity;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private double rating;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "government_funding")
    private boolean hasGovernmentFunding;

    @Column(name = "military_center")
    private boolean hasMilitaryCenter;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.PERSIST)
    private List<Dormitory> dormitories;
    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.PERSIST)
    private List<DiningRoom> diningRooms;
    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.PERSIST)
    private List<Gym> gyms;
    @JsonIgnore
    @OneToOne(mappedBy = "universityOwner")
    private CultureHouse cultureHouse;
    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner")
    private List<Faculty> faculties;

    public University(String name,
                      String address,
                      double rating,
                      String description,
                      boolean hasMilitaryCenter,
                      boolean hasGovernmentFunding,
                      String website,
                      List<Dormitory> dormitories,
                      List<DiningRoom> diningRooms,
                      List<Gym> gyms,
                      CultureHouse cultureHouse,
                      List<Faculty> faculties) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.description = description;
        this.hasMilitaryCenter = hasMilitaryCenter;
        this.hasGovernmentFunding = hasGovernmentFunding;
        this.website = website;
        this.dormitories = dormitories;
        this.diningRooms = diningRooms;
        this.gyms = gyms;
        this.cultureHouse = cultureHouse;
        this.faculties = faculties;
    }

    @Transient
    public int getDormitoriesCount() {
        return (dormitories != null) ? dormitories.size() : 0;
    }


}
