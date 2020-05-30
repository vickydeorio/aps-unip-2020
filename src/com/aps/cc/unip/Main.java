package com.aps.cc.unip;

import com.aps.cc.unip.controller.AppControllerImpl;
import com.aps.cc.unip.enums.TipoCurso;
import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Rendimento;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AppControllerImpl app = new AppControllerImpl();

        try {
            app.insertStudents("src/com/aps/cc/unip/data/alunos.csv");
            app.insertCourses("src/com/aps/cc/unip/data/Cursos.csv");

            Aluno aluno = new Aluno(1, "Victoria");
            app.deleteStudent(aluno);

            for (Aluno a: app.getAllStudents()) {
                System.out.println(a);
            }

            System.out.println("");

            Curso c = new Curso("CursoTeste", TipoCurso.pos_graduacao, 2020);
            app.addCourse(c);

            c.setCourseYear(2022);
            app.updateCourse(c);
            for(Curso curso: app.getAllCourses()){
                System.out.println(curso);
            }

            System.out.println("");

            List<Rendimento> rendimentos = app.readRendimentoCSV("src/com/aps/cc/unip/data/Ciencia da Computação_graduacao_2020.csv");
            for(Rendimento r: rendimentos){
                System.out.println(r);
            }
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
