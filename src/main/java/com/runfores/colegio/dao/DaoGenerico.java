package com.runfores.colegio.dao;

import java.util.List;

/**
 *
 * @author david
 */
public interface DaoGenerico<T, k> {

    void insertar(T a) throws DAOException;

    void modificar(T a) throws DAOException;

    void eliminar(T a) throws DAOException;

    List<T> obtenerTodos() throws DAOException;

    T obtener(k id) throws DAOException;
}
