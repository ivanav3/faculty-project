/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.validator;

import rs.fon.si.nst.faculty_project.exception.ValidationException;

/**
 *
 * @author HP
 */
public interface Validator<Dto> {

    public void validate(Dto dto) throws ValidationException;

}
