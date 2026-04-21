package com.udesc.musicas;

public class MusicasBean {
    private int idMusica;
    private String titulo;
    private String duracao;
    private String ano;
    private int idGenero;
    private int artista;

    public MusicasBean() {}
    public MusicasBean(int idMusica, String titulo, String duracao, String ano, int idGenero, int artista) {
        this.idMusica = idMusica;
        this.titulo = titulo;
        this.duracao = duracao;
        this.ano = ano;
        this.idGenero = idGenero;
        this.artista = artista;
    }
    public int getIdMusica() { return idMusica; }
    public void setIdMusica(int idMusica) { this.idMusica = idMusica; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDuracao() { return duracao; }
    public void setDuracao(String duracao) { this.duracao = duracao; }
    public String getAno() { return ano; }
    public void setAno(String ano) { this.ano = ano; }
    public int getIdGenero() { return idGenero; }
    public void setIdGenero(int idGenero) { this.idGenero = idGenero; }
    public int getArtista() { return artista; }
    public void setArtista(int artista) { this.artista = artista; }
}
