package com.udesc.playlists;

import java.sql.*;
import java.util.*;
import com.udesc.gerenciador.Database;

public class PlaylistsModel {
    static void create(PlaylistsBean p, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO playlists (nome, tipo) VALUES (?, ?)");
        ps.setString(1, p.getNome());
        ps.setString(2, p.getTipo());
        ps.executeUpdate();
        ps.close(); con.close();
    }
    
    static List<PlaylistsBean> listAll(Connection con) throws SQLException {
        List<PlaylistsBean> lista = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM playlists");
        while (rs.next()) {
            lista.add(new PlaylistsBean(rs.getInt("id_playlist"), rs.getString("nome"), rs.getString("tipo")));
        }
        rs.close(); stmt.close(); con.close();
        return lista;
    }    

    static void remove(int n, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM playlists WHERE id_playlist=?");
        ps.setInt(1, n);
        ps.executeUpdate();
        ps.close(); con.close();
    }

    static void alterar(PlaylistsBean p, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE playlists SET nome=?, tipo=? WHERE id_playlist=?");
        ps.setString(1, p.getNome());
        ps.setString(2, p.getTipo());
        ps.setInt(3, p.getIdPlaylist());
        ps.executeUpdate();
        ps.close(); con.close();     
    }
}
