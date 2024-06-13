package com.example.trabalhojogo.domain.Enum;

public enum EPlataforma {
    PC("PC"),
    XBOXSERIESX("Xbox Series X"),
    PLAYSTATION5("PlayStation 5"),
    SWITCH("Nintendo Switch"),
    ANDROID("Android"),
    IOS("IOS");

    private String valor;

    private EPlataforma(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }
}
