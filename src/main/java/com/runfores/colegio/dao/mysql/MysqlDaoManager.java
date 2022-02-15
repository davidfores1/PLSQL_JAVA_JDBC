package com.runfores.colegio.dao.mysql;

import com.runfores.colegio.dao.AlumnoDao;
import com.runfores.colegio.dao.AsignaturaDao;
import com.runfores.colegio.dao.DAOException;
import com.runfores.colegio.dao.DAOManager;
import com.runfores.colegio.dao.MatriculaDao;
import com.runfores.colegio.dao.ProfesorDao;
import com.runfores.colegio.modelo.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author david
 */
public class MysqlDaoManager implements DAOManager{

    private Connection conn;
    
    private AlumnoDao alumnos = null;
    private ProfesorDao profesores = null;
    private MatriculaDao matriculas = null;
    private AsignaturaDao asignaturas = null;
    
    
    public MysqlDaoManager(String host, String database, String username, String password)throws SQLException{
       conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database,username,password);
    }

    @Override
    public AlumnoDao getAlumnoDAO() {
        if(alumnos == null){
         alumnos = new MysqlAlumnoDao(conn);
        }
        
        return alumnos;
    }

    @Override
    public AsignaturaDao getAsignaturaDAO() {
        
        if(asignaturas == null){
          asignaturas = new MysqlAsignaturaDao(conn);
        }
        
        return asignaturas;
    }

    @Override
    public MatriculaDao getMatriculaDAO() {
        
          if(matriculas == null){
          matriculas = new MysqlMatriculaDao(conn);
        }
          return matriculas;
    }

    @Override
    public ProfesorDao getProfesorDAO() {
               if(profesores == null){
          profesores = new MysqlProfesorDao(conn);
        }
          return profesores;
    }
    
    
    public static void main(String[] args) throws SQLException, DAOException {
        MysqlDaoManager man = new MysqlDaoManager("localhost","colegio_db","root","");
        List<Alumno> alumnos = man.getAlumnoDAO().obtenerTodos();
        System.out.println(alumnos);
                
    }
}
