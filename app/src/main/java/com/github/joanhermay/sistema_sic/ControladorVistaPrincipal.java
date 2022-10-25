package com.github.joanhermay.sistema_sic;

import com.github.joanhermay.sistema_sic.librodiario.VistaRegistroEdicionAsientosDeDiario;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.*;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.AsientoContableRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.CuentaRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.EstadoPeriodoContableRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.PeriodoContableRecord;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Result;
import org.jooq.impl.QOM;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.github.joanhermay.sistema_sic.compartido.Conexiones.getConsulta;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.AsientoContable.ASIENTO_CONTABLE;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.ClasificacionGeneral.CLASIFICACION_GENERAL;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.Cuenta.CUENTA;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.EstadoPeriodoContable.ESTADO_PERIODO_CONTABLE;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.MovimientosAsientoContable.MOVIMIENTOS_ASIENTO_CONTABLE;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.PeriodoContable.PERIODO_CONTABLE;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.RubroDeAgrupacion.RUBRO_DE_AGRUPACION;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.TipoDeMovimiento.TIPO_DE_MOVIMIENTO;
import static java.util.Objects.requireNonNull;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

public final class ControladorVistaPrincipal {

    TableModelAsientosMes modeloAsientosMensuales;
    TableModelMovimientosAsiento modeloMovimientosAsiento;

    TableModelMovimientosCuenta modeloMovimientosCuentaLM;


    static Result<Record3<Integer, String, String>> clasificacionesIdCodNombre;
    static Result<Record3<Integer, String, String>> rubrosEnClasificacionesIdCodNombre;
    static Result<Record3<Integer, String, String>> cuentasEnRubrosIdCodNombre;

    static {
        clasificacionesIdCodNombre = getConsulta().select(CLASIFICACION_GENERAL.ID_CLASIFICACION_GENERAL, CLASIFICACION_GENERAL.CODIGO_CLASIFICACION_GENERAL, CLASIFICACION_GENERAL.NOMBRE_CLASIFICACION_GENERAL).from(CLASIFICACION_GENERAL).fetch();
        rubrosEnClasificacionesIdCodNombre = getConsulta().select(RUBRO_DE_AGRUPACION.ID_CLASIFICACION_GENERAL, RUBRO_DE_AGRUPACION.CODIGO_RUBRO_DE_AGRUPACION, RUBRO_DE_AGRUPACION.NOMBRE_RUBRO_DE_AGRUPACION).from(RUBRO_DE_AGRUPACION).fetch();
        cuentasEnRubrosIdCodNombre = getConsulta().select(CUENTA.ID_CUENTA, CUENTA.CODIGO_CUENTA, CUENTA.NOMBRE_CUENTA).from(CUENTA).fetch();
    }

    VistaPrincipal vista;

    public ControladorVistaPrincipal(VistaPrincipal vp) {
        vista = vp;
        init();
        armarAccionar();
    }

    public void mostrar() {
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vista.setVisible(true);
    }


    private void actualizarAsientos() {
        int anio = Integer.parseInt(requireNonNull(vista.cbAnioPeriodoContable.getSelectedItem()).toString());
        int mes = vista.cbMesPeriodoContable.getSelectedIndex() + 1;

        modeloAsientosMensuales.limpiarTodo();
        modeloMovimientosAsiento.limpiarTodo();

        List<AsientoContableRecord> asientos = getConsulta().selectFrom(ASIENTO_CONTABLE).where(ASIENTO_CONTABLE.libroDiario().FECHA_INICIO_MES_LIBRO_DIARIO.eq(LocalDate.of(anio, mes, 1))).fetch();
        modeloAsientosMensuales.setNuevaLista(asientos);
        modeloAsientosMensuales.fireTableDataChanged();
        vista.cbMesPeriodoContable.setActionCommand("");
        vista.cbAnioPeriodoContable.setActionCommand("");
    }

    public void armarAccionar() {

        vista.cbAnioPeriodoContable.addActionListener(a -> {
            if (vista.cbAnioPeriodoContable.getSelectedIndex() != -1) {
                modeloAsientosMensuales.limpiarTodo();
                actualizarAsientos();
                int anio = Integer.parseInt((String) requireNonNull(vista.cbAnioPeriodoContable.getSelectedItem()));
                String estado = (String) requireNonNull(getConsulta().select(ESTADO_PERIODO_CONTABLE.NOMBRE_ESTADO_PERIODO_CONTABLE)
                        .from(PERIODO_CONTABLE)
                        .join(ESTADO_PERIODO_CONTABLE)
                        .on(PERIODO_CONTABLE.ID_ESTADO_DEL_PERIODO_CONTABLE.eq(ESTADO_PERIODO_CONTABLE.ID_ESTADO_DEL_PERIODO_CONTABLE))
                        .where(PERIODO_CONTABLE.FECHA_INICIO_PERIODO_CONTABLE.eq(LocalDate.of(anio, 1, 1))).fetchOne()).get(0);
                vista.txtSalidaEstadoPeriodoContable.setText(estado);

                if (Objects.equals(estado, "EN CURSO")) {
                    vista.btnVerEstadoDeResultado.setEnabled(false);
                    vista.btnVerBalanceGeneral.setEnabled(false);
                    vista.panelTabGlobal.setEnabledAt(1, false);
                    armarTabLibroDiario();
                } else {
                    vista.panelTabGlobal.setEnabledAt(1, true);
                    vista.btnCerrarPeriodoContable.setEnabled(false);
                    vista.btnVerEstadoDeResultado.setEnabled(true);
                    vista.btnVerBalanceGeneral.setEnabled(true);
                    vista.btnRegistrarNuenoAsiento.setEnabled(false);
                }

            }
        });

        vista.cbMesPeriodoContable.addActionListener(a -> {
            if (vista.cbMesPeriodoContable.getSelectedIndex() != -1) {
                actualizarAsientos();
            }
        });


        vista.tbAsientosDeDiario.getSelectionModel().addListSelectionListener(ls -> {
            if (vista.tbAsientosDeDiario.getSelectedRow() != -1) {
                int idAsiento = (int) modeloAsientosMensuales.getValueAt(vista.tbAsientosDeDiario.getSelectedRow(), 0);

                Result<Record4<String, String, Integer, BigDecimal>> movimiento = getConsulta().select(CUENTA.CODIGO_CUENTA,
                                CUENTA.NOMBRE_CUENTA,
                                MOVIMIENTOS_ASIENTO_CONTABLE.ID_TIPO_DE_MOVIMIENTO,
                                MOVIMIENTOS_ASIENTO_CONTABLE.MONTO_MOVIMIENTO_ASIENTO_CONTABLE).
                        from(MOVIMIENTOS_ASIENTO_CONTABLE
                                .join(CUENTA)
                                .on(MOVIMIENTOS_ASIENTO_CONTABLE.ID_CUENTA
                                        .eq(CUENTA.ID_CUENTA)))
                        .where(MOVIMIENTOS_ASIENTO_CONTABLE.ID_ASIENTO_CONTABLE
                                .eq(idAsiento))
                        .fetch();

                modeloMovimientosAsiento.limpiarTodo();
                for (Record4<String, String, Integer, BigDecimal> m : movimiento) {
                    MovimientoAsientoDiarioLocal mm = new MovimientoAsientoDiarioLocal();
                    mm.setId(null);
                    mm.setCodigoCuenta(m.value1());
                    mm.setNombreCuenta(m.value2());

                    mm.setEsMovimientoDebe(m.value3() == 1);
                    mm.setMonto(m.value4());
                    modeloMovimientosAsiento.agregarMovimiento(mm);
                }
                modeloMovimientosAsiento.fireTableDataChanged();
            }

        });

        vista.cbCuentaAMostrarLibroMayor.addActionListener(a -> {
            armarTabLibroDiario();
        });

        vista.menuItemCrearPeriodoContable.addActionListener(a ->{
            VistaRegistroEdicionAsientosDeDiario v = new VistaRegistroEdicionAsientosDeDiario(vista,true);
            v.setVisible(true);
        });
    }

    private void armarTabLibroDiario() {
        int idAsiento = (int) modeloAsientosMensuales.getValueAt(vista.tbAsientosDeDiario.getSelectedRow(), 0);
        modeloMovimientosCuentaLM.limpiarTodo();
        vista.cbCuentaAMostrarLibroMayor.removeAllItems();
        vista.txtTotalDebeLibroMayor.setText("");
        vista.txtTotalHaberLibroMayor.setText("");
        vista.txtSaltoTotalCuentaLibroMayor.setText("");

        int anio = Integer.parseInt(requireNonNull(vista.cbAnioPeriodoContable.getSelectedItem()).toString());
        LocalDate fechaLlenado = LocalDate.of(anio, 1, 1);


        Result<Record4<String, String, String, BigDecimal>> cuenta = getConsulta().select(
                        CUENTA.NOMBRE_CUENTA,
                        CUENTA.CODIGO_CUENTA,
                        TIPO_DE_MOVIMIENTO.NOMBRE_TIPO_DE_MOVIMIENTO,
                        MOVIMIENTOS_ASIENTO_CONTABLE.MONTO_MOVIMIENTO_ASIENTO_CONTABLE)
                .from(MOVIMIENTOS_ASIENTO_CONTABLE)
                .join(CUENTA).on(CUENTA.ID_CUENTA.eq(MOVIMIENTOS_ASIENTO_CONTABLE.ID_CUENTA))
                .join(TIPO_DE_MOVIMIENTO).on(TIPO_DE_MOVIMIENTO.ID_TIPO_DE_MOVIMIENTO.eq(MOVIMIENTOS_ASIENTO_CONTABLE.ID_TIPO_DE_MOVIMIENTO))
                .where(MOVIMIENTOS_ASIENTO_CONTABLE.ID_ASIENTO_CONTABLE.eq(1))
                .and(TIPO_DE_MOVIMIENTO.ID_TIPO_DE_MOVIMIENTO.eq(1))
                .and(MOVIMIENTOS_ASIENTO_CONTABLE.ID_CUENTA.eq(1)).fetch();


    }

    public void init() {
        vista.setTitle("SISTEMA CONTABLE - WINEXPAND");
        vista.txtTituloApp.setText("SISTEMA CONTABLE - WINEXPAND");

        modeloAsientosMensuales = new TableModelAsientosMes();
        modeloMovimientosAsiento = new TableModelMovimientosAsiento();
        modeloMovimientosCuentaLM = new TableModelMovimientosCuenta();
        vista.tbAsientosDeDiario.setModel(modeloAsientosMensuales);
        vista.tbMovimientosDeAsientosDeDiario.setModel(modeloMovimientosAsiento);
        vista.tbMovimientosCuentaEspecificaLibroMayor.setModel(modeloMovimientosCuentaLM);


        if (getConsulta().fetchCount(PERIODO_CONTABLE) == 0) {
            Thread t = new Thread(() -> JOptionPane.showMessageDialog(vista, "No se encontraron periodos contables.\nCree uno nuevo para empezar a usar el programa:\nAcciones -> Crear periodo contable", "NO HAY PERIODOS CONTABLES", WARNING_MESSAGE));
            t.start();
        } else {
            String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
            for (String mes : meses) {
                vista.cbMesPeriodoContable.addItem(mes);
            }

            vista.cbAnioPeriodoContable.setEnabled(true);
            vista.cbMesPeriodoContable.setEnabled(true);
            vista.panelTabGlobal.setEnabled(true);
            vista.panelTabGlobal.setEnabledAt(0, true);
            vista.panelTabGlobal.setEnabledAt(1, false);

            List<PeriodoContableRecord> periodosContables = getConsulta().selectFrom(PERIODO_CONTABLE).orderBy(PERIODO_CONTABLE.FECHA_INICIO_PERIODO_CONTABLE.desc()).fetch();
            PeriodoContableRecord periodoUltimoAnio = periodosContables.get(0);
            for (PeriodoContableRecord periodo : periodosContables) {
                vista.cbAnioPeriodoContable.addItem(String.valueOf(periodo.getFechaInicioPeriodoContable().getYear()));
            }
            EstadoPeriodoContableRecord estado = getConsulta().selectFrom(ESTADO_PERIODO_CONTABLE)
                    .where(ESTADO_PERIODO_CONTABLE.ID_ESTADO_DEL_PERIODO_CONTABLE
                            .eq(periodoUltimoAnio.getIdEstadoDelPeriodoContable()))
                    .fetchAny();

            String nombreEstado = requireNonNull(estado).getNombreEstadoPeriodoContable();
            vista.txtSalidaEstadoPeriodoContable.setText(nombreEstado);
            if (nombreEstado.equals("EN CURSO")) {
                vista.btnCerrarPeriodoContable.setEnabled(true);
                vista.btnRegistrarNuenoAsiento.setEnabled(true);
            } else {
                vista.btnVerBalanceGeneral.setEnabled(true);
                vista.btnVerEstadoDeResultado.setEnabled(true);
            }

            int anio = periodoUltimoAnio.getFechaInicioPeriodoContable().getYear();
            int mes = LocalDate.now().getMonthValue();

            vista.cbMesPeriodoContable.setSelectedIndex(mes - 1);

            List<AsientoContableRecord> asientos = getConsulta().selectFrom(ASIENTO_CONTABLE).where(ASIENTO_CONTABLE.libroDiario().FECHA_INICIO_MES_LIBRO_DIARIO.eq(LocalDate.of(anio, mes, 1))).fetch();
            modeloAsientosMensuales.setNuevaLista(asientos);
            modeloAsientosMensuales.fireTableDataChanged();
        }
    }
}
