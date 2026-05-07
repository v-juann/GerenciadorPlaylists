package com.udesc.musicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusicasModel {
    public static void create(MusicasBean m, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO musicas (titulo, duracao, ano, id_genero, artista) VALUES (?,?,?,?,?)");
        ps.setString(1, m.getTitulo());
        ps.setString(2, m.getDuracao());
        ps.setString(3, m.getAno());
        ps.setInt(4, m.getIdGenero());
        ps.setInt(5, m.getArtista());
        ps.executeUpdate();
        ps.close(); con.close();
    }

    public static List<MusicasBean> listAll(Connection con) throws SQLException {
        Statement st = con.createStatement();
        List<MusicasBean> lista = new ArrayList<>();
        ResultSet result = st.executeQuery(
            "SELECT m.id_musica, m.titulo, m.duracao, m.ano, " +
            "       m.id_genero, m.artista, g.nome, a.nome " +
            "FROM musicas m " +
            "JOIN generos g ON m.id_genero = g.id_genero " +
            "JOIN autores a ON m.artista = a.id_autor"
        );
        while (result.next()) {
            lista.add(new MusicasBean(
                result.getInt(1),
                result.getString(2),
                result.getString(3),
                result.getString(4),
                result.getInt(5),
                result.getInt(6),
                result.getString(7),
                result.getString(8)
            ));
        }
        result.close(); st.close(); con.close();
        return lista;
    }

    public static void remove(int n, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM musicas WHERE id_musica=?");
        st.setInt(1, n);
        st.executeUpdate();
        st.close(); con.close();
    }

    public static void alterar(MusicasBean m, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
            "UPDATE musicas SET titulo=?, duracao=?, ano=?, id_genero=?, artista=? WHERE id_musica=?");
        st.setString(1, m.getTitulo());
        st.setString(2, m.getDuracao());
        st.setString(3, m.getAno());
        st.setInt(4, m.getIdGenero());
        st.setInt(5, m.getArtista());
        st.setInt(6, m.getIdMusica());
        st.executeUpdate();
        st.close(); con.close();
    }
}
