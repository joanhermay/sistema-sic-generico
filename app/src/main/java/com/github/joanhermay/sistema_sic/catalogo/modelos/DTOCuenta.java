/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.catalogo.modelos;

/**
 *
 * @author joanhermay
 */
public class DTOCuenta {
    private int id;
    private int idCatalogoAlQuePertenece;
    private int idClasificacionGeneral;
    private int idRubroDeAgrupacion;
    private String codigo;
    private String nombre;
    private int idTipoDeCuenta;
    private int idNaturalezaDeLaCueenta;
            
    

    public DTOCuenta(int id, String codigo, String nombre, int idCatalogoAlQuePertenece, int idClasificacionGeneral, int idRubroDeAgrupacion) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.idCatalogoAlQuePertenece = idCatalogoAlQuePertenece;
        this.idClasificacionGeneral = idClasificacionGeneral;
        this.idRubroDeAgrupacion = idRubroDeAgrupacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCatalogoAlQuePertenece() {
        return idCatalogoAlQuePertenece;
    }

    public void setIdCatalogoAlQuePertenece(int idCatalogoAlQuePertenece) {
        this.idCatalogoAlQuePertenece = idCatalogoAlQuePertenece;
    }

    public int getIdClasificacionGeneral() {
        return idClasificacionGeneral;
    }

    public void setIdClasificacionGeneral(int idClasificacionGeneral) {
        this.idClasificacionGeneral = idClasificacionGeneral;
    }

    public int getIdRubroDeAgrupacion() {
        return idRubroDeAgrupacion;
    }

    public void setIdRubroDeAgrupacion(int idRubroDeAgrupacion) {
        this.idRubroDeAgrupacion = idRubroDeAgrupacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipoDeCuenta() {
        return idTipoDeCuenta;
    }

    public void setIdTipoDeCuenta(int idTipoDeCuenta) {
        this.idTipoDeCuenta = idTipoDeCuenta;
    }

    public int getIdNaturalezaDeLaCueenta() {
        return idNaturalezaDeLaCueenta;
    }

    public void setIdNaturalezaDeLaCueenta(int idNaturalezaDeLaCueenta) {
        this.idNaturalezaDeLaCueenta = idNaturalezaDeLaCueenta;
    }
    
    
    
    
}
