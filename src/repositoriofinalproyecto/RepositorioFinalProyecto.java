package repositoriofinalproyecto;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import Entidades.Alumno;
import java.time.LocalDate;
import java.time.Month;


public class RepositorioFinalProyecto {

    public static void main(String[] args) {
        
        
        
        Alumno a  = new Alumno(00010203, "Alvarez", "Jorgelina", LocalDate.of(2003, Month.MAY, 10), true);
//        Alumno b  = new Alumno(00020304, "Montoya", "Juan Ignacio", LocalDate.of(2004, Month.APRIL, 2), true);
//        Alumno c  = new Alumno(00030405, "Roncatto", "Alex", LocalDate.of(2002, Month.SEPTEMBER, 21), true);
//        Alumno d  = new Alumno(00040506, "Del Toro", "MariaLuz", LocalDate.of(2000, Month.JANUARY, 31), true);
//        Alumno e  = new Alumno(00050607, "Jaime", "Matias", LocalDate.of(2001, Month.MARCH, 30), true);
        
        AlumnoData aD =new AlumnoData();
        aD.guardarAlumno(a);
//        aD.guardarAlumno(b);
//        aD.guardarAlumno(c);
//        aD.guardarAlumno(d);
//        aD.guardarAlumno(e);
                
        
        
        
    }
    
}
