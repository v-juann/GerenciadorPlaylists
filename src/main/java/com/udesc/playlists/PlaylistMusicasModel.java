package com.udesc.playlists;

import com.udesc.musicas.MusicasBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistMusicasModel {

    // Songs already in the playlist (with names via JOIN)
    public static List<MusicasBean> listByPlaylist(int idPlaylist, Connection con) throws SQLException {
        List<MusicasBean> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
            "SELECT m.id_musica, m.titulo, m.duracao, m.ano, " +
            "       m.id_genero, m.artista, g.nome, a.nome " +
            "FROM musicas_playlist mp " +
            "JOIN musicas m  ON mp.id_musica   = m.id_musica " +
            "JOIN generos g  ON m.id_genero    = g.id_genero " +
            "JOIN autores a  ON m.artista       = a.id_autor " +
            "WHERE mp.id_playlist = ?"
        );
        ps.setInt(1, idPlaylist);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new MusicasBean(
                rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8)
            ));
        }
        rs.close(); ps.close(); con.close();
        return lista;
    }

    // Songs NOT yet in the playlist
    public static List<MusicasBean> listAvailable(int idPlaylist, Connection con) throws SQLException {
        List<MusicasBean> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
            "SELECT m.id_musica, m.titulo, m.duracao, m.ano, " +
            "       m.id_genero, m.artista, g.nome, a.nome " +
            "FROM musicas m " +
            "JOIN generos g ON m.id_genero = g.id_genero " +
            "JOIN autores a ON m.artista    = a.id_autor " +
            "WHERE m.id_musica NOT IN (" +
            "    SELECT id_musica FROM musicas_playlist WHERE id_playlist = ?" +
            ")"
        );
        ps.setInt(1, idPlaylist);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new MusicasBean(
                rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8)
            ));
        }
        rs.close(); ps.close(); con.close();
        return lista;
    }

    // Add a song to the playlist
    public static void addMusica(int idPlaylist, int idMusica, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO musicas_playlist (id_playlist, id_musica) VALUES (?, ?)"
        );
        ps.setInt(1, idPlaylist);
        ps.setInt(2, idMusica);
        ps.executeUpdate();
        ps.close(); con.close();
    }

    // Remove a song from the playlist
    public static void removeMusica(int idPlaylist, int idMusica, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM musicas_playlist WHERE id_playlist = ? AND id_musica = ?"
        );
        ps.setInt(1, idPlaylist);
        ps.setInt(2, idMusica);
        ps.executeUpdate();
        ps.close(); con.close();
    }
}