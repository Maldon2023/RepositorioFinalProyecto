/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 
 */
public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/" ;
    private static final String DB = "universidadUlp_equipo27";
    private static final String USUARIO = "root";
    private static String PASSWORD= "";
    private static Connection connection;

    public Conexion() {
    }
    public static Connection Revisarconexion(){
       if  (connection == null){
           try{
               Class.forName("org.mariadb.jdbc.Driver");
               connection = DriverManager.getConnection (URL + DB+"?useLegacyDatetimeCode = false&severTimezone = UTC " + "&user= "  + USUARIO + " &password = " + PASSWORD );
       
           } catch ( SQLException    uni  ){
               JOptionPane.showMessageDialog( null , " Error al conectarse con la base de datos"+ uni.getMessage());
               
           } catch (ClassNotFoundException uni) {
               JOptionPane.showMessageDialog(null, " Error al cargar los drivers" + uni.getMessage());
           }
        
       } return connection;   
        
        
    }
    
 
 
    }
