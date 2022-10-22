/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.catalogo.controladores;

import com.github.joanhermay.sistema_sic.catalogo.modelos.DTORubroDeAgrupacion;
import com.github.joanhermay.sistema_sic.catalogo.modelos.DTOCuenta;
import com.github.joanhermay.sistema_sic.catalogo.modelos.DTOClasificacionGeneral;
import javax.swing.JDialog;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author joanhermay
 */
public abstract class AbstractControladorCatalogoDeCuentas {

    private DefaultTreeModel model;
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode(null);
    private DefaultMutableTreeNode clasificaciones = new DefaultMutableTreeNode(null);
    private DefaultMutableTreeNode rubros = new DefaultMutableTreeNode(null);
    private final JDialog vistaActual;

    public AbstractControladorCatalogoDeCuentas(JDialog vista) {
        root.add(clasificaciones);
        root.add(rubros);
        this.vistaActual = vista;
    }

    public void agregarClasificacionGeneral(DTOClasificacionGeneral cg) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(cg.getCodigo() + " - " + cg.getNombre());
        this.model.insertNodeInto(node, root, root.getChildCount());
    }

    public void removerNodo(MutableTreeNode node) {
        this.model.removeNodeFromParent(node);
    }

    public void removerNodo(DefaultMutableTreeNode node) {
        this.model.removeNodeFromParent(node);
    }

    public void agregarRubro(DTORubroDeAgrupacion ra) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(ra.getCodigo() + " - " + ra.getNombre());
        this.model.insertNodeInto(node, clasificaciones, clasificaciones.getChildCount());
    }

    public void agregarCuenta(DTOCuenta c) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(c.getCodigo() + " - " + c.getNombre());
        this.model.insertNodeInto(node, rubros, rubros.getChildCount());
    }
}
