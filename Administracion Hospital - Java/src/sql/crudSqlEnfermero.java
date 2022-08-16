/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import hospital.modelo.Enfermero;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhandry
 */
public class crudSqlEnfermero extends conexionsql{
    
    java.sql.Statement st;
    ResultSet rs;
    Enfermero enfermero = new Enfermero();
    
    public void insertar(String cedula, String nombre, String apellido, String contrato, float sueldo){
        try {
            Connection conexion = conectar();
            st=conexion.createStatement();
            String sql = "insert into enfermero(cedula,nombre,apellido, contrato, sueldo) values('"+cedula+"','"+nombre+"','"+apellido+"','"+contrato+"','"+sueldo+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se añadio un nuevo enfermero", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir un nuevo enfermero"+e, "Imperium", JOptionPane.ERROR_MESSAGE);
        }
 
    }
    
    public void asignarPaciente(String asignacion, String cedula){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql =" update enfermero set paciente ='"+asignacion+"' where cedula='"+cedula+"';";
            st.execute(sql);
            st.close(); 
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se asigno el paciente correctamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al asignar paciente" + e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void asignarHospital(Integer hospital, String cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = " update enfermero set hospital ='" + hospital + "' where cedula='" +cedula+ "';";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se asigno el hospital correctamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al asignar hospital" + e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void mostrar(JTextField cedula){
        try {
            Connection conexion = conectar();
            st=conexion.createStatement();
            String sql = "select * from enfermero where cedula='"+cedula.getText()+"';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                enfermero.setCedula(rs.getString("cedula"));
                enfermero.setNombre(rs.getString("nombre"));
                enfermero.setApellido(rs.getString("apellido"));
                enfermero.setTipContrato(rs.getString("contrato"));
                enfermero.setSueldo(rs.getFloat("sueldo"));
            } else{
                enfermero.setCedula("");
                enfermero.setNombre("");
                enfermero.setApellido("");
                enfermero.setTipContrato("");
                enfermero.setSueldo(0f);
                JOptionPane.showMessageDialog(null, "No se encontro Enfermero", "Imperium", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al buscar"+e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void SeleccionarEnfermero(JTable tblEnfermero, JTextField txtCedula){

        try {
            int fila=tblEnfermero.getSelectedRow();
            if (fila>=0) {
                txtCedula.setText(tblEnfermero.getValueAt(fila, 0).toString());
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
        
    }
    
    public void mostrarTabla(JTable panEnfermero){
        Connection conexion=conectar();
        DefaultTableModel modelo=new DefaultTableModel();
        String sql="";
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("contrato");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Paciente");
        modelo.addColumn("Hospital");
        
        panEnfermero.setModel(modelo);
        sql="select * from enfermero;";
        String [] datos=new String[7];
        java.sql.Statement st;
        try {
            st=conectar().createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                
                modelo.addRow(datos);
            }
        st.close();
        conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }

    }
    
    public void actualizar(String nombre, String apellido, String contrato, float sueldo, String cedula){
        try {
            Connection conexion=conectar();
            st=conexion.createStatement();
            String sql="update enfermero set nombre='"+nombre+"', apellido='"+apellido+"',contrato='"+contrato+"',sueldo='"+sueldo+"' where cedula='"+cedula+"';";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar"+e, "Imperium", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(String cedula){
        try {
            Connection conexion=conectar();
            st=conexion.createStatement();
            String sql="delete from enfermero where cedula='"+cedula+"';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Enfermero eliminado correctamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Médico"+e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
        
    }
}
