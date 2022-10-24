/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.compartido;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joanhermay
 */
public final class Conexion {

    private static HikariDataSource ds;

    static {
        try {
            ds = new HikariDataSource(getConfig());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede establecer conexion con la base de datos");
        }
    }

    private Conexion() {
    }

    private static HikariConfig getConfig() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/sic");
        config.setUsername("root");
        config.setPassword("asd");
        return config;
    }

    public static Connection obtenerConexion() throws SQLException {
        return ds.getConnection();
    }

}
