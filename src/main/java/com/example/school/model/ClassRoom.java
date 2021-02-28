package com.example.school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "class_index")
    private String classIndex;

    @Column(name = "class_number")
    private Integer classNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "class_subjects",
               joinColumns = @JoinColumn(name = "class_id"),
               inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Dictionary> subjects;

    public List<Dictionary> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Dictionary> subjects) {
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(String classIndex) {
        this.classIndex = classIndex;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
