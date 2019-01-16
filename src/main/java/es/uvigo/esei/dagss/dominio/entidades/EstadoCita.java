/*
 Práctica Java EE 7, DAGSS 2015/16 (ESEI, U. de Vigo)
 */
package es.uvigo.esei.dagss.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

public enum EstadoCita {

    PLANIFICADA ("PLANIFICADA"), 
    ANULADA     ("ANULADA"), 
    COMPLETADA  ("COMPLETADA"), 
    AUSENTE     ("AUSENTE");

    private final String etiqueta;

    private EstadoCita(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
    public static List<EstadoCita> getEstadosToChange(){
        List<EstadoCita> estadosCitas = new ArrayList<>();
        estadosCitas.add(EstadoCita.AUSENTE);
        estadosCitas.add(EstadoCita.COMPLETADA);
        return estadosCitas;
    }
}
