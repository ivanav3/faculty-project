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
import rs.fon.si.nst.faculty_project.dto.SubjectDto;
import rs.fon.si.nst.faculty_project.entity.Subject;
import rs.fon.si.nst.faculty_project.mapper.impl.SubjectMapper;
import rs.fon.si.nst.faculty_project.repository.SubjectSpringDataRepository;
import rs.fon.si.nst.faculty_project.service.SubjectService;

/**
 *
 * @author HP
 */
@Service
public class SubjectSpringDataServiceImpl implements SubjectService {

    private SubjectSpringDataRepository subjectSpringDataRepository;
    private SubjectMapper subjectMapper;

    public SubjectSpringDataServiceImpl(SubjectSpringDataRepository subjectSpringDataRepository, SubjectMapper subjectMapper) {
        this.subjectSpringDataRepository = subjectSpringDataRepository;
        this.subjectMapper = subjectMapper;
    }

    @Transactional
    @Override
    public void save(SubjectDto subjectDto) {
        subjectSpringDataRepository.save(subjectMapper.toEntity(subjectDto));
    }

    @Override
    public SubjectDto findById(Long id) throws Exception {
        Optional<Subject> subject = subjectSpringDataRepository.findById(id);
        if (subject.isPresent()) {
            return subjectMapper.toDto(subject.get());
        }
        throw new Exception("Subject " + id + " not found");
    }

    @Override
    public List<SubjectDto> findAll() throws Exception {
        return subjectSpringDataRepository.findAll().stream()
                .map(entity -> subjectMapper.toDto(entity)).collect(Collectors.toList());
    }

    @Override
    public void delete(SubjectDto subjectDto) throws Exception {
        subjectSpringDataRepository.delete(subjectMapper.toEntity(subjectDto));
    }

    @Override
    public void update(Long id, SubjectDto subjectDto) throws Exception {
        if (subjectDto.getId() != null) {
            throw new Exception("Id can't be changed");
        }
        Subject found = subjectMapper.toEntity(findById(id));
        System.out.println(found);
        if (subjectDto.getName() != null) {
            found.setName(subjectDto.getName());
        }

        if (subjectDto.getEcts() != null) {
            found.setEcts(subjectDto.getEcts());

        }
        if (subjectDto.getStudyProgram() != null) {
            found.setStudyProgram(subjectDto.getStudyProgram());

        }
        if (subjectDto.getSemester() != null) {
            found.setSemester(subjectDto.getSemester());

        }
        if (subjectDto.getStatus() != null) {
            found.setStatus(subjectDto.getStatus());

        }
        if (subjectDto.getClassHours() != null) {
            found.setClassHours(subjectDto.getClassHours());

        }
        subjectSpringDataRepository.save(found);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        subjectSpringDataRepository.deleteById(id);
    }

}
