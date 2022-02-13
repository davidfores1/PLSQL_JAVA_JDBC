package com.runfores.colegio.modelo;

import java.util.Objects;

/**
 *
 * @author david
 */
public class Matricula {
    
    private Long alumno;
    private Long asignatura;
    private int year;
    private Integer nota = null;

    public Matricula(Long alumno, Long asignatura, int year) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.year = year;
    }

    public Long getAlumno() {
        return alumno;
    }

    public void setAlumno(Long alumno) {
        this.alumno = alumno;
    }

    public Long getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Long asignatura) {
        this.asignatura = asignatura;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Matricula{" + "alumno=" + alumno + ", asignatura=" + asignatura + ", year=" + year + ", nota=" + nota + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.alumno);
        hash = 73 * hash + Objects.hashCode(this.asignatura);
        hash = 73 * hash + this.year;
        hash = 73 * hash + Objects.hashCode(this.nota);
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
        final Matricula other = (Matricula) obj;
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        if (!Objects.equals(this.nota, other.nota)) {
            return false;
        }
        return true;
    }
    
    
}
