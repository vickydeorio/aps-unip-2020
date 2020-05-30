package com.aps.cc.unip.controller;

import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Historico;
import com.aps.cc.unip.model.Rendimento;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AppControllerInterface {
    List<Curso> getAllCourses();

    List<Aluno> getAllStudents();

    void addStudent(Aluno aluno);

    void updateStudent(int studentId, String newName);

    void deleteStudent(Aluno aluno);

    void addCourse(Curso curso);

    void updateCourse(Curso curso);

    void deleteCourse(Curso curso);

    void addReport(Aluno aluno, Curso curso, Double np1, Double np2, Double sub, Double ex);

    void insertStudents(String pathCSV) throws IOException;

    void insertCourses(String pathCSV) throws IOException;
}
