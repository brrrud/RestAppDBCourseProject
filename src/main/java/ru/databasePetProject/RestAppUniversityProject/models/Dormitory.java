package ru.databasePetProject.RestAppUniversityProject.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dormitory")
public class Dormitory {
    @Id
    @Column(name = "id_dormitory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dormitoryId;

    @Column(name = "address")
    private String address;

    @Column(name = "available_places")
    private short availablePlaces;

    @Column(name = "all_places")
    private short allPlaces;

    @Enumerated(EnumType.ORDINAL)
    private DormitoryRoomsType dormitoryRoomsType;
//    @Column(name="dormitory_type_room")
//    private int dormitoryRoomsType;

    @Column(name = "rating")
    private double rating;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "fk_id_university", referencedColumnName = "id_university")
    private University universityOwner;

    public Dormitory(String address, short availablePlaces, short allPlaces, DormitoryRoomsType dormitoryRoomsType, double rating, String description, University universityOwner) {
        this.address = address;
        this.availablePlaces = availablePlaces;
        this.allPlaces = allPlaces;
        this.dormitoryRoomsType = dormitoryRoomsType;
        this.rating = rating;
        this.description = description;
        this.universityOwner = universityOwner;
    }
}
