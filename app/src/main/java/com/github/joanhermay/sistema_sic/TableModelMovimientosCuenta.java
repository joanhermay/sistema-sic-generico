package com.github.joanhermay.sistema_sic;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelMovimientosCuenta extends AbstractTableModel {
    List<MovimientoCuentaLM> movimientoCuentaLMS = new ArrayList<>();

    @Override
    public int getRowCount() {
        return movimientoCuentaLMS.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Debe";
            case 1 -> "Haber";
            default -> "Error";
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MovimientoCuentaLM movimientoCuentaLM = movimientoCuentaLMS.get(rowIndex);
        return switch (columnIndex) {
            case 1 -> movimientoCuentaLM.getMontoDebe();
            case 2 -> movimientoCuentaLM.getMontoHaber();
            default -> throw new IllegalStateException("Unexpected value: " + columnIndex);
        };
    }

    public void limpiarTodo() {
        movimientoCuentaLMS.clear();
    }
}
