package com.runfores.colegio.dao.mysql;

import com.runfores.colegio.dao.AlumnoDao;
import com.runfores.colegio.dao.DAOException;
import com.runfores.colegio.modelo.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author david
 */
public class MysqlAlumnoDao implements AlumnoDao {

    final String INSERT = "insert into alumnos(id_alumno, nombre, apellidos,fecha_nace)VALUES(?,?,?,?)";
    final String UPDATE = "update alumnos set nombre = ?, apellidos = ?, fecha_nac = ? where id_alumno = ?";
    final String DELETE = "DELETE FROM ALUMNO WHERE id_alumno = ?";
    final String GETALL = "select id_alumno, nombre, apellidos, fecha_nac from alumnos";
    final String GETONE = "select id_alumno, nombre, apellidos, fecha_nac from alumnos where id_alumno = ?";

    private Connection conn;

    public MysqlAlumnoDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Alumno a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getId());
            stat.setString(2, a.getNombre());
            stat.setString(2, a.getApellido());
            stat.setDate(2, new Date(a.getFechaNacimiento().getTime()));
            if (stat.executeUpdate() == 0){
            throw new DAOException("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (stat != null) {

                try {
                    stat.close();
                } catch (Exception e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
        }
    }

    @Override
    public void modificar(Alumno a) throws DAOException {
        
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getId());
            stat.setString(2, a.getNombre());
            stat.setString(2, a.getApellido());
            stat.setDate(2, new Date(a.getFechaNacimiento().getTime()));
            if (stat.executeUpdate() == 0){
            throw new DAOException("Puede que no se haya MODIFICADO");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (stat != null) {

                try {
                    stat.close();
                } catch (Exception e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
        }
        
    }

    @Override
    public void eliminar(Alumno a) throws DAOException {
        
        
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getId());
            if (stat.executeUpdate() == 0){
            throw new DAOException("Puede que no se haya BORRADO");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (stat != null) {

                try {
                    stat.close();
                } catch (Exception e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
        }
    }

    @Override
    public List<Alumno> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
