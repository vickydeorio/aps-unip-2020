package main.java.com.aps.cc.unip.controller;

import main.java.com.aps.cc.unip.DAO.AlunoDAO;
import main.java.com.aps.cc.unip.DAO.CursoDAO;
import main.java.com.aps.cc.unip.DAO.RendimentoDAO;
import main.java.com.aps.cc.unip.enums.TipoCurso;
import com.aps.cc.unip.exceptions.*;
import main.java.com.aps.cc.unip.exceptions.*;
import main.java.com.aps.cc.unip.model.Aluno;
import main.java.com.aps.cc.unip.model.Curso;
import main.java.com.aps.cc.unip.model.Rendimento;
import main.java.com.aps.cc.unip.utils.CsvHeaders;
import main.java.com.aps.cc.unip.utils.CsvUtils;
import main.java.com.aps.cc.unip.utils.Header;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppControllerImpl implements AppControllerInterface {
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final CursoDAO cursoDAO = new CursoDAO();
    private final RendimentoDAO rendimentoDAO = new RendimentoDAO();

    @Override
    public List<Curso> getAllCourses() throws CursoInvalidoException {
        List<Curso> cursos = cursoDAO.getAll();

        if(cursos == null || cursos.isEmpty()){
            throw new CursoInvalidoException();
        }

        return cursos;
    }

    @Override
    public List<Aluno> getAllStudents() throws AlunoInvalidoException {
        List<Aluno> alunos = alunoDAO.getAll();

        if(alunos == null || alunos.isEmpty()){
            throw new AlunoInvalidoException();
        }

        return alunos;
    }

    @Override
    public List<Rendimento> getAllGrades() throws RendimentoInvalidoException {
        List<Rendimento> rendimentos = rendimentoDAO.getAll();

        if(rendimentos == null || rendimentos.isEmpty()){
            throw new RendimentoInvalidoException();
        }

        return rendimentos;
    }

    @Override
    public Boolean isStudentApproved(int idAluno) throws AlunoInvalidoException {
        Aluno a = alunoDAO.get(idAluno);
        Rendimento r = rendimentoDAO.getByStudent(a);

        if(r.isApproved() == null){
            throw new AlunoInvalidoException();
        }

        return r.isApproved();
    }

    @Override
    public void addStudent(Aluno aluno) { alunoDAO.save(aluno); }

    @Override
    public void updateStudent(int studentId, String newName) throws AlunoInvalidoException {
        alunoDAO.update(studentId, newName);
    }

    @Override
    public void deleteStudent(Aluno aluno) throws AlunoInvalidoException {
        alunoDAO.delete(aluno);
    }

    @Override
    public void updateCourse(Curso curso) throws CursoInvalidoException {
        cursoDAO.update(curso);
    }

    @Override
    public void deleteCourse(Curso curso) throws CursoInvalidoException {
        cursoDAO.delete(curso);
    }

    @Override
    public void addCourse(Curso curso) {
        cursoDAO.save(curso);
    }

    @Override
    public void addReport(int idAluno, Curso curso, Double np1, Double np2, Double sub, Double ex) {
        Rendimento rendimento = new Rendimento(idAluno, np1, np2, sub, ex);
        rendimento.setCurso(curso);
        rendimento.calculateAverage();

        rendimentoDAO.save(rendimento);
    }

    @Override
    public void insertStudents(String pathCSV) throws ErroAoIniciarException {
        try {
            List<Aluno> students = readAlunoCSV(pathCSV);
            alunoDAO.insert(students);
        }catch (IOException io){
            throw new ErroAoIniciarException();
        }
    }

    @Override
    public void insertCourses(String pathCSV) throws ErroAoIniciarException {
        try {
            List<Curso> courses = readCursoCSV(pathCSV);
            cursoDAO.insert(courses);
        }catch (IOException io){
            throw new ErroAoIniciarException();
        }

    }

    @Override
    public void insertGrades(String pathCSV) throws ErroAoIniciarException {
        List<Curso> cursos = cursoDAO.getAll();
        List<Rendimento> gradesTemp = new ArrayList<>();

        for(Curso c: cursos) {
            File tmpDir = new File(pathCSV + c.strGrade());
            boolean exists = tmpDir.exists();

            if(exists) {
                try {
                    List<Rendimento> grades = readRendimentoCSV(pathCSV + c.strGrade());

                    for (Rendimento r : grades) {
                        r.setCurso(c);
                        gradesTemp.add(r);
                    }
                }catch (IOException io){
                    throw new ErroAoIniciarException();
                }
            }
        }

        rendimentoDAO.insert(gradesTemp);
    }

    @Override
    public void writeStudents(String path, String nameFile) throws ErroAoSalvarException {
        List<Aluno> alunos = alunoDAO.getAll();
        CsvUtils utils = new CsvUtils();

        List<String[]> asArr = new ArrayList<>();
        asArr.add(new CsvHeaders(Header.Aluno).getHeaderAsArray());

        for (Aluno a: alunos){
            asArr.add(a.toArray());
        }

        try {
            utils.writeCsv(path, nameFile, asArr);
        }catch (IOException io){
            throw new ErroAoSalvarException();
        }
    }

    @Override
    public void writeCourses(String path, String nameFile) throws ErroAoSalvarException {
        List<Curso> cursos = cursoDAO.getAll();
        CsvUtils utils = new CsvUtils();

        List<String[]> asArr = new ArrayList<>();
        asArr.add(new CsvHeaders(Header.Curso).getHeaderAsArray());

        for (Curso c: cursos){
            asArr.add(c.toArray());
        }

        try {
            utils.writeCsv(path, nameFile, asArr);
        }catch (IOException io){
            throw new ErroAoSalvarException();
        }
    }

    @Override
    public void writeGrades(String path) throws ErroAoSalvarException {
        List<Rendimento> rendimentos = rendimentoDAO.getAll();
        CsvUtils utils = new CsvUtils();

        for(Curso c: cursoDAO.getAll()){
            List<Rendimento> rendimentosTemp = rendimentoDAO.getByCourse(c);

            if(rendimentosTemp != null){
                String nameFile = c.strGrade();

                List<String[]> asArr = new ArrayList<>();
                asArr.add(new CsvHeaders(Header.Rendimento).getHeaderAsArray());

                for (Rendimento r: rendimentosTemp){
                    asArr.add(r.toArray());
                }

                try {
                    utils.writeCsv(path, nameFile, asArr);
                }catch (IOException io){
                    throw new ErroAoSalvarException();
                }
            }
        }
    }

    public List<Aluno> readAlunoCSV(String path) throws IOException {
        return CsvUtils.readCsv(path, Aluno.class);
    }

    public List<Curso> readCursoCSV(String path) throws IOException {
        return CsvUtils.readCsv(path, Curso.class);
    }

    public List<Rendimento> readRendimentoCSV(String path) throws IOException {
        List<String[]> rendimentos = CsvUtils.readCsv(path);
        List<Rendimento> obj = new ArrayList<>();

        for (String[] r : rendimentos){
            Rendimento re = new Rendimento(r[0], r[1], r[2], r[3], r[4]);
            re.setCurso(new Curso("Testee", TipoCurso.graduacao, 2020));
            obj.add(re);
        }

        return obj;
    }

}
