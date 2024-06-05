package co.edu.uco.deviucopay.data.dao.factory;

import co.edu.uco.deviucopay.data.dao.entity.CuentaDAO;
import co.edu.uco.deviucopay.data.dao.entity.CarnetDAO;
import co.edu.uco.deviucopay.data.dao.entity.AfiliadoDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoCuentaDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoInstitucionDAO;
import co.edu.uco.deviucopay.data.dao.entity.InstitucionDAO;
import co.edu.uco.deviucopay.data.dao.factory.concrete.AzureSQLDAOFactory;



public interface DAOFactory {

	static DAOFactory getFactory() {
		return new AzureSQLDAOFactory();
	}

	void cerrarConexion();

	void iniciarTransaccion();

	void confirmarTransaccion();

	void cancelarTransaccion();

	CuentaDAO getCuentaDAO();

	CarnetDAO getCarnetDAO();

	AfiliadoDAO getAfiliadoDAO();
	
	InstitucionDAO getInstitucionDAO();
	
	TipoCuentaDAO getTipoCuentaDAO();
	
	TipoIdentificacionDAO getTipoIdentificacionDAO();
	
	TipoInstitucionDAO getTipoInstitucionDAO();
}
