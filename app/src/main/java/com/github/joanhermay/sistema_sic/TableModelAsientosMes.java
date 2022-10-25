package com.github.joanhermay.sistema_sic;

import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.AsientoContableRecord;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelAsientosMes extends AbstractTableModel {
    private List<AsientoContableRecord> asientosMes = new ArrayList<>();

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID Asiento";
            case 1 -> "Fecha de asiento";
            case 2 -> "Concepto";
            default -> throw new IllegalStateException("Unexpected value: " + column);
        };
    }

    @Override
    public int getRowCount() {
        return asientosMes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AsientoContableRecord asiento = asientosMes.get(rowIndex);
        return switch (columnIndex) {

            case 0 -> asiento.getIdAsientoContable();
            case 1 -> asiento.getFechaDeCreacionPartida();
            case 2 -> asiento.getConceptoAsientoContable();
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    public void agregarAsiento(AsientoContableRecord asiento) {
        asientosMes.add(asiento);
    }

    public void limpiarTodo() {
        asientosMes.clear();
    }

    public void setNuevaLista(List<AsientoContableRecord> asientosMes) {
        this.asientosMes.clear();
        this.asientosMes = asientosMes;
    }
}
