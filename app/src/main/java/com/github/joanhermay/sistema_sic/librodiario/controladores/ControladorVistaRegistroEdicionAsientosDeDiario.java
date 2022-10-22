/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.librodiario.controladores;

import com.github.joanhermay.sistema_sic.librodiario.vistas.VistaRegistroEdicionAsientosDeDiario;

/**
 *
 * @author joanhermay
 */
public class ControladorVistaRegistroEdicionAsientosDeDiario {

    private final VistaRegistroEdicionAsientosDeDiario vr;

    public ControladorVistaRegistroEdicionAsientosDeDiario(VistaRegistroEdicionAsientosDeDiario vr) {
        this.vr = vr;
    }

    public void mostrar() {
        vr.setVisible(true);
    }

    public void noMostrar() {
        vr.setVisible(false);
    }

}
