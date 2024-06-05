package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.ResultSet;

import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviucopay.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.TipoIdentificacionEntity;

public class TipoIdentificacionPostgresqlDAO extends SqlConnection implements TipoIdentificacionDAO {

	public TipoIdentificacionPostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<TipoIdentificacionEntity> consultar(TipoIdentificacionEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT ts.id, ts.nombre");
		sentenciaSql.append(" FROM tipoIdentificacion ts");
		sentenciaSql.append(" WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND ts.id = ?");
			parametros.add(data.getId());
		}
		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND ts.nombre = ?");
			parametros.add(data.getNombre());
		}

		final List<TipoIdentificacionEntity> tiposIdentificacion = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					TipoIdentificacionEntity tipoIdentificacion = TipoIdentificacionEntity.build();
					tipoIdentificacion.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
					tipoIdentificacion.setNombre(resultado.getString("nombre"));

					tiposIdentificacion.add(tipoIdentificacion);
				}
			}

		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00033);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00054);
			throw new DataDeviUcopayException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00033);
			var mensajeTecnico =MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00054);
			throw new DataDeviUcopayException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return tiposIdentificacion;
	}

}
