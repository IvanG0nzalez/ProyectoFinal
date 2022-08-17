/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital.modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Grupo Administracion Hospital
 */
public class Hospital extends Ubicacion {

    private static String idHospital;
    private static String nombre;
    private static String nombreHospital;
    private static int numEspecialista;
    private static Float totalSueldo = 0f;

    

    private List<Ubicacion> ubicacionList;
    private List<Medico> medicoList;
    private List<Enfermero> enfermeroList;
    private List<Paciente> pacienteList;

    //Constructores
    public Hospital() {
        ubicacionList = new LinkedList<>();
        medicoList = new LinkedList<>();
        enfermeroList = new LinkedList<>();
        pacienteList = new LinkedList<>();
    }

    public Hospital(String nombre) {
        this();
        this.nombre = nombre;
    }

    //Métodos Accesores

    public String getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(String idHospital) {
        this.idHospital = idHospital;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumEspecialista() {
        return numEspecialista;
    }

    public void setNumEspecialista(int numEspecialidad) {
        this.numEspecialista = numEspecialidad;
    }

    public List<Ubicacion> getUbicacionList() {
        return ubicacionList;
    }

    public void setUbicacionList(List<Ubicacion> ubicacionList) {
        this.ubicacionList = ubicacionList;
    }

    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    public List<Enfermero> getEnfermeroList() {
        return enfermeroList;
    }

    public void setEnfermeroList(List<Enfermero> enfermeroList) {
        this.enfermeroList = enfermeroList;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public Float getTotalSueldo() {
        return totalSueldo;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }


    @Override
    public String toString() {
        return "Hospital:\t" + nombre + "\nUbicaciones: " + ubicacionList + "\n" + this.getMedicoList() + "\nEnfermeros: " + enfermeroList + "\nLista de Pacientes: " + pacienteList + '}';
    }

}
