/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.dominio.entidades;

/**
 *
 * @author ivan
 */

public enum SituacionReceta {

    DISPONIBLE ("disponible para suministro"), 
    NO_DISPONIBLE  ("no disponible");

    private final String etiqueta;

    private SituacionReceta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}