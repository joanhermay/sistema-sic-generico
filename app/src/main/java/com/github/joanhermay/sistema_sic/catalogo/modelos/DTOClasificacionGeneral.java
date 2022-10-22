/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.catalogo.modelos;

/**
 *
 * @author joanhermay
 */
public class DTOClasificacionGeneral {
    private int id;
    private String codigo;
    private String nombre;
    private String idCatalogoPerteneciente;

    public DTOClasificacionGeneral(int id, String codigo, String nombre, String idCatalogoPerteneciente) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.idCatalogoPerteneciente = idCatalogoPerteneciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIdCatalogoPerteneciente() {
        return idCatalogoPerteneciente;
    }

    public void setIdCatalogoPerteneciente(String idCatalogoPerteneciente) {
        this.idCatalogoPerteneciente = idCatalogoPerteneciente;
    }
    
    
    
    

    
    
    
    
}
