package com.david.backend.model;

import java.util.Date;

/**
 *
 * @author david
 */
public class Empleado {

    private int id;
    private int cedula;
    private String nombre;
    private Date fecha;
    private String estado;
    private String observacion;
    private String sexo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", fecha=" + fecha + ", estado=" + estado + ", observacion=" + observacion + ", sexo=" + sexo + '}';
    }
    
    
}
