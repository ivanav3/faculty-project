/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class StudyProgramDto implements Serializable{
    
    private Long id;
    private String name;
    private List<SubjectDto> subjects;

    public StudyProgramDto() {
    }
    
    
    public StudyProgramDto(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public StudyProgramDto(Long id, String name, List<SubjectDto> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
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

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final StudyProgramDto other = (StudyProgramDto) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.subjects, other.subjects);
    }

    @Override
    public String toString() {
        return "StudyProgramDto{" + "id=" + id + ", name=" + name + ", subjects=" + subjects + '}';
    }

    
}
