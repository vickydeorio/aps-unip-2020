package com.aps.cc.unip.controller;

import com.aps.cc.unip.exceptions.*;
import com.aps.cc.unip.exceptions.*;
import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Rendimento;

import java.util.List;

public interface AppControllerInterface {
    List<Curso> getAllCourses() throws CursoInvalidoException;

    List<Aluno> getAllStudents() throws AlunoInvalidoException;

    List<Rendimento> getAllGrades() throws RendimentoInvalidoException;

    Boolean isStudentApproved(int idAluno) throws AlunoInvalidoException;

    void addStudent(Aluno aluno);

    void updateStudent(int studentId, String newName) throws AlunoInvalidoException;

    void deleteStudent(Aluno aluno) throws AlunoInvalidoException;

    void addCourse(Curso curso);

    void updateCourse(Curso curso) throws CursoInvalidoException;

    void deleteCourse(Curso curso) throws CursoInvalidoException;

    void addReport(int idAluno, Curso curso, Double np1, Double np2, Double sub, Double ex);

    void insertStudents(String pathCSV) throws ErroAoIniciarException, AlunoInvalidoException;

    void insertCourses(String pathCSV) throws ErroAoIniciarException;

    void insertGrades(String pathCSV) throws ErroAoIniciarException;

    void writeStudents(String path, String nameFile) throws ErroAoSalvarException;

    void writeCourses(String path, String nameFile) throws ErroAoSalvarException;

    void writeGrades(String path) throws ErroAoSalvarException;
}
