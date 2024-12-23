/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.service;

import java.util.List;
import rs.fon.si.nst.faculty_project.dto.StudyProgramDto;

/**
 *
 * @author HP
 */
public interface StudyProgramService {
 
   
    void save(StudyProgramDto studyProgramDto);

    StudyProgramDto findById(Long id) throws Exception;

    List<StudyProgramDto> findAll() throws Exception;

    void delete(StudyProgramDto studyProgramDto) throws Exception;

    void update(Long id, StudyProgramDto studyProgramDto) throws Exception;

    void deleteById(Long id) throws Exception;
    
}
