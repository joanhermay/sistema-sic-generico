package com.github.joanhermay.sistema_sic.librodiario;

import com.github.joanhermay.sistema_sic.compartido.Conexiones;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.AsientoContable;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.AsientoContableRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.swing.JOptionPane;

public class ControladorRegistroEdicionAsientosContables {

    VistaRegistroEdicionAsientosDeDiario vista;
    int anio;
    int mes;
    Integer idLibroDiario;

    public ControladorRegistroEdicionAsientosContables(VistaRegistroEdicionAsientosDeDiario vista, int anio, int mes, Integer idLibroDiario) {
        this.vista = vista;
        this.anio = anio;
        this.mes = mes;
        this.idLibroDiario = idLibroDiario;
        init();
        armarAccionar();
    }

    private void init() {
        LocalDate mesAsiento = LocalDate.of(anio, mes, 1);
        mesAsiento.datesUntil(LocalDate.of(anio, mes + 1, 1)).forEach(f -> {
            vista.cbFecha.addItem(f.format(DateTimeFormatter.ISO_DATE));
        });
        vista.cbFecha.setSelectedIndex(LocalDate.now().getDayOfMonth() - 1);
    }

    private void armarAccionar() {
        vista.checkBOtraFecha.addActionListener(a -> {
            vista.cbFecha.setEnabled(vista.checkBOtraFecha.isSelected());
        });

        vista.btnCancelar.addActionListener(a -> {
            vista.dispose();
        });

        vista.btnGuardar.addActionListener(a -> {
            AsientoContableRecord asientoContableNuevo = Conexiones.getConsulta().newRecord(AsientoContable.ASIENTO_CONTABLE);

            asientoContableNuevo.setConceptoAsientoContable(vista.txtAreaConceptoPartida.getText());
            LocalDate c = LocalDate.parse(Objects.requireNonNull(vista.cbFecha.getSelectedItem()).toString());

            asientoContableNuevo.setIdLibroDiario(idLibroDiario);
            asientoContableNuevo.setConceptoAsientoContable(vista.txtAreaConceptoPartida.getText());
            asientoContableNuevo.setFechaDeCreacionPartida(c);
            asientoContableNuevo.store();
            do {
                ControladorRegistroEdicionMovimientoEspecifico con = new ControladorRegistroEdicionMovimientoEspecifico(new VistaRegistroEdicionMovimientoEspecifico(null, true), asientoContableNuevo.getIdAsientoContable());
                con.mostrar();
            } while (JOptionPane.showOptionDialog(null, "Agregar otro movimiento", "Agregar otro movimiento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null) == JOptionPane.OK_OPTION);
            vista.dispose();
        });
    }

    public void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}
