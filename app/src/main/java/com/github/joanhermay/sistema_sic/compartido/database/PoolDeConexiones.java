/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.compartido.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author joanhermay
 */
public final class PoolDeConexiones {

    private static HikariDataSource ds;

    static {
        ds = new HikariDataSource(getConfig());
    }

    private PoolDeConexiones() {
    }

    private static HikariConfig getConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/bd_sistema_sic");
        config.setUsername("admin");
        config.setPassword("admin");
        return config;
    }

    static Connection obtenerConexion() throws SQLException {
        return ds.getConnection();
    }

}
