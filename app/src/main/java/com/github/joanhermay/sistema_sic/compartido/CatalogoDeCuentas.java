/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.github.joanhermay.sistema_sic.compartido;

import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.ClasificacionGeneralRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.CuentaRecord;
import com.github.joanhermay.sistema_sic.tablas_bd.tables.records.RubroDeAgrupacionRecord;

import java.util.ArrayList;
import java.util.List;

import static com.github.joanhermay.sistema_sic.compartido.Conexiones.getConsulta;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.ClasificacionGeneral.CLASIFICACION_GENERAL;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.Cuenta.CUENTA;
import static com.github.joanhermay.sistema_sic.tablas_bd.tables.RubroDeAgrupacion.RUBRO_DE_AGRUPACION;

/**
 * @author joanhermay
 */
public class CatalogoDeCuentas {
    private CatalogoDeCuentas() {
    }

    public static List<String> getCuentasSegunRubro(String nombreRubro) {
        List<String> c = new ArrayList<>();
        List<CuentaRecord> records = getConsulta().selectFrom(CUENTA).where(CUENTA.rubroDeAgrupacion().NOMBRE_RUBRO_DE_AGRUPACION.eq(nombreRubro)).fetch();
        for (CuentaRecord cr : records) {
            c.add(cr.getNombreCuenta());
        }
        return c;
    }

    public static List<String> getRubrosSegunClasificacion(String nombreClasi) {
        List<String> r = new ArrayList<>();
        List<RubroDeAgrupacionRecord> records = getConsulta().selectFrom(RUBRO_DE_AGRUPACION).where(RUBRO_DE_AGRUPACION.clasificacionGeneral().NOMBRE_CLASIFICACION_GENERAL.eq(nombreClasi)).fetch();
        for (RubroDeAgrupacionRecord rubro : records) {
            r.add(rubro.getNombreRubroDeAgrupacion());
        }
        return r;
    }

    public static List<String> getClasificacionesGenerales() {
        List<String> cla = new ArrayList<>();
        List<ClasificacionGeneralRecord> records = getConsulta().selectFrom(CLASIFICACION_GENERAL).orderBy(CLASIFICACION_GENERAL.NOMBRE_CLASIFICACION_GENERAL).fetch();
        for (ClasificacionGeneralRecord clar : records) {
            cla.add(clar.getNombreClasificacionGeneral());
        }
        return cla;
    }
}
