package com.github.joanhermay.sistema_sic;

import java.math.BigDecimal;

public class JoanHermayMovimientosMesAsiento {
    private Integer id;
    private String codigoCuenta;
    private String nombreCuenta;
    private boolean esMovimientoDebe;
    private BigDecimal monto;

    public JoanHermayMovimientosMesAsiento(Integer id, String codigoCuenta, String nombreCuenta, boolean esMovimientoDebe, BigDecimal monto) {
        this.id = id;
        this.codigoCuenta = codigoCuenta;
        this.nombreCuenta = nombreCuenta;
        this.esMovimientoDebe = esMovimientoDebe;
        this.monto = monto;
    }

    public JoanHermayMovimientosMesAsiento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public boolean isEsMovimientoDebe() {
        return esMovimientoDebe;
    }

    public void setEsMovimientoDebe(boolean esMovimientoDebe) {
        this.esMovimientoDebe = esMovimientoDebe;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
