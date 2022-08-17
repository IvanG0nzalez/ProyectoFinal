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
public class Enfermero extends Persona{
    
    private static Float sueldo;
    private static String tipContrato;
    private static String asignacion;
    private static Integer hospitalEnfermero;

    private List<Paciente> pacienteList;
    private Hospital hospital;

    public Enfermero() {
        pacienteList = new LinkedList<>();
    }

    public Enfermero(String nombre, String apellido, String tipContrato) {
        super(nombre, apellido);
        Enfermero.tipContrato = tipContrato;
        pacienteList = new LinkedList<>();
    }

    public Enfermero(String nombre, String apellido, String cedula, String tipContrato) {
        super(nombre, apellido, cedula);
        Enfermero.tipContrato = tipContrato;
        pacienteList = new LinkedList<>();
    }

    public Enfermero(String nombre, String apellido, String cedula, String tipContrato, Hospital hospital) {
        super(nombre, apellido, cedula);
        Enfermero.tipContrato = tipContrato;
        this.hospital = hospital;
        pacienteList = new LinkedList<>();
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        Enfermero.sueldo = sueldo;
    }

    public String getTipContrato() {
        return tipContrato;
    }

    public void setTipContrato(String tipContrato) {
        Enfermero.tipContrato = tipContrato;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }

    public int getHospitalEnfermero() {
        return hospitalEnfermero;
    }

    public void setHospitalEnfermero(int hospitalEnfermero) {
        this.hospitalEnfermero = hospitalEnfermero;
    }
    

    @Override
    public String toString() {
        return "Enfermero{" + "nombre: " + super.getNombre() + ", apellido: " + super.getApellido() + ", cedula: " + super.getCedula() + ", contrato=" + tipContrato + ", sueldo: "+ sueldo + '}';
    }
    
    
    
    
}
