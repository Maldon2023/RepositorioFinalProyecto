package AccesoADatos;


import AccesoADatos.AlumnoData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;



public class InscripcionData {


    private Connection Conex = null;


    private MateriaData matData;
    private AlumnoData aluData;
    
    
    public InscripcionData() {

        this.Conex = Conexion.Revisarconexion();

    }
    

    public void GuardarInscripcion(Inscripcion Insc) {
        String sql = "INSERT INTO universidadulp_inscripcion(nota,idAlumno,idMateria)" + "VALUES(?,?,?)";
        try {

            PreparedStatement ps = Conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Insc.getNota());
            ps.setInt(2, Insc.getAlumno().getidAlumno());
            ps.setInt(3, Insc.getMateria().getidMateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                Insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion registrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
    }
    
    

    public void BorrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

        String sql = "DELETE FROM universidadulp_inscripcion WHERE idAlumno = ? AND idMateria = ?";
        
        try {
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setInt(1,idAlumno);
            ps.setInt(2,idMateria);
            int filas = ps.executeUpdate();
            
            if (filas>0){
              JOptionPane.showMessageDialog(null, "universidadulp_inscripcion ha borrado la inscripcion");  
            } 
            
            ps.close();

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
    }
    
    

    public void ActualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE universidadulp_inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ? ";
       
        try {
            
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setDouble(1,nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int filas =ps.executeUpdate();
            
            if (filas>0){
              JOptionPane.showMessageDialog(null, "universidadulp_inscripcion ha sido actualizada");  
            } 
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
        
    }

<<<<<<< HEAD
    
    public ArrayList<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> listaInscripciones = new ArrayList<>();

        try {
            
            String sql = "SELECT * FROM universidadulp_inscripcion";
            PreparedStatement ps = Conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Inscripcion Insc = new Inscripcion();
                Insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno Alu = aluData.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia Mat = matData.BuscarMateria(rs.getInt("idMateria"));
                Insc.setAlumno(Alu);
                Insc.setMateria(Mat);
                Insc.setNota(rs.getInt("nota"));
                
                listaInscripciones.add(Insc);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
        return listaInscripciones;
    }
    
    
    public ArrayList<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> listaInscripcionesPorAlumno = new ArrayList<>();

        try {
            
            String sql = "SELECT * FROM universidadulp_inscripcion WHERE idAlumno = ?";
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setInt(1,idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Inscripcion Insc = new Inscripcion();
                Insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno Alu = aluData.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia Mat = matData.buscarMateria(rs.getInt("idMateria"));
                Insc.setAlumno(Alu);
                Insc.setMateria(Mat);
                Insc.setNota(rs.getInt("nota"));
                
                listaInscripcionesPorAlumno.add(Insc);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
        return listaInscripcionesPorAlumno;
    }
       
    
    public ArrayList<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materiasCursadasPorAlumno = new ArrayList<>();

        try {
            
            String sql = "SELECT Inscripcion.idMateria,nombre,anio FROM universidadulp_inscripcion,"
                        +"materia WHERE Inscripcion.idMateria = Materia.idMateria"
                        +"AND Inscripcion.idAlumno = ?;";
            
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setInt(1,idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("Año"));
                
                materiasCursadasPorAlumno.add(materia);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
        return materiasCursadasPorAlumno; 
        
    }
    
    
    public ArrayList<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> materiasNoCursadasPorAlumno = new ArrayList<>();

        try {
            
            String sql = "SELECT * FROM universidadulp_materia WHERE estado = 1 AND idMateria not in"
                        +"(SELECT idMateria FROM universidadulp_inscripcion WHERE idAlumno = ?);";
            
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setInt(1,idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("Año"));
                
                materiasNoCursadasPorAlumno.add(materia);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
        return materiasNoCursadasPorAlumno;
    }
    
     
    public ArrayList<Alumno> obtenerAlumnosInscriptos(int idMateria) {
        ArrayList<Alumno> listaAlumnosInscriptos = new ArrayList<>();

        try {
            
            String sql = "SELECT a.idAlumno,dni,nombre,apellido,fechaNacimiento,estado"
                        +" FROM universidadulp_inscripcion i,universidadulp_alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ?;";
            
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setInt(1,idMateria);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno alu = new Alumno();
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(true);

                listaAlumnosInscriptos.add(alu);

            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
        return listaAlumnosInscriptos;
        
     }

=======
    /*public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> ListaMateriasCursadas = new ArrayList<Materia>();

        try {
            String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion," + "materia WHERE inscripcion.idMateria = Materia.idMateria\n" + "AND inscripcion.idAlumno = ?;";
            PreparedStatement ps = Connection.preparedstatemant(sql);
            ps.setInt(1, idAlumno);
            Resultset rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("IdMateria"));
                materia.setNombre(rs.getString("Nombre"));
                materia.setAnio(rs.getAnio("Año"));
                ListaMateriasCursadas.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones" + ex.getMessage());
        }
        return ListaMateriasCursadas;
    }

    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        List<Materia> ListaMateriasNoCursadas = new ArrayList<Materia>();

        try {
            String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion," + "materia WHERE inscripcion.idMateria = Materia.idMateria\n" + "AND inscripcion.idAlumno = ?;";
            PreparedStatement ps = Connection.preparedstatemant(sql);
            ps.setInt(1, idAlumno);
            Resultset rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("IdMateria"));
                materia.setNombre(rs.getString("Nombre"));
                materia.setAnio(rs.getAnio("Año"));
                ListaMateriasCursadas.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones" + ex.getMessage());
        }
        return ListaMateriasCursadas;
    }*/
>>>>>>> a95260aec582ec5982627c1510187313505889d9
}

        

