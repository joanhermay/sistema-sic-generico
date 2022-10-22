/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic;

import com.github.joanhermay.sistema_sic.librodiario.controladores.ControladorVistaRegistroEdicionAsientosDeDiario;
import com.github.joanhermay.sistema_sic.librodiario.vistas.VistaRegistroEdicionAsientosDeDiario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author joanhermay
 */
public class ControladorVistaPrincipal implements ActionListener {

    private final VistaPrincipal vp;
    ControladorVistaRegistroEdicionAsientosDeDiario controladorRegEdAsientos;

    public ControladorVistaPrincipal(VistaPrincipal vp) {
        this.vp = vp;
        controladorRegEdAsientos = new ControladorVistaRegistroEdicionAsientosDeDiario(new VistaRegistroEdicionAsientosDeDiario(vp, true));

        // Add action listeners
        this.vp.btnRegistrarMovimiento.addActionListener(this);
        this.vp.btnRegistrarNuenoAsiento.addActionListener(this);

        this.vp.munuItemVerCatalogoDeCuenta.addActionListener(this);
        this.vp.setExtendedState(VistaPrincipal.MAXIMIZED_BOTH);
        this.vp.setLocationRelativeTo(null);
    }

    public void mostrar() {
        this.vp.setTitle("SISTEMA CONTABLE - NOMBRE EMPRESA");
        this.vp.txtTituloApp.setText("SISTEMA CONTABLE - NOMBRE EMPRESA");
        this.vp.setVisible(true);
    }

    public void noMostrar() {
        vp.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vp.munuItemVerCatalogoDeCuenta) {

        } else if (e.getSource() == vp.btnRegistrarNuenoAsiento) {
            controladorRegEdAsientos.mostrar();
        }
    }

}
