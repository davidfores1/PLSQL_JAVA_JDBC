package com.runfores.colegio.dao;

/**
 *
 * @author david
 */
public interface DAOManager {

    AlumnoDao getAlumnoDAO();

    AsignaturaDao getAsignaturaDAO();

    MatriculaDao getMatriculaDAO();

    ProfesorDao getProfesorDAO();
}
