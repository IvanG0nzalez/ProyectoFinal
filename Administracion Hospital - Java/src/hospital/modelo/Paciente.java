/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital.modelo;

/**
 *
 * @author Grupo Administracion Hospital
 */
public class Paciente extends Persona {

    private static Integer edad;
    private static Float peso;
    private static Float estatura;
    private static String fechaIngreso;
    private static String pacienteFecha;
    private static String genero;
    private static String motivo;
    private static Integer hospitalPaciente;

    private Medico medico;
    private Enfermero enfermero;
    private Hospital hospital;
    

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String cedula, Integer edad, Float peso, Float estatura, String fechaIngreso, String genero, String motivo) {
        super(nombre, apellido, cedula);
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.fechaIngreso = fechaIngreso;
        this.genero = genero;
        this.motivo = motivo;
    }

    public Paciente(String nombre, String apellido, String cedula, Integer edad, Float peso, Float estatura, String fechaIngreso, String genero, String motivo, Hospital hospital) {
        super(nombre, apellido, cedula);
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.fechaIngreso = fechaIngreso;
        this.genero = genero;
        this.motivo = motivo;
        this.hospital = hospital;
    }
    

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getEstatura() {
        return estatura;
    }

    public void setEstatura(Float estatura) {
        this.estatura = estatura;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Enfermero getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

        public void setFechaIngreso(String fechaIngreso) {
        this.getFechaIngreso();
    }

    public String getPacienteFecha() {
        return pacienteFecha;
    }

    public void setPacienteFecha(String pacienteFecha) {
        this.pacienteFecha = pacienteFecha;
    }
    
        public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getHospitalPaciente() {
        return hospitalPaciente;
    }

    public void setHospitalPaciente(Integer hospitalPaciente) {
        this.hospitalPaciente = hospitalPaciente;
    }


    @Override
    public String toString() {
        return "Paciente{" + "nombre:" + super.getNombre() + ", apellido: "
                + super.getApellido() + ", cedula: " + super.getCedula() + ", edad="
                + edad + ", peso=" + peso + ", estatura=" + estatura + ", fechaNacimiento: " + fechaIngreso + ", genero:" + genero + ", motivo: " + motivo + '}';
    }

}
