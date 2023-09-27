package AccesoADatos;

import AccesoADatos.*;
import Entidades.*;
import java.awt.List;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import org.mariadb.jdbc.Statement;

public class InscripcionData {

    private Connection Conex = null;

    private MateriaData matData = new MateriaData();

    private AlumnoData aluData = new AlumnoData();

    public InscripcionData() {
        this.Conex = Conexion.Revisarconexion();
    }

    public void GuardarInscripcion(Inscripcion Insc) {
        String sql = "INSERT INTO universidadulp_inscripcion(nota,idAlumno,idMateria)" + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = Conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Insc.getNota());
            ps.setInt(2, Insc.getAlumno().getIdAlumno());
            ps.setInt(3, Insc.getMateria().getIdMateria());
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
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        
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
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ? ";
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
    
    public ArrayList<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> listaInscripciones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps = Conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion Insc = new Inscripcion();
                Insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno Alu = aluData.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia Mat = matData.buscarMateria(rs.getInt("idMateria"));
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
            String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
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
            String sql = "SELECT Inscripcion.idMateria,nombre,anio FROM inscripcion,"+"materia WHERE Inscripcion.idMateria = Materia.idMateria"+"AND Inscripcion.idAlumno = ?;";
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
            String sql = "SELECT * FROM Materia WHERE estado = 1 AND idMateria not in"+"(SELECT idMateria FROM inscripcion WHERE idAlumno = ?);";
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
            String sql = "SELECT a.idAlumno,dni,nombre,apellido,fechaNacimiento,estado"+" FROM Inscripcion i,Alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ?;";
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setInt(1,idMateria);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
             Alumno alu = new Alumno();
             alu.setIdAlumno(rs.getInt("idAlumno"));
             alu.setDni(rs.getInt("dni"));
             alu.setNombre(rs.getString("nombre"));
             alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
             alu.setEstado(rs.getBoolean("estado"));
             listaAlumnosInscriptos.add(alu);
             
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
        return listaAlumnosInscriptos;
        
     }
}