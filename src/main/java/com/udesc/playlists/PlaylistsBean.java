package com.udesc.playlists;

public class PlaylistsBean {
    private int idPlaylist;
    private String nome;

    public PlaylistsBean(int idPlaylist, String nome) {
        this.idPlaylist = idPlaylist;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "PlaylistsBean{" + "idPlaylist=" + idPlaylist + ", nome=" + nome + '}';
    }
    
}
