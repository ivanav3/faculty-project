/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.controller;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.si.nst.faculty_project.dto.StudyProgramDto;
import rs.fon.si.nst.faculty_project.service.StudyProgramService;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api/studyProgram")
public class StudyProgramController {

    private StudyProgramService studyProgramService;

    public StudyProgramController(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    @PostMapping
    public void save(@RequestBody StudyProgramDto studyProgramDto) {
        studyProgramService.save(studyProgramDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyProgramDto> findByid(@PathVariable(value = "id") Long id) throws Exception {

        return ResponseEntity.ok().body(studyProgramService.findById(id));

    }

    @GetMapping("/all")
    public ResponseEntity<List<StudyProgramDto>> findAll() throws Exception {
        return new ResponseEntity<>(studyProgramService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(@RequestBody StudyProgramDto studyProgramDto) throws Exception {
        studyProgramService.delete(studyProgramDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) throws Exception {
        studyProgramService.deleteById(id);
    }

    @Transactional
    @PutMapping("/update/{id}")
    public void update(@PathVariable(value = "id") Long id, @RequestBody StudyProgramDto studyProgramDto) throws Exception {
        studyProgramService.update(id, studyProgramDto);
    }
}