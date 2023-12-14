package ru.databasePetProject.RestAppUniversityProject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gym_activity")
public class GymActivity {
    @Column(name = "id_gym_activity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short gymActivityId;

    @Column(name = "name_activity")
    private String nameActivity;
    @ManyToOne
    @JoinColumn(name = "fk_id_gym", referencedColumnName = "id_gym")
    private Gym gymOwner;
    public GymActivity(String nameActivity, Gym gymOwner) {
        this.nameActivity = nameActivity;
        this.gymOwner = gymOwner;
    }
}