package com.example.trabalhojogo.domain.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String mensagem){
        super(mensagem);
    }
}
