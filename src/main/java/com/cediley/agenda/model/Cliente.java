package com.cediley.agenda.model;

public class Cliente {
    private final String nome;
    private final String telefone;
    private final String email;
    private final String descricao;

    public Cliente(String nome, String telefone, String email, String descricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome;
    }
}
