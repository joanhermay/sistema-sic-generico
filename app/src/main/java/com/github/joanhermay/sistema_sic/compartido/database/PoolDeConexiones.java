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
        config.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
        config.setJdbcUrl("jdbc:derby:g01_winexpand_database/sistema_contable_winexpand;create=true");
        config.setUsername("winexpand");
        config.setPassword("winexpand");
        return config;
    }

    static Connection obtenerConexion() throws SQLException {
        return ds.getConnection();
    }

}
