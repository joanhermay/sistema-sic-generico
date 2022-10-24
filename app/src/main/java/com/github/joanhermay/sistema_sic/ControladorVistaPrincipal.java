package com.github.joanhermay.sistema_sic;

import com.github.joanhermay.sistema_sic.catalogo.VistaCatalogoDeCuentas;
import com.github.joanhermay.sistema_sic.compartido.Conexion;
import com.github.joanhermay.sistema_sic.periodocontable.VistaNuevoPeriodoContable;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.Cuenta;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.MovimientosAsientoContable;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.AsientoContableRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.MovimientosAsientoContableRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.PeriodoContableRecord;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.github.joanhermay.sistema_sic.tablas_bd.tables.AsientoContable.ASIENTO_CONTABLE;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.Cuenta.CUENTA;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.MovimientosAsientoContable.MOVIMIENTOS_ASIENTO_CONTABLE;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.PeriodoContable.PERIODO_CONTABLE;

public class ControladorVistaPrincipal implements ActionListener {

    private TableModelAsientosDiarios modeloAsientosSegunMes;
    private TableModelMovimientosAsientoEspecifico modeloMovimientosAsientoEspecifico;

    private TableModelMovimientosCuentaMayorEspecifica modeloMovimentosCuentaMayorEspecifica;

    private VistaPrincipal vista;

    public ControladorVistaPrincipal(VistaPrincipal vista) {
        this.vista = vista;
        armarListeners();
        armarTablasOArboles();
        prepararVistaInicial();
    }

    public void prepararVistaInicial() {
        vista.cbAnioPeriodoContable.setActionCommand("automatico");
        vista.cbMesPeriodoContable.setActionCommand("automatico");
        try (Connection con = Conexion.obtenerConexion()) {
            DSLContext c = DSL.using(con, SQLDialect.MARIADB);

            List<PeriodoContableRecord> periodos = c.selectFrom(PERIODO_CONTABLE).fetch().sortDesc(PERIODO_CONTABLE.FECHA_INICIO_PERIODO_CONTABLE);
            if (periodos.size() > 0) {
                vista.cbAnioPeriodoContable.setEnabled(true);
                for (PeriodoContableRecord periodo : periodos) {
                    vista.cbAnioPeriodoContable.addItem(String.valueOf(periodo.getFechaInicioPeriodoContable().getYear()));
                }
                vista.cbMesPeriodoContable.setEnabled(true);
                String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                for (String mes : meses) {
                    vista.cbMesPeriodoContable.addItem(mes);
                }
                vista.cbMesPeriodoContable.setSelectedIndex(LocalDate.now().getMonthValue() - 1);

                String estado = periodos.get(0).getIdEstadoDelPeriodoContable() == 1 ? "EN CURSO" : "CERRADO";
                vista.txtSalidaEstadoPeriodoContable.setText(estado);
                if ("EN CURSO".equals(estado)) {
                    vista.btnRegistrarNuenoAsiento.setEnabled(true);
                    vista.btnCerrarPeriodoContable.setEnabled(true);
                }
                List<AsientoContableRecord> asientosDiariosMes = c.selectFrom(ASIENTO_CONTABLE).where(ASIENTO_CONTABLE.libroDiario().FECHA_INICIO_MES_LIBRO_DIARIO.eq(periodos.get(0).getFechaInicioPeriodoContable())).fetch();
                modeloAsientosSegunMes.setNuevaLista(asientosDiariosMes);
                modeloAsientosSegunMes.fireTableDataChanged();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            vista.cbAnioPeriodoContable.setActionCommand("manual");
            vista.cbMesPeriodoContable.setActionCommand("manual");
        }
    }

    private void actualizarMovimientosSegunAsientoDiario(int idAsiento) {
        vista.cbAnioPeriodoContable.setActionCommand("automatico");
        vista.cbMesPeriodoContable.setActionCommand("automatico");
        try (Connection con = Conexion.obtenerConexion()) {
            DSLContext c = DSL.using(con, SQLDialect.MARIADB);
            Result<Record4<String, String, Integer, BigDecimal>> movimiento = c.select(CUENTA.CODIGO_CUENTA,
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
            if(!movimiento.isEmpty()) {
                for(Record4<String,String,Integer,BigDecimal> mm : movimiento) {
                    JoanHermayMovimientosMesAsiento m = new JoanHermayMovimientosMesAsiento();
                    m.setId(null);
                    m.setCodigoCuenta(mm.value1());
                    m.setNombreCuenta(mm.value2());
                    m.setEsMovimientoDebe(mm.value3() == 1);
                    m.setMonto(mm.value4());
                    modeloMovimientosAsientoEspecifico.limpiarTodo();
                    modeloMovimientosAsientoEspecifico.agregarMovimiento(m);
                }
                modeloMovimientosAsientoEspecifico.fireTableDataChanged();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            vista.cbAnioPeriodoContable.setActionCommand("manual");
            vista.cbMesPeriodoContable.setActionCommand("manual");
        }

    }

    private void actualizarAsientosDiariosDeMesYAnio(int anio, int mes) {
        vista.cbAnioPeriodoContable.setActionCommand("automatico");
        vista.cbMesPeriodoContable.setActionCommand("automatico");
        try (Connection con = Conexion.obtenerConexion()) {
            DSLContext c = DSL.using(con, SQLDialect.MARIADB);

            List<AsientoContableRecord> asientosDiariosMes =
                    c.selectFrom(ASIENTO_CONTABLE)
                            .where(ASIENTO_CONTABLE
                                    .libroDiario()
                                    .FECHA_INICIO_MES_LIBRO_DIARIO
                                    .eq(LocalDate
                                            .of(anio, mes, 1)
                                    )
                            )
                            .fetch();
            modeloAsientosSegunMes.setNuevaLista(asientosDiariosMes);
            modeloAsientosSegunMes.fireTableDataChanged();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            vista.cbAnioPeriodoContable.setActionCommand("manual");
            vista.cbMesPeriodoContable.setActionCommand("manual");
        }
    }

    private void armarTablasOArboles() {
        modeloAsientosSegunMes = new TableModelAsientosDiarios();
        vista.tbAsientosDeDiario.setModel(modeloAsientosSegunMes);

        modeloMovimientosAsientoEspecifico = new TableModelMovimientosAsientoEspecifico();
        vista.tbMovimientosDeAsientosDeDiario.setModel(modeloMovimientosAsientoEspecifico);

        modeloMovimentosCuentaMayorEspecifica = new TableModelMovimientosCuentaMayorEspecifica();
        vista.tbMovimientosCuentaEspecificaLibroMayor.setModel(modeloMovimentosCuentaMayorEspecifica);
    }

    private void armarListeners() {
        // MENU
        vista.menuItemCrearPeriodoContable.addActionListener(this);
        vista.munuItemVerCatalogoDeCuenta.addActionListener(this);
        vista.munuItemCostoDeManoDeObra.addActionListener(this);


        // Botones periodo
        vista.btnCerrarPeriodoContable.addActionListener(this);
        // combobox

        vista.cbAnioPeriodoContable.addActionListener(this);
        vista.cbMesPeriodoContable.addActionListener(this);

        // Botones registro asiento
        vista.btnRegistrarNuenoAsiento.addActionListener(this);
        vista.btnEditarAsiento.addActionListener(this);
        vista.btnEliminarAsiento.addActionListener(this);

        vista.tbAsientosDeDiario.getSelectionModel().addListSelectionListener(c -> {
            if (vista.tbAsientosDeDiario.getSelectedRow() != -1) {
                vista.btnEditarAsiento.setEnabled(true);
                vista.btnEliminarAsiento.setEnabled(true);

                int idAsiento = (int) modeloAsientosSegunMes.getValueAt(vista.tbAsientosDeDiario.getSelectedRow(),0);
                actualizarMovimientosSegunAsientoDiario(idAsiento);
            } else {
                vista.btnEditarAsiento.setEnabled(false);
                vista.btnEliminarAsiento.setEnabled(false);
            }

        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.munuItemVerCatalogoDeCuenta) {
            mostrarCatalogoDeCuentas();
        } else if (e.getSource() == vista.menuItemCrearPeriodoContable) {
            crearPeriodoContable();
        } else if (e.getSource() == vista.btnRegistrarNuenoAsiento) {
            if (vista.tbAsientosDeDiario.getSelectedRow() != -1) {
                if (vista.cbAnioPeriodoContable.getSelectedItem() != null && vista.cbMesPeriodoContable.getSelectedItem() != null) {
                    int anio = Integer.parseInt((String) vista.cbAnioPeriodoContable.getSelectedItem());
                    int mes = vista.cbMesPeriodoContable.getSelectedIndex() + 1;
                }
            }
        } else if ((e.getSource() == vista.cbAnioPeriodoContable || e.getSource() == vista.cbMesPeriodoContable) && e.getActionCommand().equals("manual")) {
            int anio = Integer.parseInt((String) Objects.requireNonNull(vista.cbAnioPeriodoContable.getSelectedItem()));
            int mes = vista.cbMesPeriodoContable.getSelectedIndex() + 1;
            actualizarAsientosDiariosDeMesYAnio(anio, mes);
        }
    }

    private void crearPeriodoContable() {
        VistaNuevoPeriodoContable p = new VistaNuevoPeriodoContable(vista, true);
        p.setLocationRelativeTo(vista);
        p.setVisible(true);
    }

    private void mostrarCatalogoDeCuentas() {
        VistaCatalogoDeCuentas ca = new VistaCatalogoDeCuentas(vista, true);
        ca.setLocationRelativeTo(vista);
        ca.setVisible(true);
    }

    public void mostrar() {
        vista.setVisible(true);
    }

    public void cerrar() {
        vista.dispose();
    }
}
