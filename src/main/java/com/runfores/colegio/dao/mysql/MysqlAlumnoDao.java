package com.runfores.colegio.dao.mysql;

import com.runfores.colegio.dao.AlumnoDao;
import com.runfores.colegio.dao.DAOException;
import com.runfores.colegio.modelo.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class MysqlAlumnoDao implements AlumnoDao {

    final String INSERT = "insert into alumnos(nombre, apellidos,fecha_nac)VALUES(?,?,?)";
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
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT, RETURN_GENERATED_KEYS);
            stat.setString(1, a.getNombre());
            stat.setString(2, a.getApellido());
            stat.setDate(3, new Date(a.getFechaNacimiento().getTime()));
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya guardado");
            }

            rs = stat.getGeneratedKeys();
            if (rs.next()) {
                a.setId(rs.getLong(1));
            } else {
                throw new DAOException("No se pudo asignar ID a est alumno");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {

                    new DAOException("Error en SQL", e);
                }
            }

            if (stat != null) {

                try {
                    stat.close();
                } catch (SQLException e) {
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
            stat.setString(3, a.getApellido());
            stat.setDate(4, new Date(a.getFechaNacimiento().getTime()));
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya MODIFICADO");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (stat != null) {

                try {
                    stat.close();
                } catch (SQLException e) {
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
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya BORRADO");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (stat != null) {

                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
        }
    }

    private Alumno convertir(ResultSet rs) throws SQLException {

        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        Date fechaNac = rs.getDate("fecha_nac");
        Alumno alumno = new Alumno(nombre, apellidos, fechaNac);
        alumno.setId(rs.getLong("id_alumno"));
        return alumno;
    }

    @Override
    public List<Alumno> obtenerTodos() throws DAOException {

        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Alumno> alumnos = new ArrayList<>();

        try {
            stat = conn.prepareCall(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {

                alumnos.add(convertir(rs));

            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {

                    new DAOException("Error en SQL", e);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    new DAOException("Error en SQL", e);
                }
            }
        }
        return alumnos;
    }

    @Override
    public Alumno obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Alumno a = null;

        try {
            stat = conn.prepareCall(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                a = convertir(rs);
            } else {
                throw new DAOException("No se encontro el registro");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {

                    new DAOException("Error en SQL", e);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    new DAOException("Error en SQL",e);
                }
            }
        }
        return a;
    }

//    public static void main(String[] args) throws SQLException, DAOException {
//
//        Connection conn = null;
//
//        try {
//
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colegio_db", "root", "");
//            AlumnoDao dao = new MysqlAlumnoDao(conn);
//            List<Alumno> alumnos = dao.obtenerTodos();
////            for (Alumno a : alumnos) {
////                System.out.println(a.toString());
////            }
//
//            Alumno nuevo = new Alumno("dave", "Forero", new Date(1991, 2, 1));
//            dao.insertar(nuevo);
//            System.out.println("ID creado: " + nuevo.getId());
//
//        } finally {
//            if (conn != null) {
//                conn.close();
//            }
//        }
//    }

}
