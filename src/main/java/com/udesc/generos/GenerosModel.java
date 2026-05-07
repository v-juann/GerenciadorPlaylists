package com.udesc.generos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenerosModel {
    public static void create(GenerosBean g, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO generos (nome) VALUES (?)");
        ps.setString(1, g.getNome());
        ps.executeUpdate();
        ps.close(); con.close();
    }

    public static List<GenerosBean> listAll(Connection con) throws SQLException {
        List<GenerosBean> lista = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM generos");
        while (rs.next()) {
            lista.add(new GenerosBean(rs.getInt("id_genero"), rs.getString("nome")));
        }
        rs.close(); stmt.close(); con.close();
        return lista;
    }

    public static void remove(int n, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM generos WHERE id_genero=?");
        ps.setInt(1, n);
        ps.executeUpdate();
        ps.close(); con.close();
    }

    public static void alterar(GenerosBean g, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE generos SET nome=? WHERE id_genero=?");
        ps.setString(1, g.getNome());
        ps.setInt(2, g.getIdGenero());
        ps.executeUpdate();
        ps.close(); con.close();
    }
}
