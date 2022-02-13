package com.runfores.colegio.modelo;

import java.util.Objects;

public class Asignatura {

    private Long id = null;
    private String nombre;
    private Long id_profesor;

    public Asignatura(String nombre, Long id_profesor) {
        this.nombre = nombre;
        this.id_profesor = id_profesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id=" + id + ", nombre=" + nombre + ", id_profesor=" + id_profesor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.id_profesor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asignatura other = (Asignatura) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.id_profesor, other.id_profesor)) {
            return false;
        }
        return true;
    }
    
    
}
