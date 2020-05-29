/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aps.cc.unip.front;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Gabriel Da Silva
 * @apiNote Classe necessária para controlar as interações do usuário.
 */
public class frontInterface 
{
    private String[] alunoForm;
    private String[] cursoForm;      
    private String[] rendimentoForm;
    private String[] menus;
    private String cTitle;
    private int[] options;
    private JPanel panel;
    private List<JTextField> campos = new ArrayList<>();
        
    public frontInterface()
    {
        //Confiduração inicial da interface
        this.alunoForm      = new String[2];
        this.cursoForm      = new String[3];
        this.rendimentoForm = new String[5];
        this.menus          = new String[2];
        this.menus[0]       = "Digite uma opção:\n1-Alunos\n2-Cursos\n3-Rendimentos\n4-Sair ";
        this.menus[1]       = "Digite uma opção:\n1-Inserir\n2-Listar\n3-Deletar ";
        this.options        = new int[2];
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
        this.options[0] = Integer.parseInt(JOptionPane.showInputDialog(getMenus(0)));
        if(this.options[0] == 4)
        {
            return;
        }
        this.options[1] = Integer.parseInt(JOptionPane.showInputDialog(getMenus(1)));
    }

    //Executa a opção que o usuário selecionou no menu
    public void runOption()
    {

        if(this.options[1] == 1)
        {
            this.inserirDados();
        }
        else if(this.options[1] == 2)
        {
            this.listarDados();
        }
        else if(this.options[1] == 3)
        {
            this.deletarDados();
        }

    }

    public void inserirDados()
    {
        this.painelRetorno(options[0]);//Constroe o painel de acordo com a seleção do usuário

        int result = JOptionPane.showConfirmDialog(null, this.panel , this.cTitle,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION)
        {



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
        this.campos.clear();
        this.panel = null;
        this.panel = new JPanel(new GridLayout(0, 1));
        
        if(N == 1)
        {
            JTextField NomeAluno = new JTextField();
            this.campos.add(NomeAluno);
            
            this.panel.add(new JLabel("Nome do Aluno: "));
            this.panel.add(NomeAluno);

            this.cTitle = "Atualizar Alunos";
            
        }else if(N == 2)
        {
            
            JTextField NomeCurso = new JTextField();
            this.campos.add(NomeCurso);
            JTextField NivelCurso = new JTextField();
            this.campos.add(NivelCurso);
            JTextField AnoCurso = new JTextField();
            this.campos.add(AnoCurso);
            
            this.panel.add(new JLabel("Nome do Curso: "));
            this.panel.add(NomeCurso);
            this.panel.add(new JLabel("Nivel do Curso: "));
            this.panel.add(NivelCurso);
            this.panel.add(new JLabel("Ano do Curso: "));
            this.panel.add(AnoCurso);

            this.cTitle = "Atualizar Cursos";

        }else if(N == 3)
        {

            JTextField id_do_aluno = new JTextField();
            this.campos.add(id_do_aluno);
            JTextField nota_NP1 = new JTextField();
            this.campos.add(nota_NP1);
            JTextField nota_NP2 = new JTextField();
            this.campos.add(nota_NP2);
            JTextField nota_reposicao = new JTextField();
            this.campos.add(nota_reposicao);
            JTextField nota_exame = new JTextField();
            this.campos.add(nota_exame);

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

        }

    }

    public void listarDados()
    {

    }

    public void deletarDados()
    {

    }

    /**
     * @return the alunoForm
     */
    public String[] getAlunoForm() {
        return alunoForm;
    }

    /**
     * @param alunoForm the alunoForm to set
     */
    public void setAlunoForm(String[] alunoForm) {
        this.alunoForm = alunoForm;
    }

    /**
     * @return the cursoForm
     */
    public String[] getCursoForm() {
        return cursoForm;
    }

    /**
     * @param cursoForm the cursoForm to set
     */
    public void setCursoForm(String[] cursoForm) {
        this.cursoForm = cursoForm;
    }

    /**
     * @return the rendimentoForm
     */
    public String[] getRendimentoForm() {
        return rendimentoForm;
    }

    /**
     * @param rendimentoForm the rendimentoForm to set
     */
    public void setRendimentoForm(String[] rendimentoForm) {
        this.rendimentoForm = rendimentoForm;
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
    
    
    
    
}
