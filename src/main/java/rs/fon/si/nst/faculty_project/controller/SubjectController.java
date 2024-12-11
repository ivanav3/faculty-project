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
import rs.fon.si.nst.faculty_project.dto.SubjectDto;
import rs.fon.si.nst.faculty_project.service.SubjectService;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public void save(@RequestBody SubjectDto subjectDto) {
        subjectService.save(subjectDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> findById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok().body(subjectService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubjectDto>> findAll() throws Exception {
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(@RequestBody SubjectDto subjectDto) throws Exception {
        subjectService.delete(subjectDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) throws Exception {
        subjectService.deleteById(id);
    }

    @Transactional
    @PutMapping("/update/{id}")
    public void update(@PathVariable(value = "id") Long id, @RequestBody SubjectDto subjectDto) throws Exception {
        subjectService.update(id, subjectDto);
    }
}
