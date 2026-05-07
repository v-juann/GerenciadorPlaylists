package com.udesc.musicas;

public class MusicasBean {

    private int idMusica;
    private String titulo;
    private String duracao;
    private String ano;
    private int idGenero;
    private int artista;
    private String nomeGenero;
    private String nomeArtista;

    public MusicasBean() {
    }

    // Original 6-param constructor — used when saving (add/edit)
    public MusicasBean(int idMusica, String titulo, String duracao, String ano,
                    int idGenero, int artista) {
        this.idMusica = idMusica;
        this.titulo = titulo;
        this.duracao = duracao;
        this.ano = ano;
        this.idGenero = idGenero;
        this.artista = artista;
    }

    // New 8-param constructor — used when loading for display (listAll)
    public MusicasBean(int idMusica, String titulo, String duracao, String ano,
                    int idGenero, int artista, String nomeGenero, String nomeArtista) {
        this(idMusica, titulo, duracao, ano, idGenero, artista); // reuse the 6-param one
        this.nomeGenero = nomeGenero;
        this.nomeArtista = nomeArtista;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getArtista() {
        return artista;
    }

    public void setArtista(int artista) {
        this.artista = artista;
    }

    public String getNomeGenero() { 
        return nomeGenero; 
    }

    public String getNomeArtista() { 
        return nomeArtista; 
    }

    @Override
    public String toString() {
        return "MusicasBean{" + "idMusica=" + idMusica + ", titulo=" + titulo + ", duracao=" + duracao + ", ano=" + ano + ", idGenero=" + idGenero + ", artista=" + artista + '}';
    }
    
}
