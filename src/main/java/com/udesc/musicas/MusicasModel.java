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
        ResultSet result = st.executeQuery("SELECT * FROM musicas");
        while (result.next()) {
            lista.add(new MusicasBean(
                result.getInt("id_musica"),
                result.getString("titulo"),
                result.getString("duracao"),
                result.getString("ano"),
                result.getInt("id_genero"),
                result.getInt("artista")
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
