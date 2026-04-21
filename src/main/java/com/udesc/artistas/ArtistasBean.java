package com.udesc.artistas;

public class ArtistasBean {
    private int id;
    private String nome;
    private int genero;

    public ArtistasBean(int id, String nome, int genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
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

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "ArtistasBean{" + "id=" + id + ", nome=" + nome + ", genero=" + genero + '}';
    }

}
