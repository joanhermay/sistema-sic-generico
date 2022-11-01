package com.github.joanhermay.sistema_sic.librodiario;

import java.util.List;

import static com.github.joanhermay.sistema_sic.compartido.CatalogoDeCuentas.*;
import com.github.joanhermay.sistema_sic.compartido.Conexiones;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.ClasificacionGeneral;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.Cuenta;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.MovimientosAsientoContable;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.RubroDeAgrupacion;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.TipoDeMovimiento;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.MovimientosAsientoContableRecord;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import org.jooq.Record1;

public class ControladorRegistroEdicionMovimientoEspecifico {

    private VistaRegistroEdicionMovimientoEspecifico vista;
    private LocalDate fecha;
    private Integer idAsientoContable;

    public ControladorRegistroEdicionMovimientoEspecifico(VistaRegistroEdicionMovimientoEspecifico vista, Integer idAsientoContable) {
        this.vista = vista;
        this.idAsientoContable = idAsientoContable;
        init();
        armarAccionar();
    }

    private void init() {
        List<String> clasificaciones = getClasificacionesGenerales();
        if (clasificaciones.isEmpty()) {
            vista.cbCategoriaGeneral.setEnabled(false);
            vista.cbRubroDeAgrupacion.setEnabled(false);
            vista.cbCuentaNombreCodigo.setEnabled(false);
            return;
        }

        for (String cla : clasificaciones) {
            vista.cbCategoriaGeneral.addItem(cla);
        }
        vista.cbCategoriaGeneral.setSelectedIndex(0);

        String nombreClasi = (String) vista.cbCategoriaGeneral.getSelectedItem();
        List<String> rubros = getRubrosSegunClasificacion(nombreClasi);

        for (String rubro : rubros) {
            vista.cbRubroDeAgrupacion.addItem(rubro);
        }

        vista.cbRubroDeAgrupacion.setSelectedIndex(0);

        String nombreRubro = (String) vista.cbRubroDeAgrupacion.getSelectedItem();
        List<String> cuentas = getCuentasSegunRubro(nombreRubro);
        for (String cuenta : cuentas) {
            vista.cbCuentaNombreCodigo.addItem(cuenta);
        }
        vista.cbCuentaNombreCodigo.setSelectedIndex(0);
    }

    private void armarAccionar() {
        vista.cbCategoriaGeneral.addActionListener(a -> {
            if (a.getActionCommand().equals("en uso")) {
                return;
            }
            if (vista.cbCuentaNombreCodigo.getSelectedIndex() != -1) {
                actualizarRubrosSegunClasificacion();
            }
        });

        vista.cbRubroDeAgrupacion.addActionListener(a -> {
            if (a.getActionCommand().equals("en uso")) {
                return;
            }
            if (vista.cbRubroDeAgrupacion.getSelectedIndex() != -1) {
                actualizarCuentasRegunRubro();
            }
        });

        vista.btnAgregarAVistaPrevia.addActionListener(a -> {
            if (vista.txtMonto.getText().isBlank()) {
                JOptionPane.showMessageDialog(vista, "Agrege un monto");
                return;
            }
            if (!vista.radioBDebe.isSelected() && !vista.radioBHaber.isSelected()) {
                JOptionPane.showMessageDialog(vista, "Sleccione un tipo de movimiento");
                return;
            }
            MovimientosAsientoContableRecord m = Conexiones.getConsulta().newRecord(MovimientosAsientoContable.MOVIMIENTOS_ASIENTO_CONTABLE);
            m.setIdAsientoContable(idAsientoContable);

            Record1<Integer> idCuenta = Conexiones.getConsulta()
                    .select(Cuenta.CUENTA.ID_CUENTA)
                    .from(Cuenta.CUENTA)
                    .join(RubroDeAgrupacion.RUBRO_DE_AGRUPACION)
                    .on(Cuenta.CUENTA.ID_RUBRO_DE_AGRUPACION.eq(RubroDeAgrupacion.RUBRO_DE_AGRUPACION.ID_RUBRO_DE_AGRUPACION))
                    .join(ClasificacionGeneral.CLASIFICACION_GENERAL)
                    .on(RubroDeAgrupacion.RUBRO_DE_AGRUPACION.ID_CLASIFICACION_GENERAL.eq(ClasificacionGeneral.CLASIFICACION_GENERAL.ID_CLASIFICACION_GENERAL))
                    .where(Cuenta.CUENTA.NOMBRE_CUENTA.eq((String) vista.cbCuentaNombreCodigo.getSelectedItem())).fetchAny();
            m.setIdCuenta(idCuenta.value1());

            String seleccion = vista.radioBDebe.isSelected() ? "Debe" : "Haber";

            Record1<Integer> idTipoMov = Conexiones.getConsulta().select(TipoDeMovimiento.TIPO_DE_MOVIMIENTO.ID_TIPO_DE_MOVIMIENTO)
                    .from(TipoDeMovimiento.TIPO_DE_MOVIMIENTO)
                    .where(TipoDeMovimiento.TIPO_DE_MOVIMIENTO.NOMBRE_TIPO_DE_MOVIMIENTO.eq(seleccion)).fetchAny();
            m.setIdTipoDeMovimiento(idTipoMov.value1());

            m.setMontoMovimientoAsientoContable(new BigDecimal(vista.textMonto.getText()));
            m.store();
            vista.dispose();

        });
    }

    private void actualizarRubrosSegunClasificacion() {
        vista.cbRubroDeAgrupacion.removeAllItems();
        vista.cbCuentaNombreCodigo.removeAllItems();

        vista.cbRubroDeAgrupacion.setActionCommand("en uso");
        vista.cbCuentaNombreCodigo.setActionCommand("en uso");

        String nombreClasi = (String) vista.cbCategoriaGeneral.getSelectedItem();
        List<String> rubros = getRubrosSegunClasificacion(nombreClasi);

        for (String rubro : rubros) {
            vista.cbRubroDeAgrupacion.addItem(rubro);
        }

        vista.cbRubroDeAgrupacion.setSelectedIndex(0);

        String nombreRubro = (String) vista.cbRubroDeAgrupacion.getSelectedItem();
        List<String> cuentas = getCuentasSegunRubro(nombreRubro);
        for (String cuenta : cuentas) {
            vista.cbCuentaNombreCodigo.addItem(cuenta);
        }
        vista.cbCuentaNombreCodigo.setSelectedIndex(0);
        vista.cbRubroDeAgrupacion.setActionCommand("");
        vista.cbCuentaNombreCodigo.setActionCommand("");
    }

    private void actualizarCuentasRegunRubro() {
        vista.cbCuentaNombreCodigo.removeAllItems();
        vista.cbRubroDeAgrupacion.setActionCommand("en uso");
        vista.cbCuentaNombreCodigo.setActionCommand("en uso");

        String nombreRubro = (String) vista.cbRubroDeAgrupacion.getSelectedItem();
        List<String> cuentas = getCuentasSegunRubro(nombreRubro);
        for (String cuenta : cuentas) {
            vista.cbCuentaNombreCodigo.addItem(cuenta);
        }
        vista.cbCuentaNombreCodigo.setSelectedIndex(0);
        vista.cbRubroDeAgrupacion.setActionCommand("en uso");
        vista.cbCuentaNombreCodigo.setActionCommand("en uso");
    }

    public void mostrar() {

        vista.setVisible(true);
    }
}
