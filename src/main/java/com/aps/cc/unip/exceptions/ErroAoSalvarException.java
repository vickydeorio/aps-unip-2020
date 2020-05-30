package com.aps.cc.unip.exceptions;

public class ErroAoSalvarException extends Exception{
    private String msg;

    public ErroAoSalvarException(){
        super("Algo deu errado ao salvar os dados");
        this.msg = "Algo deu errado ao salvar os dados";
    }

    public String getMsg() { return msg; }
}
