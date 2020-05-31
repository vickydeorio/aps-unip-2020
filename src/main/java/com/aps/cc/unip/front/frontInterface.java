/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aps.cc.unip.front;

import com.aps.cc.unip.enums.TipoCurso;
import com.aps.cc.unip.model.Aluno;
import com.aps.cc.unip.model.Curso;
import com.aps.cc.unip.model.Rendimento;

import javax.swing.JOptionPane;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Gabriel Da Silva
 * @apiNote Classe necessária para controlar as interações do usuário.
 */
public class frontInterface
{
    private String[] menus;
    private List<Aluno> students;
    private Aluno aluno;
    private List<Curso> cursos;
    private Curso curso;
    private List<Rendimento> rendimentos;
    private Rendimento rendimento;
    private String cTitle;
    private int[] options;
    private int idAluno;
    private JPanel panel;
    private List<JTextField> campos = new ArrayList<>();
    private JComboBox NivelCurso;

    public frontInterface()
    {
        //Confiduração inicial da interface
        this.menus          = new String[2];
        this.menus[0]       = "Digite uma opção:\n1-Alunos\n2-Cursos\n3-Rendimentos\n4-Sair ";
        this.menus[1]       = "Digite uma opção:\n1-Inserir\n2-Listar\n3-Deletar ";
        this.options = new int[2];
        this.panel          = new JPanel(new GridLayout(0, 1));
    }

    //Mensagem de inicio da aplicação
    public void messageStart()
    {
        JOptionPane.showMessageDialog(null,"Bem Vindo ao Sistema da Universidade Amazonas");
    }

    //Exibe as opção do menu para o usuário
    public void setOption()
    {
        try{

            String opcao = JOptionPane.showInputDialog(getMenus(0));

            if(opcao == null || Integer.parseInt(opcao) == 4)
            {
                JOptionPane.showMessageDialog(null,"Obrigado por usar o nosso sistema. \nDynamics System.");
                System.out.println("cancelled");
                this.setOptions(0,4);
                return;

            }else if(Integer.parseInt(opcao) > 4)
            {

                JOptionPane.showMessageDialog(null,"Opção Invalida");
                return;

            }else
            {
                this.setOptions(0,Integer.parseInt(opcao));
            }

            opcao = JOptionPane.showInputDialog(getMenus(1));

            if(opcao == null)
            {
                JOptionPane.showMessageDialog(null,"Obrigado por usar o nosso sistema. \nDynamics System.");
                System.out.println("cancelled");
                return;

            }else if(Integer.parseInt(opcao) > 3)
            {

                JOptionPane.showMessageDialog(null,"Opção Invalida");
                return;

            }else
            {
                this.setOptions(1,Integer.parseInt(opcao));
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Escolha uma opção válida");
            System.out.println("cancelled");
        }

    }

    //Executa a opção que o usuário selecionou no menu
    public void runOption()
    {

        if(this.getOptions()[1] == 1)
        {
            this.inserirDados();
        }
        else if(this.getOptions()[1] == 2)
        {
            this.listarDados();
        }
        else if(this.getOptions()[1] == 3)
        {
            this.deletarDados();
        }

    }

    public boolean validCampos()
    {

        for(JTextField J : campos )
        {
            if(J.getText().equals("") || J.getText().equals(null))
            {
                JOptionPane.showMessageDialog(null,"Campo " + J.getName() + " Não foi preenchido");

                return false;
            }
        }

        return true;

    }

    public void inserirDados()
    {
        this.painelRetorno(getOptions()[0]);//Constroe o painel de acordo com a seleção do usuário

        int result = JOptionPane.showConfirmDialog(null, this.panel , this.cTitle,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION)
        {

            if(this.validCampos()) {

                try {

                    if (this.getOptions()[0] == 1) {

                        this.setAluno(new Aluno(this.idAluno, getCampos().get(0).getText()));

                    } else if (this.getOptions()[0] == 2) {
                        TipoCurso tipo;

                        if (this.NivelCurso.getSelectedItem() == "Graduação") {
                            tipo = TipoCurso.graduacao;
                        } else {
                            tipo = TipoCurso.pos_graduacao;
                        }

                        this.setCurso(new Curso(getCampos().get(0).getText(), tipo, Integer.parseInt(getCampos().get(1).getText())));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }


        }
        else
        {
            System.out.println("Cancelled");
        }
    }


    //Constroe o painel de acordo com a seleção do usuário
    public void painelRetorno(int N)
    {
        //limpa o menu para a geração do próximo
        this.getCampos().clear();
        this.panel = null;
        this.panel = new JPanel(new GridLayout(0, 1));

        if(N == 1)
        {
            JTextField NomeAluno = new JTextField();
            NomeAluno.setName("Nome Aluno");
            this.getCampos().add(NomeAluno);

            this.panel.add(new JLabel("Nome do Aluno: "));
            this.panel.add(getCampos().get(0));

            this.cTitle = "Atualizar Alunos";

        }else if(N == 2)
        {

            JTextField NomeCurso = new JTextField();
            NomeCurso.setName("Nome Curso");
            this.getCampos().add(NomeCurso);

            this.NivelCurso = new JComboBox(new String[]{"Graduação","Pos Graduação"});

            JTextField AnoCurso = new JTextField();
            AnoCurso.setName("Ano Curso");
            this.getCampos().add(AnoCurso);

            this.panel.add(new JLabel("Nome do Curso: "));
            this.panel.add(NomeCurso);
            this.panel.add(new JLabel("Nivel do Curso: "));
            this.panel.add(this.NivelCurso);
            this.panel.add(new JLabel("Ano do Curso: "));
            this.panel.add(AnoCurso);

            this.cTitle = "Atualizar Cursos";

        }else if(N == 3)
        {

            JTextField id_do_aluno = new JTextField();
            id_do_aluno.setName("Id Aluno");
            this.getCampos().add(id_do_aluno);
            JTextField nota_NP1 = new JTextField();
            nota_NP1.setName("Nota NP1");
            this.getCampos().add(nota_NP1);
            JTextField nota_NP2 = new JTextField();
            nota_NP2.setName("Nota NP2");
            this.getCampos().add(nota_NP2);
            JTextField nota_reposicao = new JTextField();
            nota_reposicao.setName("Nota Reposicão");
            this.getCampos().add(nota_reposicao);
            JTextField nota_exame = new JTextField();
            nota_exame.setName("Nota Exame");
            this.getCampos().add(nota_exame);

            this.panel.add(new JLabel("ID Aluno: "));
            this.panel.add(id_do_aluno);
            this.panel.add(new JLabel("Nota NP!: "));
            this.panel.add(nota_NP1);
            this.panel.add(new JLabel("Nota NP2: "));
            this.panel.add(nota_NP2);
            this.panel.add(new JLabel("Nota de Reposicão: "));
            this.panel.add(nota_reposicao);
            this.panel.add(new JLabel("Nota exame: "));
            this.panel.add(nota_exame);

            this.cTitle = "Atualizar redimentos";

            int curso;
            int i = 0;
            String retorno = "";


            for(Curso c : cursos )
            {
                i++;
                retorno += i + ": " + c + "\n";
            }

            curso = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero do Curso para Inserir um rendimento: \n" + retorno));

            this.setCurso(cursos.get(curso -1));

        }

    }

    public void cargaAlunos(List<Aluno> students)
    {
        this.setStudents(students);
    }

    public void cargaCursos(List<Curso> courses)
    {
        this.setCursos(courses);
    }

    public void cargaRedimentos(List<Rendimento> rendimentos)
    {
        this.setRendimentos(rendimentos);
    }

    public void listarDados()
    {
        String retorno = "";

        if(this.getOptions()[0] == 1)
        {
            for(Aluno s : students)
            {
                if(!s.getStudentName().equals("Inscricao Cancelada"))
                {
                    retorno += s + "\n";
                }
            }

            JOptionPane.showMessageDialog(null,retorno);

        }else if (this.getOptions()[0] == 2)
        {
            int i = 0;
            for(Curso c : cursos )
            {
                i++;
                retorno += i + ": " + c + "\n";
            }

            JOptionPane.showMessageDialog(null,retorno);

        }else if (this.getOptions()[0] == 3)
        {
            int curso;


            int i = 0;
            for(Curso c : cursos )
            {
                i++;
                retorno += i + ": " + c + "\n";
            }

            curso = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero do Curso para listar seus rendimentos: \n" + retorno));

            retorno = "";

            for(Rendimento r : getRendimentos())
            {
                if(r.getCurso().equals(cursos.get(curso -1)))
                {
                    retorno += r;
                    if(r.isApproved())
                    {
                        retorno+=" (Aprovado) \n";
                    }
                    else
                    {
                        retorno+=" (Reprovado) \n";
                    }
                }
            }

            JOptionPane.showMessageDialog(null,retorno);

        }



    }

    public void deletarDados()
    {
        if(this.getOptions()[0] == 1)
        {

            this.aluno = students.get(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do Aluno a ser deletado")) - 1);

        }
        else if(this.getOptions()[0] == 2)
        {
            this.curso = cursos.get(Integer.parseInt(JOptionPane.showInputDialog("Digite o Numero do Curso a ser deletado")) - 1);
        }
        else if(this.getOptions()[0] == 3)
        {

        }
    }

    /**
     * @return the menus
     */
    public String getMenus(int n) {
        return menus[n];
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus(String[] menus) {
        this.menus = menus;
    }


    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public List<Aluno> getStudents() {
        return students;
    }

    public void setStudents(List<Aluno> students) {
        this.students = students;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int[] getOptions() {
        return options;
    }

    public void setOptions(int pos,int options) {
        this.options[pos] = options;
    }

    public List<Rendimento> getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(List<Rendimento> rendimentos) {
        this.rendimentos = rendimentos;
    }

    public Rendimento getRendimento() {
        return rendimento;
    }

    public void setRendimento(Rendimento rendimento) {
        this.rendimento = rendimento;
    }

    public List<JTextField> getCampos() {
        return campos;
    }

    public void setCampos(List<JTextField> campos) {
        this.campos = campos;
    }
}
