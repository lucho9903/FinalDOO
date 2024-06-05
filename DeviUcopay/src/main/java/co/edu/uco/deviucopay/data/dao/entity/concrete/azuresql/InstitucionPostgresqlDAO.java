package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviucopay.data.dao.entity.InstitucionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.InstitucionEntity;
import co.edu.uco.deviucopay.entity.TipoInstitucionEntity;

public class InstitucionPostgresqlDAO extends SqlConnection implements InstitucionDAO {
	public InstitucionPostgresqlDAO(final Connection connection) {
		super(connection);
		
	}

    

	@Override
	public List<InstitucionEntity> consultar(InstitucionEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT i.id, i.nombre, i.id as idTipo_institucion, i.nombre as nombreTipo_institucion");
		sentenciaSql.append(" FROM institucion i");
		sentenciaSql.append(" INNER JOIN tipo_institucion ti ON i.pais_id = ti.id");
		sentenciaSql.append(" WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND d.id = ?");
			parametros.add(data.getId());
		}
		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND d.nombre = ?");
			parametros.add(data.getNombre());
		}
		if (!TextHelper.isNullOrEmpty(data.getCorreo())) {
			sentenciaSql.append(" AND d.nombre = ?");
			parametros.add(data.getCorreo());
		}
		if (!ObjectHelper.getObjectHelper().isNull(data.getTipoInstitucion())
				&& !ObjectHelper.getObjectHelper().isNull(data.getTipoInstitucion().getId())
				&& !data.getTipoInstitucion().getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND d.pais_id = ?");
			parametros.add(data.getTipoInstitucion().getId());
		}

		final List<InstitucionEntity> Institucions = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					InstitucionEntity Institucion = InstitucionEntity.build();
					Institucion.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
					Institucion.setNombre(resultado.getString("nombre"));

					TipoInstitucionEntity tipoInstitucion = TipoInstitucionEntity.build();
					tipoInstitucion.setId(UUIDHelper.convertToUUID(resultado.getString("idPais")));
					tipoInstitucion.setNombre(resultado.getString("nombrePais"));

					Institucion.setTipoInstitucion(tipoInstitucion);

					Institucions.add(Institucion);
				}
			}

		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00049);
			throw new DataDeviUcopayException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {
			var mensajeUsuario =  MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00049);
			throw new DataDeviUcopayException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return Institucions;
	}

}
