package Entidades;


import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Inscripcion {
   private int idInscripcion;
   private int nota;
   private Alumno alumno;
   private Materia materia;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, int nota, Alumno alumno, Materia materia) {
        this.idInscripcion = idInscripcion;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(int nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(int nota) {
        this.nota = nota;
    }
    
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        String Inscripcion = ( "N° de Inscripcion: "+ idInscripcion + "\n" + ("Alumno: "+ alumno.getApellido() + ", " +alumno.getNombre()) + ": "+ materia.getNombre()+ "-" +materia.getAnio() + "año");
        return Inscripcion;
    }   

}