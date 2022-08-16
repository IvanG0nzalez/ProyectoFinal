/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import hospital.modelo.Medico;
import hospital.modelo.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhandry
 */
public class crudSqlPaciente extends conexionsql{
    
    java.sql.Statement st;
    ResultSet rs;
    Paciente paciente = new Paciente();
    
    public void insertar(String cedula, String nombre, String apellido, Integer edad, float peso, float altura, String motivo, String genero, String fecha){
        try {
        
        Connection conexion = conectar();
        st = conexion.createStatement();
        String sql ="insert into paciente (cedula,nombre,apellido,edad,peso,altura,motivo,genero,fecha) values('"+cedula+"', '"+nombre+"', '"+apellido+"', '"+edad+"', '"+peso+"', '"+altura+"', '"+motivo+"', '"+genero+"', '"+fecha+"');";
        st.execute(sql);
        st.close();
        conexion.close();
            JOptionPane.showMessageDialog(null, "Se añadio un nuevo paciente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir un nuevo paciente"+e, "Imperium", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
    public void asignarHospital(Integer hospital, String cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = " update paciente set hospital ='" + hospital + "' where cedula='" +cedula+ "';";
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
            st = conexion.createStatement();
            String sql = "select * from paciente where cedula='"+cedula.getText()+"';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                paciente.setCedula(rs.getString("cedula"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setPeso(rs.getFloat("peso"));
                paciente.setEstatura(rs.getFloat("altura"));
                paciente.setMotivo(rs.getString("motivo"));
                paciente.setGenero(rs.getString("genero"));
                paciente.setPacienteFecha(rs.getString("fecha"));
            }else {
                paciente.setCedula("");
                paciente.setNombre("");
                paciente.setApellido("");
                paciente.setEdad(0);
                paciente.setPeso(0f);
                paciente.setEstatura(0f);
                paciente.setMotivo("");
                paciente.setGenero("");
                paciente.setPacienteFecha("");
                JOptionPane.showMessageDialog(null, "No se encontro Paciente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
                st.close();
                conexion.close();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar"+e, "Imperium", JOptionPane.ERROR_MESSAGE);  
        }
    }
    
    public void SeleccionarPaciente(JTable tblPaciente, JTextField txtCedula){

        try {
            int fila=tblPaciente.getSelectedRow();
            if (fila>=0) {
                txtCedula.setText(tblPaciente.getValueAt(fila, 0).toString());
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
        
    }
    
    public void mostrarTabla(JTable panPaciente){
        Connection conexion=conectar();
        DefaultTableModel modelo=new DefaultTableModel();
        String sql="";
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Motivo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hospital");
        
        panPaciente.setModel(modelo);
        sql="select * from paciente;";
        String [] datos=new String[10];
        java.sql.Statement st;
        try {
            st=conectar().createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(7);
                datos[4]=rs.getString(9);
                datos[5]=rs.getString(10);
                
                modelo.addRow(datos);
            }
        st.close();
        conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }

    }
    
    public void actualizar(String nombre, String apellido, Integer edad, float peso, float altura, String motivo, String genero, String fecha,String cedula){
        try {
            Connection conexion = conectar();
            st=conexion.createStatement();
            String sql="update paciente set nombre='"+nombre+"', apellido='"+apellido+"', edad='"+edad+"', peso='"+peso+"', altura='"+altura+"', motivo='"+motivo+"', genero='"+genero+"', fecha='"+fecha+"' where cedula='"+cedula+"';";
            st.executeUpdate(sql);
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
            String sql="delete from paciente where cedula='"+cedula+"';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Paciente"+e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
        
    }
    
}
