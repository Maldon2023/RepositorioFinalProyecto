/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatos.AlumnoData;
import Entidades.Inscripcion;
import java.sql.Connection;

public class InscripcionData extends Conexion {

    private Connection Conexion;

    private MateriaData matData;

    private AlumnoData aluData;

    public InscripcionData() {
    }

    public void GuardarInscripcion(Inscripcion Insc) {
    }

    public void BorrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
    }

    public void ActualizarNota(int idAlumno, int idMateria, double nota) {
    }
}
