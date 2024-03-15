package ru.databasePetProject.RestAppUniversityProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "educational_direction")
public class EducationalDirection {
    @Id
    @Column(name = "id_educational_direction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEducationalDirection;

    @Column(name = "count_places")
    @NotNull
    private long countPlaces;

    @Column(name = "educational_type")
    @Enumerated(EnumType.ORDINAL)
    private EducationalType educationalType;

    @Column(name = "educational_cost")
    private long educationalCost;

    @Column(name = "name_educational_direction")
    @NotNull
    private String nameEducationalDirection;

    @ManyToOne
    @JoinColumn(name = "fk_id_department", referencedColumnName = "id_department")
    private Department departmentOwner;



    @Column(name = "subject")
    private String subjectsRequired;

    @OneToMany(mappedBy = "studyGroupOwner", cascade = CascadeType.PERSIST)
    private List<StudyGroup> studyGroups;


    public EducationalDirection(long countPlaces,
                                EducationalType educationalType,
                                long educationalCost,
                                String nameEducationalDirection,
                                String subjectsRequired,
                                List<StudyGroup> studyGroups) {
        this.countPlaces = countPlaces;
        this.educationalType = educationalType;
        this.educationalCost = educationalCost;
        this.nameEducationalDirection = nameEducationalDirection;
        this.subjectsRequired = subjectsRequired;
        this.studyGroups = studyGroups;
    }

}