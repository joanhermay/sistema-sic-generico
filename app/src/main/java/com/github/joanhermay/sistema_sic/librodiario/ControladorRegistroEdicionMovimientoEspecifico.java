package com.github.joanhermay.sistema_sic.librodiario;

import java.util.List;

import static com.github.joanhermay.sistema_sic.compartido.CatalogoDeCuentas.*;

public class ControladorRegistroEdicionMovimientoEspecifico {

    private VistaRegistroEdicionMovimientoEspecifico vista;
    private int anio;
    private int mes;

    public ControladorRegistroEdicionMovimientoEspecifico(VistaRegistroEdicionMovimientoEspecifico vista, int anio, int mes) {
        this.vista = vista;
        this.anio = anio;
        this.mes = mes;
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
