package com.udesc.artistas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistasModel {
    public static void create(ArtistasBean a, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
            "INSERT INTO autores (nome, generos) VALUES (?,?)");
        st.setString(1, a.getNome());
        st.setInt(2, a.getGeneroId());
        st.executeUpdate();
        st.close(); con.close();
    }

    public static List<ArtistasBean> listAll(Connection con) throws SQLException {
        Statement st = con.createStatement();
        List<ArtistasBean> list = new ArrayList<>();
        ResultSet result = st.executeQuery("SELECT a.id_autor, a.nome, g.nome, g.id_genero FROM public.autores a JOIN public.generos g on a.generos=g.id_genero");
        while (result.next()) {
            list.add(new ArtistasBean(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4)));
        }
        result.close(); st.close(); con.close();
        return list;
    }

    public static void remove(int n, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM autores WHERE id_autor=?");
        st.setInt(1, n);
        st.executeUpdate();
        st.close(); con.close();
    }

    public static void alterar(ArtistasBean a, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
            "UPDATE autores SET nome=?, generos=? WHERE id_autor=?");
        st.setString(1, a.getNome());
        st.setInt(2, a.getGeneroId());
        st.setInt(3, a.getId());
        st.executeUpdate();
        st.close(); con.close();
    }
}
