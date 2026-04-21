package com.udesc.artistas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistasModel {
    static void create(ArtistasBean a, Connection con) throws SQLException {
    PreparedStatement st;
        st = con.prepareStatement("INSERT INTO autores (id_autor, nome, generos) "
                + "VALUES (?,?,?)");
        st.setInt(1, a.getId());
        st.setString(2, a.getNome());
        st.setInt(3, a.getGenero());
        st.executeUpdate();
        st.close(); con.close();
    }
    
    static List<ArtistasBean> listAll(Connection con) throws SQLException {
        Statement st = con.createStatement();;
        List<ArtistasBean> list = new ArrayList<ArtistasBean>();
        String sql = "SELECT id_autor, nome, generos FROM autores";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            list.add(new ArtistasBean(result.getInt(1), result.getString(2), result.getInt(3)));
        }
        result.close(); st.close(); con.close();
        return list;
    }    

    static void remove(int n, Connection con) throws SQLException {
        String sql = "DELETE FROM autores where id_autor=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, n);
        st.executeUpdate();
        st.close(); con.close();
    }

    static void alterar(ArtistasBean a, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("UPDATE autores SET nome=?,generos=? WHERE cod=?");
        st.setString(1, a.getNome());
        st.setInt(2, a.getGenero());
        st.setInt(3, a.getId());
        st.executeUpdate();
        st.close(); con.close();         
    }
}
