package com.runfores.colegio.dao;

import java.util.List;

/**
 *
 * @author david
 */
public interface DaoGenerico<T, k> {

    void insertar(T a);

    void modificar(T a);

    void eliminar(T a);

    List<T> obtenerTodos();

    T obtener(k id);
}
