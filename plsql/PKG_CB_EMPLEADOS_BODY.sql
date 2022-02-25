CREATE OR REPLACE PACKAGE BODY PKG_CB_EMPLEADOS AS 
/*==============================================================*/
/* SISTEMA:     4SD - PACKAGE CRUD           					          */
/* PAQUETE:     PKG_CB_EMPLEADOS.sql     	                      */
/* DESCRIPCION: CRUD PARA: EMPLEADO       			        */
/* AUTOR:       David Forero							                    */
/* FECHA:       05/02/2022                                      */
/*==============================================================*/
  -----------------------------------------------------------------------------
  -- pr_InsRecord
  -----------------------------------------------------------------------------
	PROCEDURE PROC_INSERT_EMPLEADO
	(
		PAR_INSERT_EMPLEADO  IN  EMPLEADOS%ROWTYPE
	)
	IS


	BEGIN

		INSERT INTO EMPLEADOS
		(
        ID_EMPLEADO,
		CEDULA,
		NOMBRE,
		FECHE,
		ESTADO,
		OBSERVACION,
		SEXO
		)
		VALUES
		(
        PAR_INSERT_EMPLEADO.ID_EMPLEADO,
		PAR_INSERT_EMPLEADO.CEDULA,
		PAR_INSERT_EMPLEADO.NOMBRE,
		PAR_INSERT_EMPLEADO.FECHE,
		PAR_INSERT_EMPLEADO.ESTADO,
		PAR_INSERT_EMPLEADO.OBSERVACION,
		PAR_INSERT_EMPLEADO.SEXO
		);

	END PROC_INSERT_EMPLEADO;


  -----------------------------------------------------------------------------
  -- pr_UpRecord
  -----------------------------------------------------------------------------
	PROCEDURE PRO_UPDATE_EMPLEADO
	(
		PAR_UPDATE_EMPLEADO  IN  EMPLEADOS%ROWTYPE
	)
	IS

	BEGIN

		UPDATE EMPLEADOS
		SET
		ID_EMPLEADO = PAR_UPDATE_EMPLEADO.ID_EMPLEADO,
		CEDULA = PAR_UPDATE_EMPLEADO.CEDULA,
		NOMBRE = PAR_UPDATE_EMPLEADO.NOMBRE,
		FECHE = PAR_UPDATE_EMPLEADO.FECHE,
		ESTADO = PAR_UPDATE_EMPLEADO.ESTADO,
		OBSERVACION = PAR_UPDATE_EMPLEADO.OBSERVACION,
		SEXO = PAR_UPDATE_EMPLEADO.SEXO
		WHERE
        ID_EMPLEADO = PAR_UPDATE_EMPLEADO.ID_EMPLEADO;

	END PRO_UPDATE_EMPLEADO;

  -----------------------------------------------------------------------------
  -- pr_DelRecord
  -----------------------------------------------------------------------------
	PROCEDURE PRO_DELETE_EMPLEADO
	(
		 PAR_DELETE_EMPLEADO   IN  EMPLEADOS.ID_EMPLEADO%TYPE
	)

	IS

	BEGIN

	DELETE
        EMPLEADOS
    WHERE
        ID_EMPLEADO 	=	PAR_DELETE_EMPLEADO;

	END PRO_DELETE_EMPLEADO;

END PKG_CB_EMPLEADOS;