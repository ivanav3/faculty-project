/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.fon.si.nst.faculty_project.entity.Subject;

/**
 *
 * @author HP
 */
@Repository
public interface SubjectSpringDataRepository extends JpaRepository<Subject, Long>{
    
}
