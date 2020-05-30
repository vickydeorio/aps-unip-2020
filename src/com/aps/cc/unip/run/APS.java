/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aps.cc.unip.run;

import com.aps.cc.unip.controller.AppControllerImpl;
import com.aps.cc.unip.enums.TipoCurso;
import com.aps.cc.unip.front.frontInterface;
import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Rendimento;
import com.aps.cc.unip.utils.IdGenerator;

import java.sql.SQLOutput;
import java.util.List;

/**
 *
 * @author Gabriel Da Silva
 */
public class APS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        AppControllerImpl app = new AppControllerImpl();
        frontInterface front = new frontInterface();
        IdGenerator id = new IdGenerator();

        try {

            System.out.println("Lendo CSVs");

            app.insertStudents("src/com/aps/cc/unip/data/alunos.csv");
            app.insertCourses("src/com/aps/cc/unip/data/Cursos.csv");
            List<Rendimento> rendimentos = app.readRendimentoCSV("src/com/aps/cc/unip/data/Ciencia da Computação_graduacao_2020.csv");

            System.out.println("Leitura concluída");

            id.AtuId(app.getAllStudents());
            front.setIdAluno(id.getId());
            System.out.println("Id Atualizado");

        }catch (Exception e){
            System.out.println("erro no carregamento inicial dos CSVs");
            System.out.println(e.fillInStackTrace());
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
                }

                System.out.println("Saindo...");

            }

        }catch (Exception e)
        {
            System.out.println("erro na interface do usuário");
            System.out.println(e.fillInStackTrace());
        }

    }
    
}
