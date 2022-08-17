/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import hospital.EditarMedico;
import hospital.modelo.Medico;
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
public class crudSqlMedico extends conexionsql {

    java.sql.Statement st;
    ResultSet rs;
    Medico medico = new Medico();

    public void insertar(String cedula, String nombre, String apellido, String especialidad, float sueldo) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "insert into medico(cedula,nombre,apellido, especialidad, sueldo) values('" + cedula + "','" + nombre + "','" + apellido + "', '" + especialidad + "', '" + sueldo + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se añadio un nuevo medico", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir un nuevo medico" + e, "Imperium", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void asignarPaciente(String asignacion, String cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = " update medico set asignacion ='"+ asignacion+"' where cedula='" + cedula + "';";
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
            String sql = " update medico set hospital ='" + hospital + "' where cedula='" +cedula+ "';";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se asigno el hospital correctamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al asignar hospital" + e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void mostrar(JTextField cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from medico where cedula='" + cedula.getText() + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                medico.setCedula(rs.getString("cedula"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medico.setSueldo(rs.getFloat("sueldo"));
            } else {
                medico.setCedula("");
                medico.setNombre("");
                medico.setApellido("");
                medico.setEspecialidad("");
                medico.setSueldo(0f);
                JOptionPane.showMessageDialog(null, "No se encontro Medico", "Imperium", JOptionPane.INFORMATION_MESSAGE);
                st.close();
                conexion.close();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar" + e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }

    }
    
    public void SeleccionarMedico(JTable tblMedico, JTextField txtCedula){

        try {
            int fila=tblMedico.getSelectedRow();
            if (fila>=0) {
                txtCedula.setText(tblMedico.getValueAt(fila, 0).toString());
            }else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
        
    }

    public void mostrarTabla(JTable panMedico) {
        Connection conexion = conectar();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql = "";
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Especialidad");
        modelo.addColumn("Sueldo");
        modelo.addColumn("Paciente");
        modelo.addColumn("Hospital");

        panMedico.setModel(modelo);
        sql = "select * from medico;";
        String[] datos = new String[7];
        java.sql.Statement st;
        try {
            st = conectar().createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);

                modelo.addRow(datos);
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostar " + e.toString());

        }

    }

    public void actualizar(String nombre, String apellido, String especialidad, float sueldo, String cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update medico set nombre='" + nombre + "',apellido='" + apellido + "',especialidad='" + especialidad + "',sueldo='" + sueldo + "' where cedula='" + cedula + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e, "Imperium", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar(String cedula) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from medico where cedula='" + cedula + "';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Médico eliminado correctamente", "Imperium", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Médico" + e, "Imperium", JOptionPane.ERROR_MESSAGE);

        }
    }

}
