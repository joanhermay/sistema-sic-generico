package com.github.joanhermay.sistema_sic;

import java.math.BigDecimal;

public class MovimientoCuentaLM {
    private BigDecimal montoDebe = new BigDecimal(0);
    private BigDecimal montoHaber = new BigDecimal(0);

    public MovimientoCuentaLM(BigDecimal montoDebe) {
        this.montoDebe = montoDebe;
    }

    public void setMontoDebe(BigDecimal montoDebe) {
        this.montoDebe = montoDebe;
    }

    public void setMontoHaber(BigDecimal montoHaber) {
        this.montoHaber = montoHaber;
    }

    public BigDecimal getMontoDebe() {
        return montoDebe;
    }

    public BigDecimal getMontoHaber() {
        return montoHaber;
    }
}
