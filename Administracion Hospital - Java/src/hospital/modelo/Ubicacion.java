/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital.modelo;

/**
 *
 * @author Grupo Administracion Hospital
 */
public class Ubicacion {
    
    private static String ciudad;
    private static String ciudadHospital;
    private static String provincia;
    private static String provinciaHospital;
    private static String callePrincipal;
    private static String callePrincipalHospital;
    
    private Hospital hospital;

    public Ubicacion() {
    }

    public Ubicacion(String ciudad, String provincia, String callePrincipal) {
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.callePrincipal = callePrincipal;
    }

    public Ubicacion(String ciudad, String provincia, String callePrincipal, Hospital hospital) {
        this(ciudad, provincia, callePrincipal);
        this.hospital = hospital;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudadHospital() {
        return ciudadHospital;
    }

    public void setCiudadHospital(String ciudadHospital) {
        this.ciudadHospital = ciudadHospital;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvinciaHospital() {
        return provinciaHospital;
    }

    public void setProvinciaHospital(String provinciaHospital) {
        this.provinciaHospital = provinciaHospital;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCallePrincipalHospital() {
        return callePrincipalHospital;
    }

    public void setCallePrincipalHospital(String callePrincipalHospital) {
        this.callePrincipalHospital = callePrincipalHospital;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
   
    

    @Override
    public String toString() {
        return  "Provincia: " + provincia + "\tCiudad: " + ciudad + "\tCalle Principal: " + callePrincipal + "\n";
    }
    
}
