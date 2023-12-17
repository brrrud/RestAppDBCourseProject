package ru.databasePetProject.RestAppUniversityProject.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "culture_house_activity")
public class CultureHouseActivity {
    @Column(name = "id_culture_house_activity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idCultureHouseActivity;

    @Column(name = "name_activity")
    private String nameActivity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_id_culture_house", referencedColumnName = "id_culture_house")
    private CultureHouse cultureHouseOwner;

    public CultureHouseActivity(String nameActivity, String description, CultureHouse cultureHouseOwner) {
        this.nameActivity = nameActivity;
        this.cultureHouseOwner = cultureHouseOwner;
        this.description = description;
    }
}