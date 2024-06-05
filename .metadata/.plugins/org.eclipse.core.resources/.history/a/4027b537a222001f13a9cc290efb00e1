package co.edu.uco.deviucopay.data.dao.factory.concrete;

import java.sql.DriverManager;

import java.sql.SQLException;

import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.crosscutting.helpers.SQLHelper;
import co.edu.uco.deviucopay.data.dao.entity.AfiliadoDAO;
import co.edu.uco.deviucopay.data.dao.entity.CarnetDAO;
import co.edu.uco.deviucopay.data.dao.entity.CuentaDAO;
import co.edu.uco.deviucopay.data.dao.entity.InstitucionDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoCuentaDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoInstitucionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.AfiliadoAzureSqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.CarnetAzureSqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.InstitucionAzuereSqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.TipoCuentaAzureSqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.TipoIdentificacionAzureSqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.TipoInstitucionAzuereSqlDAO;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.CuentaAzureSqlDAO;

public final class AzureSQLDAOFactory extends SqlConnection implements DAOFactory {

	public AzureSQLDAOFactory() {
		super();
		abrirConexion();
	}

	private void abrirConexion() {
		final String connectionUrl = "jdbc:sqlserver://wednesday.database.windows.net:1433;databaseName=friday;user=fridayDmlUser;password=fr1d4yus3r!";
		try {
			setConexion(DriverManager.getConnection(connectionUrl));
		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, excepcion);
		}
	}

	@Override
	public void cerrarConexion() {
		SQLHelper.close(getConexion());
	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(getConexion());
	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(getConexion());
	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(getConexion());
	}

	@Override
	public CuentaDAO getCuentaDAO() {
		// TODO Auto-generated method stub
		return new CuentaAzureSqlDAO(getConexion(),getTipoCuentaDAO());
	}

	@Override
	public CarnetDAO getCarnetDAO() {
		// TODO Auto-generated method stub
		return new CarnetAzureSqlDAO(getConexion());
	}

	@Override
	public AfiliadoDAO getAfiliadoDAO() {
		return new AfiliadoAzureSqlDAO(getConexion(),getTipoIdentificacionDAO());
	}

	@Override
	public InstitucionDAO getInstitucionDAO() {
		return new InstitucionAzuereSqlDAO(getConexion());
	}

	@Override
	public TipoCuentaDAO getTipoCuentaDAO() {
		return new TipoCuentaAzureSqlDAO(getConexion());
	}

	@Override
	public TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return new TipoIdentificacionAzureSqlDAO(getConexion());
	}

	@Override
	public TipoInstitucionDAO getTipoInstitucionDAO() {
		return new TipoInstitucionAzuereSqlDAO(getConexion());
	}
	
}

