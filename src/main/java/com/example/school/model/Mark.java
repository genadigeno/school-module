package com.example.school.model;

import com.example.school.util.PastDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "subject_marks")
public class Mark {
    public Mark() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mark")
    @Min(1)@Max(10)
    @NotNull(message = "Assigned Mast must not be null")
    private Integer assignedMark;

    @Column(name = "assign_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastDate
    private Date assignDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    @NotNull
    private Dictionary subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pupil_id")
    private Pupil pupil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssignedMark() {
        return assignedMark;
    }

    public void setAssignedMark(Integer assignedMark) {
        this.assignedMark = assignedMark;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Dictionary getSubject() {
        return subject;
    }

    public void setSubject(Dictionary subject) {
        this.subject = subject;
    }

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }
}
