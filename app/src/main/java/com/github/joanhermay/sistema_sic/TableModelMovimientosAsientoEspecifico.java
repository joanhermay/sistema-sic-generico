package com.github.joanhermay.sistema_sic;

import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.MovimientosAsientoContableRecord;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelMovimientosAsientoEspecifico extends AbstractTableModel {
    private List<JoanHermayMovimientosMesAsiento> movimientosMes = new ArrayList<>();

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Codigo ddd";
            case 1 -> "Cuenta";
            case 2 -> "Debe";
            case 3 -> "Haber";
            default -> throw new IllegalStateException("Unexpected value: " + column);
        };
    }

    @Override
    public int getRowCount() {
        return movimientosMes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JoanHermayMovimientosMesAsiento mov = movimientosMes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> mov.getCodigoCuenta();
            case 1 -> mov.getNombreCuenta();
            case 2 -> mov.isEsMovimientoDebe() ? mov.getMonto() : "";
            case 3 -> !mov.isEsMovimientoDebe() ? mov.getMonto() : "";
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    public void agregarMovimiento(JoanHermayMovimientosMesAsiento movimiento) {
        movimientosMes.add(movimiento);
    }

    public void limpiarTodo() {
        movimientosMes.clear();
    }

    public void setNuevaLista(List<JoanHermayMovimientosMesAsiento> movimientosMesAsiento) {
        movimientosMes.clear();
        movimientosMes = movimientosMesAsiento;
    }
}
