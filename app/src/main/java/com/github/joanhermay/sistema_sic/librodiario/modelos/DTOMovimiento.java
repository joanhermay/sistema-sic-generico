/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.librodiario.modelos;

import java.math.BigDecimal;

/**
 *
 * @author joanhermay
 */
public class DTOMovimiento {
    private int id;
    private int idAsiento;
    private String concepto;
    private BigDecimal monto;

    public DTOMovimiento(int id, int idAsiento, String concepto, BigDecimal monto) {
        this.id = id;
        this.idAsiento = idAsiento;
        this.concepto = concepto;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    
}
