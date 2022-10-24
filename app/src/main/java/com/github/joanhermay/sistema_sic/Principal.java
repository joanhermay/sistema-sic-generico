/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

/**
 *
 * @author joanhermay
 */
public class Principal {
    public static void main(String args[]) {
        prepararGuiConToquesVisuales();
        VistaPrincipal vp = new VistaPrincipal();
        ControladorVistaPrincipal c = new ControladorVistaPrincipal(vp);
        c.mostrar();
    }

    private static void prepararGuiConToquesVisuales() {
        FlatLightLaf.setup();
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.arc", 999);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 999);
    }
}
