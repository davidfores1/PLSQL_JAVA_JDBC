
package com.david.backend.dao;

import com.david.backend.model.Empleado;

/**
 *
 * @author david
 */
public interface EmpleadoDao {
    
    void save(Empleado empleado);
    
    Empleado getByID(int id);
    
}
