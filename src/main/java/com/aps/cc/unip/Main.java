package com.aps.cc.unip;

import com.aps.cc.unip.controller.AppControllerImpl;
import com.aps.cc.unip.front.frontInterface;
import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Rendimento;
import com.aps.cc.unip.utils.IdGenerator;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        AppControllerImpl app = new AppControllerImpl();
        frontInterface front = new frontInterface();
        IdGenerator id = new IdGenerator();
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

        }catch (Exception e){
            System.out.println("============= ERRO =============");
            System.out.println(e.getMessage());
            System.out.println("================================");
        }

        System.out.println("iniciando Interface...");

        try
        {
            while (front.getOptions()[0] != 4)
            {

                System.out.println("Iniciando carga de dados da interface");

                id.AtuId(app.getAllStudents());
                front.setIdAluno(id.getId());
                front.cargaAlunos(app.getAllStudents());
                front.cargaCursos(app.getAllCourses());
                front.cargaRedimentos(app.getAllGrades());

                System.out.println("concluido.");

                System.out.println("inicializando interface gráfica.");
                front.messageStart();
                front.setOption();

                System.out.println("Executando opção do usuário...");
                front.runOption();

                if(front.getOptions()[0] == 1)
                {
                    if(front.getOptions()[1] == 1)
                    {
                        app.addStudent(front.getAluno());

                    }else if(front.getOptions()[1] == 3)
                    {
                        app.deleteStudent(front.getAluno());
                    }

                }else if(front.getOptions()[0] == 2)
                {
                    if(front.getOptions()[1] == 1)
                    {
                        app.addCourse(front.getCurso());

                    }else if(front.getOptions()[1] == 3)
                    {
                        app.deleteCourse(front.getCurso());
                    }
                }else if(front.getOptions()[0] == 3)
                {
                    if(front.getOptions()[1] == 1)
                    {
                        app.addReport(Integer.parseInt(front.getCampos().get(0).getText()),
                                front.getCurso(),
                                Double.parseDouble(front.getCampos().get(1).getText()),
                                Double.parseDouble(front.getCampos().get(2).getText()),
                                Double.parseDouble(front.getCampos().get(3).getText()),
                                Double.parseDouble(front.getCampos().get(4).getText()));

                    }else if(front.getOptions()[1] == 3)
                    {
                        app.deleteCourse(front.getCurso());
                    }
                }

                System.out.println("Saindo...");

            }

            app.writeStudents("src/main/resources/data", "Alunos.csv");
            app.writeCourses("src/main/resources/data", "Cursos.csv");
            app.writeGrades("src/main/resources/data");

        }catch (Exception e)
        {
            System.out.println("erro na interface do usuário");
            System.out.println(e.fillInStackTrace());
        }


    }
}
