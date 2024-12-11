/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.validator.impl;

import org.springframework.stereotype.Component;
import rs.fon.si.nst.faculty_project.dto.SubjectDto;
import rs.fon.si.nst.faculty_project.exception.ValidationException;
import rs.fon.si.nst.faculty_project.type.Status;
import rs.fon.si.nst.faculty_project.validator.Validator;

/**
 *
 * @author HP
 */
@Component
public class SubjectSaveValidator implements Validator<SubjectDto> {

    @Override
    public void validate(SubjectDto dto) throws ValidationException {
        if (dto.getId() != null) {
            throw new ValidationException("Id must not exist");
        }
        if (dto.getName().isEmpty() || dto.getStudyProgram()==null) {
            throw new ValidationException("Name and study program are required");

        }

        if (dto.getStatus() != Status.COMPULSORY && dto.getStatus() != Status.ELECTIVE) {
            throw new ValidationException("Status must be compulsory or elective");

        }

        if (dto.getEcts() <= 0L || dto.getSemester() <= 0L || dto.getClassHours() <= 0L) {
            throw new ValidationException("ECTS, semester and class hours must be positive numbers");
        }

    }
}