package com.aleksgolovnya.deansoffice.controller;

import com.aleksgolovnya.deansoffice.dto.TeacherDto;
import com.aleksgolovnya.deansoffice.entity.Subject;
import com.aleksgolovnya.deansoffice.entity.Teacher;
import com.aleksgolovnya.deansoffice.service.people.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for a Teacher.
 * Provides CRUD operations.
 */

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * Method returns all teachers
     *
     * @return [Teacher]
     */
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAll();
    }

    /**
     * Method returns teacher by id
     *
     * @param id of the teacher
     * @return teacher
     */
    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        Teacher teacher = teacherService.getById(id);
        return teacher;
    }

    /**
     * Method returns all subjects of a teacher by id
     *
     * @param id of the teacher
     * @return [Subject]
     */
    @GetMapping("/{id}/subjects")
    public List<Subject> getTeacherSubjects(@PathVariable Long id) {
        List<Subject> subjects = teacherService.getTeacherSubjects(id);
        return subjects;
    }

    /**
     * Method deletes teacher by id
     *
     * @param id of the teacher
     */
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.getById(id);
    }

    /**
     * Method creates new teacher
     *
     * @param teacherDto
     * @return teacher
     */
    @PostMapping
    public Teacher createTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.addTeacher(teacherDto);
    }

    /**
     * Method edits information of the teacher by id
     *
     * @param teacherDto
     * @param id of the teacher
     * @return teacher
     */
    @PutMapping("/{id}")
    public Teacher updateTeacher(@RequestBody TeacherDto teacherDto, @PathVariable Long id) {
        teacherDto.setId(id);
        return teacherService.editTeacher(teacherDto);
    }
}
