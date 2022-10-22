/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.estadoderesultado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author joanhermay
 */
public class ControladorVistaEstadoDeResultado implements ActionListener {
    private final VistaEstadoDeResultado edr;

    public ControladorVistaEstadoDeResultado(VistaEstadoDeResultado edr) {
        this.edr = edr;
    }
    
    public void mostrar() {
        edr.setVisible(true);
    }
    
    public void noMostrar() {
        edr.setVisible(true);
    }
    
    public void cerrar() {
        edr.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
   
}
