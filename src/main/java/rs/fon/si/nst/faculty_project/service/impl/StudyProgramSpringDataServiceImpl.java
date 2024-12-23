/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import rs.fon.si.nst.faculty_project.dto.StudyProgramDto;
import rs.fon.si.nst.faculty_project.entity.StudyProgram;
import rs.fon.si.nst.faculty_project.exception.EntityNotFoundException;
import rs.fon.si.nst.faculty_project.exception.ValidationException;
import rs.fon.si.nst.faculty_project.mapper.impl.StudyProgramMapper;
import rs.fon.si.nst.faculty_project.repository.StudyProgramSpringDataRepository;
import rs.fon.si.nst.faculty_project.service.StudyProgramService;
import rs.fon.si.nst.faculty_project.validator.impl.StudyProgramSaveValidator;
import rs.fon.si.nst.faculty_project.validator.impl.StudyProgramUpdateValidator;

/**
 *
 * @author HP
 */
@Service
public class StudyProgramSpringDataServiceImpl implements StudyProgramService {

    private StudyProgramSpringDataRepository studyProgramSpringDataRepository;
    private StudyProgramMapper studyProgramMapper;

    private StudyProgramSaveValidator studyProgramSaveValidator;
    private StudyProgramUpdateValidator studyProgramUpdateValidator;

    public StudyProgramSpringDataServiceImpl(StudyProgramSpringDataRepository studyProgramSpringDataRepository, StudyProgramMapper studyProgramMapper, StudyProgramSaveValidator studyProgramSaveValidator, StudyProgramUpdateValidator studyProgramUpdateValidator) {
        this.studyProgramSpringDataRepository = studyProgramSpringDataRepository;
        this.studyProgramMapper = studyProgramMapper;
        this.studyProgramSaveValidator = studyProgramSaveValidator;
        this.studyProgramUpdateValidator = studyProgramUpdateValidator;
    }

    @Transactional
    @Override
    public void save(StudyProgramDto studyProgramDto) {
        studyProgramSaveValidator.validate(studyProgramDto);
        studyProgramSpringDataRepository.save(studyProgramMapper.toEntity(studyProgramDto));
    }

    @Override
    public StudyProgramDto findById(Long id) throws Exception {
        Optional<StudyProgram> studyProgram = studyProgramSpringDataRepository.findById(id);
        if (studyProgram.isPresent()) {
            return studyProgramMapper.toDto(studyProgram.get());
        }
        throw new EntityNotFoundException("Study program " + id + " not found");
    }

    @Override
    public List<StudyProgramDto> findAll() throws Exception {
        return studyProgramSpringDataRepository.findAll().stream().
                map(entity -> studyProgramMapper.toDto(entity)).collect(Collectors.toList());

    }

    @Override
    public void delete(StudyProgramDto studyProgramDto) throws Exception {
        StudyProgramDto tmp = findById(studyProgramDto.getId());
        studyProgramSpringDataRepository.delete(studyProgramMapper.toEntity(tmp));
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<StudyProgram> subject = studyProgramSpringDataRepository.findById(id);
        if (!subject.isPresent()) {
            throw new EntityNotFoundException("Study program " + id + " not found");

        }
        studyProgramSpringDataRepository.deleteById(id);

    }

    @Override
    public void update(Long id, StudyProgramDto studyProgramDto) throws Exception {
        if (studyProgramDto.getId() != null) {
            throw new ValidationException("Id can't be changed");
        }
        StudyProgram found = studyProgramMapper.toEntity(findById(id));
        System.out.println(found);
        if (studyProgramDto.getName() != null) {
            found.setName(studyProgramDto.getName());
        }
        studyProgramUpdateValidator.validate(studyProgramMapper.toDto(found));

        studyProgramSpringDataRepository.save(found);
    }

}
