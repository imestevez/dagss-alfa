/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.dagss.controlador.prescripcion;

import es.uvigo.esei.controladores.atencionPaciente.AtencionPacienteControlador;
import es.uvigo.esei.dagss.dominio.daos.MedicamentoDAO;
import es.uvigo.esei.dagss.dominio.daos.PrescripcionDAO;
import es.uvigo.esei.dagss.dominio.entidades.Medicamento;
import es.uvigo.esei.dagss.dominio.entidades.Medico;
import es.uvigo.esei.dagss.dominio.entidades.Paciente;
import es.uvigo.esei.dagss.dominio.entidades.Prescripcion;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author menoc
 */
@Named(value = "prescripcionControlador")
@SessionScoped
public class PrescripcionControlador implements Serializable {

    private Prescripcion prescripcionActual;

    public Prescripcion getPrescripcionActual() {
        return prescripcionActual;
    }

    public void setPrescripcionActual(Prescripcion prescripcionActual) {
        this.prescripcionActual = prescripcionActual;
    }

    private Integer dosis;
    private Date fechaInicio;
    private Date fechaFin;
    private Medicamento medicamento;
    private List<Medicamento> medicamentos;

    private String nombre_med;
    private String familia_med;
    private String fabricante_med;
    
    private Medico medico;
    private Paciente paciente;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Medicamento> getMedicamentos() {
        doBuscarMedicamentos();
        return medicamentos;
    }

    public String getNombre_med() {
        return nombre_med;
    }

    public void setNombre_med(String nombre_med) {
        this.nombre_med = nombre_med;
    }

    public String getFamilia_med() {
        return familia_med;
    }

    public void setFamilia_med(String familia_med) {
        this.familia_med = familia_med;
    }

    public String getFabricante_med() {
        return fabricante_med;
    }

    public void setFabricante_med(String fabricante_med) {
        this.fabricante_med = fabricante_med;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
    public Date getFechaInicio(){
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fecha_actual){
        this.fechaInicio = fecha_actual;
    }

    private List<Medicamento> medicamentosBusqueda;

    @EJB
    private MedicamentoDAO medicamentoDAO;
    @EJB
    private PrescripcionDAO prescripcionDAO;

    @Inject
    AtencionPacienteControlador atencionPaciente;

    //Formulario de prescripcion desde formulario de atencion
    public String getFormularioPrescripcion() {
        this.prescripcionActual = new Prescripcion();
        return "formularioPrescripcion";
    }

    public List<Medicamento> medicamentoBusPrescripcion(String query) {
        this.medicamentosBusqueda = medicamentoDAO.buscarMedicamentos(query);
        return this.medicamentosBusqueda;
    }

    public String eliminar(Prescripcion prescripcion) {
        this.prescripcionDAO.eliminar(prescripcion);
        return "formularioAtencion";
    }

    public void doBuscarMedicamentos() {
        medicamentos = medicamentoDAO.buscarPorMedicamento(nombre_med, familia_med, fabricante_med);
    }

    public String doElegirMedicamento() {
        if (medicamento != null) {
            nombre_med = medicamento.getNombre();
            familia_med = medicamento.getFamilia();
            fabricante_med = medicamento.getFabricante();
        }
        return "formularioPrescripcion";
    }

    public String crearPrescripcion(Paciente paciente, Medico medico) {
        prescripcionActual.setMedicamento(medicamento);
        prescripcionActual.setPaciente(paciente);
        prescripcionActual.setMedico(medico);
        
        Date fecha_actual = Calendar.getInstance().getTime();
        prescripcionActual.setFechaInicio(fecha_actual);
        
        prescripcionDAO.crear(this.prescripcionActual);
        return "formularioAtencion";
    }
}
