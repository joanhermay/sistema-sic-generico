package com.github.joanhermay.sistema_sic.librodiario;

import com.github.joanhermay.sistema_sic.compartido.Conexiones;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.AsientoContable;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.Cuenta;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.LibroDiario;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.AsientoContableRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.github.joanhermay.sistema_sic.tablas_bd.tables.AsientoContable.ASIENTO_CONTABLE;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.LibroDiario.LIBRO_DIARIO;

public class ControladorRegistroEdicionAsientosContables {
    VistaRegistroEdicionAsientosDeDiario vista;
    int anio;
    int mes;

    public ControladorRegistroEdicionAsientosContables(VistaRegistroEdicionAsientosDeDiario vista, int anio, int mes) {
        this.vista = vista;
        this.anio = anio;
        this.mes = mes;
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
            AsientoContableRecord r = new AsientoContableRecord();
            r.setConceptoAsientoContable(vista.txtAreaConceptoPartida.getText());
            LocalDate c = LocalDate.parse(Objects.requireNonNull(vista.cbFecha.getSelectedItem()).toString());
            r.setFechaDeCreacionPartida(c);

            //r.setIdLibroDiario();


            //ControladorRegistroEdicionMovimientoEspecifico c = new ControladorRegistroEdicionMovimientoEspecifico(new VistaRegistroEdicionMovimientoEspecifico(null, true), anio, mes);
            //c.mostrar();

        });
    }

    public void mostrar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }


}
