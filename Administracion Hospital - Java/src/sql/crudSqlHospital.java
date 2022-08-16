/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import hospital.modelo.Medico;
import hospital.modelo.Hospital;
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
public class crudSqlHospital extends conexionsql {

    java.sql.Statement st;
    ResultSet rs;
    Hospital hospital=new Hospital();


    public void insertar(String nombre, String ciudad, String provincia, String callePrincipal) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into hospital(nombre,ciudad,provincia,calleprincipal) values('" + nombre + "','" + ciudad + "','" + provincia + "','" + callePrincipal + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Hospital registrado exitosamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar hospital" + e, "Imperium", JOptionPane.ERROR_MESSAGE);
        }
    }
    
       
    public void mostrar(JTextField idhospital){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from hospital where idhospital='"+idhospital.getText()+"'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                hospital.setIdHospital(rs.getString("idhospital"));
                hospital.setNombreHospital(rs.getString("nombre"));
                hospital.setCiudadHospital(rs.getString("ciudad"));
                hospital.setProvinciaHospital(rs.getString("provincia"));
                hospital.setCallePrincipalHospital(rs.getString("calleprincipal"));
            } else {
                hospital.setIdHospital("");
                hospital.setNombre("");
                hospital.setCiudad("");
                hospital.setProvincia("");
                hospital.setIdHospital("");
                JOptionPane.showMessageDialog(null, "No se encontro Hospital", "Imperium", JOptionPane.INFORMATION_MESSAGE);
                st.close();
                conexion.close();
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error al buscar" + e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void SeleccionarHospital(JTable tblHospital, JTextField txtCedula){

        try {
            int fila=tblHospital.getSelectedRow();
            if (fila>=0) {
                txtCedula.setText(tblHospital.getValueAt(fila, 0).toString());
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
        
    }
    
    public void mostrarTabla(JTable panHospital){
        Connection conexion=conectar();
        DefaultTableModel modelo=new DefaultTableModel();
        String sql="";
        modelo.addColumn("ID Hospital");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Provincia");
        modelo.addColumn("Calle");
        
        panHospital.setModel(modelo);
        sql="select * from hospital;";
        String [] datos=new String[5];
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
                
                modelo.addRow(datos);
            }
        st.close();
        conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " +e.toString());

        }
    }
    
    public void SeleccionarMedico(JTable tblHospital, JTextField txtId){

        try {
            int fila=tblHospital.getSelectedRow();
            if (fila>=0) {
                txtId.setText(tblHospital.getValueAt(fila, 0).toString());
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
        
    }
    
    public void actualizar(String nombre, String ciudad, String provincia, String calleprincipal, String idhospital) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update hospital set nombre='" + nombre + "',ciudad='" + ciudad + "', provincia='" +provincia+ "',calleprincipal='" +calleprincipal+ "' where idhospital='" +idhospital+ "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e, "Imperium", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(String idhospital) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from hospital where idhospital='" + idhospital + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Hospital eliminado correctamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Hospital" + e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
    }
}

