/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.mapper.impl;

import org.springframework.stereotype.Component;
import rs.fon.si.nst.faculty_project.dto.SubjectDto;
import rs.fon.si.nst.faculty_project.entity.Subject;
import rs.fon.si.nst.faculty_project.mapper.Mapper;

/**
 *
 * @author HP
 */
@Component
public class SubjectMapper implements Mapper<SubjectDto, Subject> {

    @Override
    public Subject toEntity(SubjectDto dto) {
        return new Subject(dto.getId(), dto.getName(), dto.getEcts(),
                dto.getStudyProgram(), dto.getSemester(), dto.getStatus(), dto.getClassHours());
    }

    @Override
    public SubjectDto toDto(Subject entity) {

        return new SubjectDto(entity.getId(), entity.getName(), entity.getEcts(),
                entity.getStudyProgram(), entity.getSemester(), entity.getStatus(), entity.getClassHours());
    }

}
