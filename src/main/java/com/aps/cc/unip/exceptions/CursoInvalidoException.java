package main.java.com.aps.cc.unip.exceptions;

public class CursoInvalidoException extends Exception {
    private String msg;

    public CursoInvalidoException(){
        super("Curso(s) Não Cadastrado(s)");
        this.msg = "Curso(s) Não Cadastrado(s)";
    }

    public String getMsg() { return msg; }
}
