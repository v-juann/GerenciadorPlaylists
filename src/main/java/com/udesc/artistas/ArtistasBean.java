package com.udesc.artistas;

public class ArtistasBean {
    private int id;
    private String nome;
    private String genero;
    private int generoId;

    public ArtistasBean(int id, String nome, String genero, int generoId) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.generoId = generoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int genero) {
        this.generoId = genero;
    }

    @Override
    public String toString() {
        return id + " - " + nome ;
    }

}
