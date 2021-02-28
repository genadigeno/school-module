package com.example.school.model;

import com.example.school.util.PastDate;
import com.example.school.util.PupilAge;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pupils")
public class Pupil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @NotNull(message = "First name must not be null")
    @NotEmpty(message = "First name must not be empty")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name must not be null")
    @NotEmpty(message = "Last name must not be empty")
    private String lastName;

    @Column(name = "personal_number")
    @NotNull
    //@Pattern(regexp = "[\\d]{11}", message = "\"The personal number\" is incorrect")
    @Size(min = 11, max = 11, message = "The personal number is incorrect")
    private String personalNumber;

    @Column(name = "email")
    @Email(message = "Email is invalid")
    @NotNull(message = "Email must not be null")
    private String email;

    @Column(name = "birth_date")
    @NotNull(message = "Birth date mustn't be a null!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastDate @PupilAge
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "gender")
    @NotNull
    private Dictionary gender;

    @OneToOne
    @JoinColumn(name = "class_id")
    @NotNull
    private ClassRoom classRoom;

    @OneToMany(mappedBy = "pupil")
    private List<Mark> marks;

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Dictionary getGender() {
        return gender;
    }

    public void setGender(Dictionary gender) {
        this.gender = gender;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
