package ru.databasePetProject.RestAppUniversityProject.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    @Column(name = "name", unique = true)
    @NotNull
    private String name;

    @Column(name = "address", unique = true)
    @NotNull
    private String address;

    @Column(name = "rating")
    @NotNull
    @DecimalMin(value = "0", message = "Rating must be greater than or equal to 0")
    @DecimalMax(value = "10", message = "Rating must be less than or equal to 10")
    private double rating;

    @Column(name = "email", unique = true)
    @Email
    @NotNull
    private String email;

    @Column(name = "website", unique = true)
    @NotNull
    private String website;

    @Column(name = "phone_number", unique = true)
    @NotNull
    @Pattern(regexp="^\\+[0-9]{1,3} \\([0-9]{3}\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$", message = "Phone number must be in the format +7 (999) 123-45-67")
    private String phoneNumber;

    @Column(name = "government_funding")
    @NotNull
    private boolean hasGovernmentFunding;

    @Column(name = "military_center")
    @NotNull
    private boolean hasMilitaryCenter;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Dormitory> dormitories;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<DiningRoom> diningRooms;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Gym> gyms;

    @JsonIgnore
    @OneToOne(mappedBy = "universityOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private CultureHouse cultureHouse;

    @JsonIgnore
    @OneToMany(mappedBy = "universityOwner", cascade = CascadeType.REMOVE, orphanRemoval = true)
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
