package com.aps.cc.unip.controller;

import com.aps.cc.unip.DAO.AlunoDAO;
import com.aps.cc.unip.DAO.CursoDAO;
import com.aps.cc.unip.DAO.RendimentoDAO;
import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Historico;
import com.aps.cc.unip.model.Rendimento;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppControllerImpl implements AppControllerInterface {
    private AlunoDAO alunoDAO = new AlunoDAO();
    private CursoDAO cursoDAO = new CursoDAO();
    private RendimentoDAO rendimentoDAO = new RendimentoDAO();

    @Override
    public List<Curso> getAllCourses() {
        return cursoDAO.getAll();
    }

    @Override
    public List<Aluno> getAllStudents() {
        return alunoDAO.getAll();
    }

    @Override
    public List<Historico> getStudentHistoryByObj(Aluno aluno) {
        return null;
    }

    @Override
    public Map<Aluno, Rendimento> getCourseReportByObj(Curso curso) {
        return null;
    }

    @Override
    public void addStudent(Aluno aluno) {
        alunoDAO.save(aluno);
    }

    @Override
    public void addCourse(Curso curso) {
        cursoDAO.save(curso);
    }

    @Override
    public void addReport(Aluno aluno, Curso curso, Double np1, Double np2, Double sub, Double ex) {
        Rendimento rendimento = new Rendimento(aluno.getStudentId(), np1, np2, sub, ex);
        rendimento.setStudentName(aluno.getStudentName());
        rendimento.setStudentId(aluno.getStudentId());
        rendimento.setCourseType(curso.getCourseType());
        rendimento.setCourseYear(curso.getCourseYear());
        rendimento.setCourseName(curso.getCourseName());
        rendimento.calculateAverage();

        rendimentoDAO.save(rendimento);
    }

    @Override
    public void insertStudents(String pathCSV) throws IOException {
        List<Aluno> students = readAlunoCSV(pathCSV);
        alunoDAO.insert(students);
    }

    @Override
    public void insertCourses(String pathCSV) throws IOException {
        List<Curso> courses = readCursoCSV(pathCSV);
        cursoDAO.insert(courses);
    }

    public List<Aluno> readAlunoCSV(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));

        CsvToBean<Aluno> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Aluno.class)
                .build();

        List<Aluno> alunos = csvToBean.parse();

        return alunos;
    }

    public List<Curso> readCursoCSV(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));

        CsvToBean<Curso> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Curso.class)
                .build();

        List<Curso> cursos = csvToBean.parse();

        return cursos;
    }

    public List<Rendimento> readRendimentoCSV(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> rendimentos = csvReader.readAll();
        List<Rendimento> obj = new ArrayList<>();

        for (String[] r : rendimentos){
            Rendimento re = new Rendimento(r[0], r[1], r[2], r[3], r[4]);
            obj.add(re);
        }

        return obj;
    }
}
