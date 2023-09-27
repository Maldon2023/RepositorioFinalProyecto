package repositoriofinalproyecto;

import AccesoADatos.*;
import Entidades.*;
import java.sql.Date;
import java.time.*;



public class RepositorioFinalProyecto {

    public static void main(String[] args) {
        
        
        Conexion revisando = new Conexion();
        revisando.Revisarconexion();
        
        
        
        Alumno a  = new Alumno(10203, "Alvarez", "Jorgelina",LocalDate.of(2004, Month.APRIL, 2), true);
        /*Alumno b  = new Alumno(00020304, "Montoya", "Juan Ignacio", LocalDate.of(2004, Month.APRIL, 2), true);
        Alumno c  = new Alumno(00030405, "Roncatto", "Alex", LocalDate.of(2002, Month.SEPTEMBER, 21), true);
        Alumno d  = new Alumno(00040506, "Del Toro", "MariaLuz", LocalDate.of(2000, Month.JANUARY, 31), true);
        Alumno e  = new Alumno(00050607, "Jaime", "Matias", LocalDate.of(2001, Month.MARCH, 30), true);
        */
        AlumnoData aD =new AlumnoData();
        /*aD.guardarAlumno(a);
        aD.guardarAlumno(b);
        aD.guardarAlumno(c);
        aD.guardarAlumno(d);
        aD.guardarAlumno(e);
        
        

        Materia Pdl =new Materia("PDL",6,true);
        Materia Labo =new Materia("Laboratorio",8,true);
        Materia Repos =new Materia("Repositorios",10,true);
        Materia Metod =new Materia("Metodos",9,true);
        Materia Insta =new Materia("Instancias",7,true);
        */

        MateriaData md =new MateriaData();
        /*md.guardarMateria(Pdl);
        md.guardarMateria(Labo);
        md.guardarMateria(Repos);
        md.guardarMateria(Metod);
        md.guardarMateria(Insta);
        
        */
        Alumno DelToro = aD.buscarAlumnoPorId(5);
        Materia Labo = md.buscarMateria(2);
        
        
        InscripcionData InD = new InscripcionData();
        Inscripcion Insc = new Inscripcion(8,DelToro,Labo);
        
        
        InD.GuardarInscripcion(Insc);

        
        
        
    }
    
}
