package com.udesc.playlists;

public class PlaylistsBean {
    private int idPlaylist;
    private String nome;
    private String tipo;

    public PlaylistsBean(int idPlaylist, String nome, String tipo) {
        this.idPlaylist = idPlaylist;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PlaylistsBean{" + "idPlaylist=" + idPlaylist + ", nome=" + nome + ", tipo=" + tipo + '}';
    }
    
}
