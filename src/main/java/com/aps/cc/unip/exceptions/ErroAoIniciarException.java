package com.aps.cc.unip.exceptions;

public class ErroAoIniciarException extends Exception {
    private String msg;

    public ErroAoIniciarException(){
        super("Algo deu errado ao iniciar a aplicação\n" +
                "Confira os endereços da base de dados (arquivo .csv)");
        this.msg = "Algo deu errado ao iniciar a aplicação\n" +
                "Confira os endereços da base de dados (arquivo .csv)";
    }

    public String getMsg() { return msg; }
}
