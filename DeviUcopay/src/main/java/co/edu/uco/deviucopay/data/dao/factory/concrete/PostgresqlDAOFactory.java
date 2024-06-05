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
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.AfiliadoPostgresqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.CarnetPostgresqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.CuentaPostgresqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.InstitucionPostgresqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.TipoCuentaPostgresqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.TipoIdentificacionPostgresqlDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql.TipoInstitucionPostgresqlDAO;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.dto.TipoIdentificacionDTO;

public final class PostgresqlDAOFactory extends SqlConnection implements DAOFactory {

	public PostgresqlDAOFactory() {
		super();
		abrirConexion();
	}

	private void abrirConexion() {
		final String connectionUrl = "jdbc:postgresql://localhost:5433/DOO?user=postgres&password=000";
		try {
			setConexion(DriverManager.getConnection(connectionUrl));
		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);

			throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);

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
		return new CuentaPostgresqlDAO(getConexion());
	}

	@Override
	public CarnetDAO getCarnetDAO() {
		return new CarnetPostgresqlDAO(getConexion());
	}

	@Override
	public AfiliadoDAO getAfiliadoDAO() {
		return new AfiliadoPostgresqlDAO(getConexion());
	}

	@Override
	public InstitucionDAO getInstitucionDAO() {
		return new InstitucionPostgresqlDAO(getConexion());
	}

	@Override
	public TipoCuentaDAO getTipoCuentaDAO() {
		return new TipoCuentaPostgresqlDAO(getConexion());
	}

	@Override
	public TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return new TipoIdentificacionPostgresqlDAO(getConexion());
	}

	@Override
	public TipoInstitucionDAO getTipoInstitucionDAO() {
		return new TipoInstitucionPostgresqlDAO(getConexion());
	}

}
