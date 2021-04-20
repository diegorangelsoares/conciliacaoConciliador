package com.conciliacaocob.conciliacaoConciliador.controller;

public class EmissorResponse {

    public long id;
    public String nome;

    public EmissorResponse(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
