package com.github.joanhermay.sistema_sic.periodocontable;

import com.github.joanhermay.sistema_sic.compartido.Conexiones;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.LibroDiario;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.PeriodoContable;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.LibroDiarioRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.PeriodoContableRecord;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ControladorVistaNuevoPeriodoContable {
    
    VistaNuevoPeriodoContable vista;
    
    public ControladorVistaNuevoPeriodoContable(VistaNuevoPeriodoContable vista) {
        this.vista = vista;
        init();
    }
    
    public void init() {
        vista.jTextField1.setText(String.valueOf(LocalDate.now().getYear()));
        vista.checkOtroAnio.addActionListener(a -> {
            if (vista.checkOtroAnio.isSelected()) {
                vista.jTextField1.setEnabled(true);
            } else {
                vista.jTextField1.setEnabled(false);
            }
        });
        
        vista.btnCrear.addActionListener(a -> {
            int anio = Integer.parseInt(String.valueOf(vista.jTextField1.getText()));
            PeriodoContableRecord p = Conexiones.getConsulta().newRecord(PeriodoContable.PERIODO_CONTABLE);
            
            p.setFechaInicioPeriodoContable(LocalDate.of(anio, 1, 1));
            p.setIdEstadoDelPeriodoContable(1);
            p.store();
            for (int i = 1; i <= 12; i++) {
                LibroDiarioRecord ld = Conexiones.getConsulta().newRecord(LibroDiario.LIBRO_DIARIO);
                ld.setIdPeriodoContable(p.getIdPeriodoContable());
                ld.setFechaInicioMesLibroDiario(LocalDate.of(anio, i, 1));
                ld.store();
            }
            JOptionPane.showMessageDialog(vista, "Periodo contable, y sus libros diarios, fueron creados correctamente");
            vista.dispose();
        });
    }
    
    public void mostrar() {
        vista.setVisible(true);
    }
}
