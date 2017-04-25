package com.david.model;

/**
 * Created by david on 24/04/2017.
 */
public class Movie {

    private long id;
    private String nome;

    public Movie(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
