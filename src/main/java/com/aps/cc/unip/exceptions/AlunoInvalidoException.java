package com.aps.cc.unip.exceptions;

public class AlunoInvalidoException extends Exception {
    private String msg;

    public AlunoInvalidoException(){
        super("Aluno(s) Não Cadastrado(s)");
        this.msg = "Aluno(s) Não Cadastrado(s)";
    }

    public String getMsg() { return msg; }
}
