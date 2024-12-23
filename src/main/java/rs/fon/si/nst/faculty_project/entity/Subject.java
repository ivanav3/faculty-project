/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;
import rs.fon.si.nst.faculty_project.type.Status;

/**
 *
 * @author HP
 */
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long ects;

    //to be changed
//    @Column(name = "study_program")
//    private String studyProgram;
    private Long studyProgram;

    private Long semester;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "class_hours")
    private Long classHours;

    public Subject() {
    }

    public Subject(Long id, String name, Long ects, Long studyProgram, Long semester, Status status, Long classHours) {
        this.id = id;
        this.name = name;
        this.ects = ects;
        this.studyProgram = studyProgram;
        this.semester = semester;
        this.status = status;
        this.classHours = classHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEcts() {
        return ects;
    }

    public void setEcts(Long ects) {
        this.ects = ects;
    }

    public Long getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(Long studyProgram) {
        this.studyProgram = studyProgram;
    }

    public Long getSemester() {
        return semester;
    }

    public void setSemester(Long semester) {
        this.semester = semester;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getClassHours() {
        return classHours;
    }

    public void setClassHours(Long classHours) {
        this.classHours = classHours;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subject other = (Subject) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.studyProgram, other.studyProgram)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ects, other.ects)) {
            return false;
        }
        if (!Objects.equals(this.semester, other.semester)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return Objects.equals(this.classHours, other.classHours);
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name=" + name + ", ects=" + ects + ", studyProgram=" + studyProgram + ", semester=" + semester + ", status=" + status + ", classHours=" + classHours + '}';
    }

}
