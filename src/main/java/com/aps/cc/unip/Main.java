package com.aps.cc.unip;

import com.aps.cc.unip.controller.AppControllerImpl;
import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Rendimento;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        AppControllerImpl app = new AppControllerImpl();
        LocalDate localDate = LocalDate.now();

        try {
            app.insertStudents("src/main/resources/data/alunos.csv");
            app.insertCourses("src/main/resources/data/Cursos.csv");
            app.insertGrades("src/main/resources/data/");

            app.updateStudent(1, "Victoria");

            for (Aluno a: app.getAllStudents()) {
                System.out.println(a);
            }

            System.out.println("");

            for(Curso curso: app.getAllCourses()){
                System.out.println(curso);
            }

            System.out.println("");

            for(Rendimento r: app.getAllGrades()){
                System.out.println(r);
            }

            app.writeStudents("src/main/resources/data", "Alunos"+localDate);
            app.writeCourses("src/main/resources/data", "Cursos"+localDate);
            app.writeGrades("src/main/resources/data");
        }catch (Exception e){
            System.out.println("============= ERRO =============");
            System.out.println(e.getMessage());
            System.out.println("================================");
        }
    }
}
