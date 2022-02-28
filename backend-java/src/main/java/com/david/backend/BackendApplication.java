package com.david.backend;

import com.david.backend.dao.EmpleadoDao;
import com.david.backend.model.Empleado;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    @Autowired
    private EmpleadoDao empleadoDao;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Empleado empleado = new Empleado();
        empleado.setId(5);
        empleado.setCedula(544);
        empleado.setNombre("Emili");
        empleado.setFecha(new Date());
        empleado.setEstado("Prueba5");
        empleado.setObservacion("Prueba5");
        empleado.setSexo("Prueba5");
        
        empleadoDao.save(empleado);
        
        Empleado empleado1 = empleadoDao.getByID(5);
        System.out.println(empleado1);
    }

}
