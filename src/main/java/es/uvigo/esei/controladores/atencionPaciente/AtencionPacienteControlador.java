/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.controladores.atencionPaciente;

import es.uvigo.esei.dagss.controladores.autenticacion.AutenticacionControlador;
import es.uvigo.esei.dagss.dominio.daos.CitaDAO;
import es.uvigo.esei.dagss.dominio.daos.MedicamentoDAO;
import es.uvigo.esei.dagss.dominio.daos.PacienteDAO;
import es.uvigo.esei.dagss.dominio.daos.PrescripcionDAO;
import es.uvigo.esei.dagss.dominio.daos.RecetaDAO;
import es.uvigo.esei.dagss.dominio.entidades.Cita;
import es.uvigo.esei.dagss.dominio.entidades.EstadoCita;
import es.uvigo.esei.dagss.dominio.entidades.EstadoReceta;
import es.uvigo.esei.dagss.dominio.entidades.Farmacia;
import es.uvigo.esei.dagss.dominio.entidades.Medicamento;
import es.uvigo.esei.dagss.dominio.entidades.Medico;
import es.uvigo.esei.dagss.dominio.entidades.Paciente;
import es.uvigo.esei.dagss.dominio.entidades.Prescripcion;
import es.uvigo.esei.dagss.dominio.entidades.Receta;
import es.uvigo.esei.dagss.dominio.entidades.SituacionReceta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ivan
 */
@Named(value = "atencionPacienteControlador")
@SessionScoped
public class AtencionPacienteControlador implements Serializable {

    private String numeroTarjetaSanitaria;
    private List<Receta> recetas;
    private List<Cita> citas;
    private List<Prescripcion> prescripciones;
    private Paciente paciente;
    private List<EstadoCita> estadosCitas;

    private Cita citaActual;
    private EstadoCita estadoCita;

    @Inject
    private AutenticacionControlador autenticacionControlador;

    @EJB
    private RecetaDAO recetaDAO;

    @EJB
    private CitaDAO citaDAO;

    @EJB
    private PrescripcionDAO prescripcionDAO;

    @EJB
    private PacienteDAO pacienteDAO;

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public String getNumeroTarjetaSanitaria() {
        return numeroTarjetaSanitaria;
    }

    public void setNumeroTarjetaSanitaria(String numeroTarjetaSanitaria) {
        this.numeroTarjetaSanitaria = numeroTarjetaSanitaria;
        setPaciente(pacienteDAO.buscarPorTarjetaSanitaria(numeroTarjetaSanitaria));
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Prescripcion> getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(List<Prescripcion> prescripciones) {
        this.prescripciones = prescripciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cita getCitaActual() {
        return citaActual;
    }

    public void setCitaActual(Cita citaActual) {
        this.citaActual = citaActual;
    }

    //Busca las recetas en vigor del cliente seleccionado
    public void doBuscarRecetasEnVigor() {
        recetas = recetaDAO.buscarRecetasEnVigor(numeroTarjetaSanitaria);
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    public List<Prescripcion> getPrescripciones(Paciente paciente) {
        return prescripcionDAO.getPrescripciones(paciente);
    }

    //Metodo que sirve la receta seleccionada
    public String doServirReceta(Receta r, Farmacia f) {

        if (r.getEstadoReceta().equals(EstadoReceta.GENERADA)) {
            r.setFarmaciaDispensadora(f);
            r.setEstadoReceta(EstadoReceta.SERVIDA);
            recetaDAO.actualizar(r);
            doBuscarRecetasEnVigor();
        }
        return "index";
    }

    //Médicos
    //Método para devolver citas hoy de medico
    public List<Cita> getCitasMedicoHoy(Medico medico) {
        return citaDAO.getCitasMedicoHoy(medico);
    }

    public String atenderCitaMedico(Cita cita) {
        this.citaActual = cita;
        if (cita.getEstado().equals(EstadoCita.PLANIFICADA)){
            return "formularioAtencion";
        } else {
            return "index";
        }
    }

    public List<EstadoCita> getEstadosCitas() {
        estadosCitas = EstadoCita.getEstadosToChange();
        return estadosCitas;
    }

    public String doCambiarEstado() {
        citaActual.setEstado(estadoCita);
        citaDAO.actualizar(citaActual);
        return "index";
    }
}
