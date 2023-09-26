package AccesoADatos;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/" ;
    private static final String DB = "universidadulp_equipo27";
    private static final String USUARIO = "root";
    private static String PASSWORD= "";
    private static Connection conex;

    public Conexion() {
    }
    public static Connection Revisarconexion(){
       if  (conex == null){
           try{
               Class.forName("org.mariadb.jdbc.Driver");

               conex= DriverManager.getConnection (URL + DB+"?useLegacyDatetimeCode = false&severTimezone = UTC " + "&user= "  + USUARIO + " &password = " + PASSWORD );
               JOptionPane.showMessageDialog(null,"Conexion a base de datos exitosa");

           } catch ( SQLException    uni  ){
               JOptionPane.showMessageDialog( null , " Error al conectarse con la base de datos"+ uni.getMessage());
               
           } catch (ClassNotFoundException uni) {
               JOptionPane.showMessageDialog(null, " Error al cargar los drivers" + uni.getMessage());
           }
        
       } return conex;   
        
        
    }
    
 
 
    }
