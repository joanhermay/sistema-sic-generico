/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.github.joanhermay.sistema_sic.compartido;

import java.util.List;

/**
 *
 * @author joanhermay
 */
public interface DAO<O> {
    void insertar(O o);
    List<O> obtener();
    void actualizar(O o);
    void eliminar(O o);
}
