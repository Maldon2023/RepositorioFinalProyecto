package AccesoADatos;
import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class AlumnoData {     
    private Connection conex;  

    public AlumnoData() {
       conex=Conexion.Revisarconexion();
    }   
    
    
    public ArrayList<Alumno> listarAlumnos(){
        
        ArrayList<Alumno> listaA = new ArrayList<>();
        
        try {
            String sql = "SELECT (dni,apellido,nombre,fechaNacimiento) FROM alumno WHERE estado = 1 ";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                listaA.add(alumno);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return listaA;

    }
    
    // OPERACIONES CRUD:
    //C - CREATE Crear/Insertar
    public void guardarAlumno(Alumno a){
    
         String sql= (" INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento,estado"
                      + "VALUES (?,?,?,?,?)");  //Uso caracter comodin.
         
         try{   //solicito en el PS id y sql(sentencia insert)
             PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             //Asigno o setteo valor del caracter comodin
             ps.setInt(1, a.getDni());
             ps.setString(2, a.getApellido());
             ps.setString(3, a.getNombre());
             ps.setDate(4,Date.valueOf(a.getFechaNacimiento()));
             ps.setBoolean(5, a.isEstado());
             
             ps.executeUpdate();
             ResultSet rs= ps.getGeneratedKeys(); //El resultado seria una lista de 1 columna con tantos id como registros.
             
             if(rs.next()){
                 a.setIdAlumno(rs.getInt(1)); 
                 JOptionPane.showMessageDialog(null, "Alumno guardado.");
             }
            
             ps.close();
             rs.close();
         }catch (SQLException e){
             
             JOptionPane.showMessageDialog(null, " Error en la inserción en la Base de Datos. ");
         }     
     
    }   
    
    
    // U - UPDATE Actualizar/Modificar                                                         
    public void modificarAlumno(Alumno a){
    
        String sql= ("UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=?, estado=? WHERE idAlumno=?");
        
        try {
            PreparedStatement ps = conex.prepareStatement(sql);

            ps.setInt(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getFechaNacimiento()));
            ps.setBoolean(5, a.isEstado());
            ps.setInt(5,a.getIdAlumno());
            
            int filaMod= ps.executeUpdate(); //El metodo EXECUTE.UPDATE devuelve un entero(n° filas afectadas x modificacion)
            
            if (filaMod<=1) {
                JOptionPane.showMessageDialog(null, " Modificacion efectuada.");
            }
            
             ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error en la modificación en la Base de Datos.");
        }
    }
    
    
    // D - DELETE Borrar/Eliminar/Remover
    public void eliminarAlumno(int id){
        
        String sql= "UPDATE alumno SET estado=0 WHERE idAlumno=?"; //Borrado logico.
        
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
                       
            ps.setInt(1, id);
            
            int filaEliminada=ps.executeUpdate();
            
            if (filaEliminada==1) { // Sólo se borrara un registro(id).
                JOptionPane.showMessageDialog(null, " Eliminacion efectuada.");
            }
            
             ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error en la eliminacón en la Base de Datos.");
        }
    
    }
    
    
    // R - READ Leer/Seleccionar/Buscar
    public Alumno buscarAlumnoPorId(int id){
        Alumno a=null;
        
        String sql= ("SELECT (dni, apellido, nombre, fechaNacimiento,estado) FROM alumno WHERE idAlumno=? ");
    
        try{
             PreparedStatement ps=conex.prepareStatement(sql);
             ps.setInt(1, id);
             
             ResultSet rs=ps.executeQuery();
             
             if(rs.next()){
                 a= new Alumno();
                 a.setIdAlumno(id);
                 a.setDni(rs.getInt("dni"));
                 a.setApellido(rs.getString("apellido"));
                 a.setNombre(rs.getString("nombre"));
                 a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                 a.setEstado(true);
             }else
                 
                 JOptionPane.showMessageDialog(null,"El alumno no exixte");                                 
                
             ps.close();
             rs.close();
             
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error en la búsqueda en la Base de Datos.");
        }
        return a;
        
    }
    
    
    
    public Alumno buscarAlumnoPorDni(int dni){
         Alumno a=null;
        
        String sql= ("SELECT (apellido, nombre, fechaNacimiento,estado) FROM alumno WHERE dni=? ");
    
        try{
             PreparedStatement ps=conex.prepareStatement(sql);
             ps.setInt(1, dni);
             
             ResultSet rs=ps.executeQuery();
             
             if(rs.next()){
                 a= new Alumno();
                 a.setIdAlumno(rs.getInt("id"));
                 a.setDni(rs.getInt("dni"));
                 a.setApellido(rs.getString("apellido"));
                 a.setNombre(rs.getString("nombre"));
                 a.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                 a.setEstado(true);
             }else
                 
                 JOptionPane.showMessageDialog(null,"El alumno no exixte");                                 
                
             ps.close();
             rs.close();
             
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error en la búsqueda en la Base de Datos.");
        }
        return a;
        
    }
    
}

     

    
    

     
        
   

