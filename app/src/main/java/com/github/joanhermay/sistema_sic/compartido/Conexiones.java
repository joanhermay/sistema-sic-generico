/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.compartido;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.swing.*;

/**
 * @author joanhermay
 */
public final class Conexiones {

    private static final DSLContext consulta;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/sic");
        config.setUsername("root");
        config.setPassword("asd");
        HikariDataSource ds = null;
        try {
            ds = new HikariDataSource(config);
            JOptionPane.showMessageDialog(null, "Conectado a base de datos", "Inicializando", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos", "ERROR DE CONXION", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Procediendo a salir", "SALIR", JOptionPane.INFORMATION_MESSAGE);
            System.exit(512);
        }
        consulta = DSL.using(ds, SQLDialect.MARIADB);
    }

    private Conexiones() {
    }

    public static DSLContext getConsulta() {
        return consulta;
    }
}
