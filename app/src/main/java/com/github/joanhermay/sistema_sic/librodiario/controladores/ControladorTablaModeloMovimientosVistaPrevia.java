/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.librodiario.controladores;

import com.github.joanhermay.sistema_sic.librodiario.modelos.DTOMovimiento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joanhermay
 */
public class ControladorTablaModeloMovimientosVistaPrevia extends AbstractTableModel {

    private List<DTOMovimiento> movimientos;

    public void add(DTOMovimiento movimiento) {
        this.movimientos.add(movimiento);
    }

    public void addList(List<DTOMovimiento> movimientos) {
        this.movimientos.clear();
        this.movimientos = movimientos;
    }

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return movimientos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new IllegalArgumentException("");
    }

}
