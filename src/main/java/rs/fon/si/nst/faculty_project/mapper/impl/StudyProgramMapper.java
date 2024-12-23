/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.mapper.impl;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rs.fon.si.nst.faculty_project.dto.StudyProgramDto;
import rs.fon.si.nst.faculty_project.entity.StudyProgram;
import rs.fon.si.nst.faculty_project.mapper.Mapper;

/**
 *
 * @author HP
 */
@Component
public class StudyProgramMapper implements Mapper<StudyProgramDto, StudyProgram> {

    private SubjectMapper subjectMapper;

    @Autowired
    public StudyProgramMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public StudyProgram toEntity(StudyProgramDto dto) {
        return new StudyProgram(
                dto.getId(),
                dto.getName(),
                dto.getSubjects().stream().map(subjectDto -> subjectMapper.toEntity(subjectDto)).collect(Collectors.toList())
        );

    }

    @Override
    public StudyProgramDto toDto(StudyProgram entity) {
        return new StudyProgramDto(
                entity.getId(),
                entity.getName(),
                entity.getSubjects().stream().map(subject -> subjectMapper.toDto(subject)).collect(Collectors.toList())
        );
    }

}
