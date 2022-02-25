create or replace PACKAGE PKG4SD_UT_EMPLEADOS AS
/*==============================================================*/
/* SISTEMA:     PACKAGE UTIL           					*/
/* PAQUETE:     PKG4SD_UT_EMPLEADOS.sql     	                    */
/* DESCRIPCION: UTILIDADES PARA: EMPLEADOS       			    */
/* AUTOR:       David Forero							        */
/* FECHA:       05/02/2022                                      */
/*==============================================================*/
  /* Declaración de variable tipo cursor */

  TYPE type_cursor IS REF CURSOR;

  -----------------------------------------------------------------------------
  -- Fun4SD_Exist FUNCION PARA DETERMINAR QUE EL EMPLEADO EXISTA
  -----------------------------------------------------------------------------
  Function Fun4SD_Exist
	(
		pvId_Docu   IN    EMPLEADOS.ID_EMPLEADO%TYPE
	)
	Return Boolean; 

  -----------------------------------------------------------------------------
  -- Fun4SD_GetRecord FUNCION PARA OBTENER UN CURSOR CON SUS DATOS
  -----------------------------------------------------------------------------  
  Function Fun4SD_GetRecord
	(
		pvId_Docu   IN    EMPLEADOS.ID_EMPLEADO%TYPE
	)
  Return type_cursor;

End PKG4SD_UT_EMPLEADOS;