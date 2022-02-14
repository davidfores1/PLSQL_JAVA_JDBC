package com.runfores.colegio.dao;

/**
 *
 * @author david
 */
public class DAOException extends  Exception{

    public DAOException(String string) {
        super(string);
    }

    public DAOException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DAOException(Throwable thrwbl) {
        super(thrwbl);
    }
    
    
    
}
