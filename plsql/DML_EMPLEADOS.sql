--------------------------------------------------------------------------------
-- INNSERT
--------------------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE

USUARIO EMPLEADOS%ROWTYPE; 

BEGIN

SELECT
1,
5465,
'PERA',
to_date('01/03/2020','dd/mm/yyyy'),
'INTO',
'INTO',
'S'
INTO USUARIO
FROM DUAL;

PKG_CB_EMPLEADOS.PROC_INSERT_EMPLEADO(USUARIO);

END;
/
SELECT * FROM EMPLEADOS;

--------------------------------------------------------------------------------
--UPDATE
--------------------------------------------------------------------------------
SET SERVEROUTPUT ON;
DECLARE

USUARIO EMPLEADOS%ROWTYPE; 

BEGIN

SELECT
1,
5465,
'PERA',
to_date('01/03/2020','dd/mm/yyyy'),
'PELA',
'LSDA',
'S'
INTO USUARIO
FROM DUAL;

PKG_CB_EMPLEADOS.PRO_UPDATE_EMPLEADO(USUARIO);

END;
/

select * from EMPLEADOS;

--------------------------------------------------------------------------------
--DELETE
--------------------------------------------------------------------------------
    
BEGIN

PKG_USUARIOS_DAVID.PROC_ELIMINAR_USUARIO(10);

END;
/

select * from USUARIOS_DAVID;

--------------------------------------------------------------------------------
--consultar datos por id de usuarios_david
--------------------------------------------------------------------------------

--select PKG_USUARIOS_DAVID.FUNC_DATOS_USUARIO_id(7)as usuario from dual;

VAR RETORNO REFCURSOR
exec :RETORNO:=PKG_USUARIOS_DAVID.FUNC_DATOS_USUARIO_id(7);
PRINT RETORNO;


--------------------------------------------------------------------------------
--consultar todos los datos de usuarios_david
--------------------------------------------------------------------------------
--select PKG_USUARIOS_DAVID.FUNC_DATOS_USUARIOS from dual;

VAR RETORNO REFCURSOR
exec :RETORNO:=PKG_USUARIOS_DAVID.FUNC_DATOS_USUARIOS;
PRINT RETORNO;
