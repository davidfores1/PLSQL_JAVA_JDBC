/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.backend.dao.impl;

import com.david.backend.dao.EmpleadoDao;
import com.david.backend.model.Empleado;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;

/**
 *
 * @author david
 */
@Repository
public class EmpleadoDaoImp implements EmpleadoDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate ;

    @Override
    public void save(Empleado empleado) {
        
       		StringBuilder sql = new StringBuilder();
		sql.append("DECLARE ");
		sql.append("empleado EMPLEADOS%ROWTYPE; ");
		sql.append(" BEGIN  ");
		sql.append("Select ");
		sql.append("?,");
		sql.append("?,");
		sql.append("?,");
		sql.append("?,");
		sql.append("?,");
		sql.append("?,");
		sql.append("?");
		sql.append("INTO empleado ");
		sql.append("From dual; ");
		sql.append(" PKG_CB_EMPLEADOS.PROC_INSERT_EMPLEADO(empleado); ");
		sql.append("END; ");
                
		jdbcTemplate.update(sql.toString(), empleado.getId(), empleado.getCedula(), empleado.getNombre(), empleado.getFecha(), empleado.getEstado(), empleado.getObservacion(),empleado.getSexo());
        
    }

    @Override
    public Empleado getByID(int id) {
    Empleado trab = jdbcTemplate.execute( "{ ? = call PKG4SD_UT_EMPLEADOS.FUN4SD_GETRECORD ( ? ) }", new CallableStatementCallback<Empleado>() {

			@Override
			public Empleado doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				cs.registerOutParameter( 1, OracleTypes.CURSOR );
				cs.setInt(2, id);
				cs.execute();
				
				ResultSet rs = (ResultSet) cs.getObject(1);
				Empleado rTrab = new Empleado();
				while (rs.next()) {
					rTrab.setId( rs.getInt("ID_EMPLEADO") );
					rTrab.setCedula(rs.getInt("CEDULA") );
					rTrab.setNombre(rs.getString("NOMBRE") );
					rTrab.setFecha(rs.getDate("FECHE") );
					rTrab.setEstado(rs.getString("ESTADO") );
                                        rTrab.setObservacion(rs.getString("OBSERVACION") );
                                        rTrab.setSexo(rs.getString("SEXO") );
				}
				return rTrab;
			}
		} );
		return trab;
    }
    
}
