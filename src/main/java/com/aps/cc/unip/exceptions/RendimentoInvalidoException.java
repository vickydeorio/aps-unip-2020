package main.java.com.aps.cc.unip.exceptions;

public class RendimentoInvalidoException extends Exception {
    private String msg;

    public RendimentoInvalidoException(){
        super("Rendimento(s) Não Cadastrado(s)");
        this.msg = "Rendimento(s) Não Cadastrado(s)";
    }

    public String getMsg() { return msg; }
}
