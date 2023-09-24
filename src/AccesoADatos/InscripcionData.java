/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatos.*;
import Entidades.*;
import java.awt.List;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

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
            ps.setInt(2, Insc.getAlumno().getidAlumno();
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
        
        
        try {
            PreparedStatement ps = Conex.prepareStatement(sql);
            ps.setBoolean()........
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos universidadulp_inscripcion");
        }
    }

    public void ActualizarNota(int idAlumno, int idMateria, double nota) {
    }

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
}
