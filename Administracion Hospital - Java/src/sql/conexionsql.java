
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Jhandry
 */
public class conexionsql {
    Connection conn=null;
    String url="jdbc:postgresql://localhost/hospital";
    String usuario="hospital";
    String clave="hospital";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url,usuario,clave);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    return conn;
    }
}
