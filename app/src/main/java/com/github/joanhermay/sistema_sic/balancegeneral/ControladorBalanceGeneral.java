/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.balancegeneral;

/**
 *
 * @author joanhermay
 */
public class ControladorBalanceGeneral {
    
    private final VistaBalanceGeneral bg;

    public ControladorBalanceGeneral(VistaBalanceGeneral bg) {
        this.bg = bg;
    }
    
    public void mostrar() {
        bg.setVisible(true);
    }
    
    
}
