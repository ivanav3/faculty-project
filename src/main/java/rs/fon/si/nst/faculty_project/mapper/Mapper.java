/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.fon.si.nst.faculty_project.mapper;

/**
 *
 * @author HP
 */
public interface Mapper<Dto, Entity> {

    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

}
