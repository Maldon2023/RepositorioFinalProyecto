package AccesoADatos;


import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class MateriaData {
    private Connection conex;

    public MateriaData() {
        conex=Conexion.Revisarconexion();
    }
    public void guardarMateria(Materia materia) throws SQLException {
         String sql= (" INSERT INTO materia (nombre, anio,estado)"
                      + "VALUES (?,?,?)");
         
         try{  
             PreparedStatement ps = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
              ps.setInt(1, materia.getAnio());
              ps.setString(2, materia.getNombre());
              ps.setBoolean(3, materia.isEstado());
              ps.executeUpdate();
              ResultSet rs= ps.getGeneratedKeys();
             
             if(rs.next()){
               materia.setIdMateria(rs.getInt(1)); 
                JOptionPane.showMessageDialog(null, " se guardo la materia.");
              ps.close();
             rs.close();
        }
         }catch (SQLException ex){
             
           JOptionPane.showMessageDialog(null, " Error en la inserción en la Base de Datos"+ex.getMessage());
             
                }     
             
    }
   public Materia BuscarMateria(int Id) {
       throw new UnsupportedOperationException("Not supported yet.");
    }

    public void modificarMateria(Materia materia){ 
      
     String sql= ("UPDATE materia SET anio=?,nombre=?, estado=? WHERE idMateria=?");
        
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
              ps.setInt(1, materia.getAnio());
              ps.setString(2, materia.getNombre());
              ps.setBoolean(3, materia.isEstado());
              ps.setInt(4,materia.getIdMateria());

               int modificar = ps.executeUpdate();
               if (modificar<=1) {
               JOptionPane.showMessageDialog(null, " se modifico la materia.");
               ps.close();

}
           } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la modificación en la Base de Datos.");
       
}
}   
 

public void eliminarMateria(int id) {

    try {
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ? ";
        PreparedStatement ps = conex.prepareStatement(sql);
        ps.setInt(1, id);

        int fila = ps.executeUpdate();

        if (fila == 1) {
            JOptionPane.showMessageDialog(null, " Se eliminó la materia.");
        }
        ps.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, " Error al acceder a la tabla materia");
    }
}

 public Materia buscarMateria(int id) {

       Materia a = null;
        
        String sql= ("SELECT ( nombre, anio , estado) FROM materia WHERE idMateria=? ");
    
        try{
             PreparedStatement ps=conex.prepareStatement(sql);
             ps.setInt(1, id);
             
             ResultSet rs=ps.executeQuery();
             
             if(rs.next()){
                 a= new Materia();
                 a.setNombre(rs.getString("nombre"));
                 a.setAnio(rs.getInt("anio"));
                 a.setEstado(true);
             
             }else
                 
                 JOptionPane.showMessageDialog(null,"La materia no esta");                                 
                
             ps.close();
             rs.close();
             
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error  en la Base de Datos.");
        }
        return a;

    }
 
 
 public ArrayList<Materia> listarmateria(){
        
        ArrayList<Materia> listaMat= new ArrayList<>();
        
        try {
            String sql = "SELECT (nombre,anio,estado) FROM materia WHERE estado = 1 ";
            
            PreparedStatement ps = conex.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getNString("nombre"));
                materia.setEstado(rs.getBoolean("estado"));
                materia.setAnio(rs.getInt("anio"));                
                   
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla materia" + " " + ex.getMessage());
        }
        return listaMat;

    }
}
 

