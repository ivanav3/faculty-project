/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.service;

import java.util.List;
import rs.fon.si.nst.faculty_project.dto.SubjectDto;

/**
 *
 * @author HP
 */
public interface SubjectService {
    
    void save(SubjectDto subjectDto);

    SubjectDto findById(Long id) throws Exception;

    List<SubjectDto> findAll() throws Exception;

    void delete(SubjectDto subjectDto) throws Exception;

    void update(Long id, SubjectDto subjectDto) throws Exception;

    void deleteById(Long id) throws Exception;
}
