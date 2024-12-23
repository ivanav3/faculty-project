/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.validator.impl;

import org.springframework.stereotype.Component;
import rs.fon.si.nst.faculty_project.dto.StudyProgramDto;
import rs.fon.si.nst.faculty_project.exception.ValidationException;
import rs.fon.si.nst.faculty_project.validator.Validator;

/**
 *
 * @author HP
 */
@Component
public class StudyProgramSaveValidator implements Validator<StudyProgramDto> {

    @Override
    public void validate(StudyProgramDto dto) throws ValidationException {
        if (dto.getId() != null) {
            throw new ValidationException("Id must not exist!");
        }
        if (dto.getName().isEmpty()) {
            throw new ValidationException("Name is required");

        }
    }

}