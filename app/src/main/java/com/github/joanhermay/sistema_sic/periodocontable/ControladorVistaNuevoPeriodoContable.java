package com.github.joanhermay.sistema_sic.periodocontable;

public class ControladorVistaNuevoPeriodoContable {
    VistaNuevoPeriodoContable vista;

    public ControladorVistaNuevoPeriodoContable(VistaNuevoPeriodoContable vista) {
        this.vista = vista;
        init();
    }

    public void init() {
        vista.checkOtroAnio.addActionListener(a -> {
            if(vista.checkOtroAnio.isSelected()) {

            }
        });
    }
}
