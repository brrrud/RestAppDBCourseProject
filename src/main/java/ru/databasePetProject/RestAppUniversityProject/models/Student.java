package ru.databasePetProject.RestAppUniversityProject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Long idStudent;

    @ManyToOne
    @JoinColumn(name = "fk_id_study_group", referencedColumnName = "id_study_group")
    private StudyGroup studyGroupOwner;

    @Column(name = "free_education_cost")
    private boolean freeEducationCost;

    @Column(name ="student_passing_score")
    private short studentPassingScore;
}