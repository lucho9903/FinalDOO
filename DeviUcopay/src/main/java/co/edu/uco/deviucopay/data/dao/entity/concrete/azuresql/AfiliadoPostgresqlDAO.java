package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviucopay.data.dao.entity.AfiliadoDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.AfiliadoEntity;
import co.edu.uco.deviucopay.entity.InstitucionEntity;
import co.edu.uco.deviucopay.entity.TipoIdentificacionEntity;

public class AfiliadoPostgresqlDAO extends SqlConnection implements AfiliadoDAO {
	public AfiliadoPostgresqlDAO(final Connection conexion) {
		super(conexion);
	}

	
	@Override
	public List<AfiliadoEntity> consultar(AfiliadoEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("select a.id, a.nombreAfiliado, a.direccion, a.correoelectronico, a.celdascarro,");
		sentenciaSql.append(" s.celdamoto, s.caldascamion, c.id as idCiudad,");
		sentenciaSql.append(" c.nombre as nombreciudad, d.id as idDepartamento,");
		sentenciaSql.append(" d.nombre as nombredepartamento, p.id as idPais,");
		sentenciaSql.append(" p.nombre as nombrepais, par.id as idParqueadero, ");
		sentenciaSql.append(" par.nombre as nombreparqueadero, t.id as idTipoAfiliado, t.nombre as tipoAfiliado");
		sentenciaSql.append(" from Afiliado s");
		sentenciaSql.append(" inner join ciudad c on c.id = s.ciudad_id");
		sentenciaSql.append(" inner join departamento d on d.id = c.departamento_id");
		sentenciaSql.append(" inner join pais p on p.id = d.pais_id");
		sentenciaSql.append(" inner join parqueadero par on par.id = s.parqueadero_id");
		sentenciaSql.append(" inner join tipoAfiliado t on t.id = s.tipoAfiliado_id");
		sentenciaSql.append(" WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND a.id = ?");
			parametros.add(data.getId());
		}

		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND a.numeroIdAfiliado = ?");
			parametros.add(data.getNombre());
		}

		

		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND a.nombre = ?");
			parametros.add(data.getNombre());
		}
		
		if (!TextHelper.isNullOrEmpty(data.getCorreo())) {
			sentenciaSql.append(" AND a.correo = ?");
			parametros.add(data.getCorreo());
		}
		if (!TextHelper.isNullOrEmpty(data.getTelefono())) {
			sentenciaSql.append(" AND a.telefono = ?");
			parametros.add(data.getTelefono());
		}

		if (!ObjectHelper.getObjectHelper().isNull(data.getTipoIdentificacion())
				&& !ObjectHelper.getObjectHelper().isNull(data.getTipoIdentificacion().getId())
				&& !data.getTipoIdentificacion().getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND tid.id = ?");
			parametros.add(data.getTipoIdentificacion().getId());
		}
		if (!ObjectHelper.getObjectHelper().isNull(data.getInstitucion())
				&& !ObjectHelper.getObjectHelper().isNull(data.getInstitucion().getId())
				&& !data.getInstitucion().getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND i.id = ?");
			parametros.add(data.getInstitucion().getId());
		}

		final List<AfiliadoEntity> Afiliados = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					AfiliadoEntity Afiliado = new AfiliadoEntity();
					Afiliado.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
					Afiliado.setNombre(resultado.getString("nombre"));
					Afiliado.setCorreo(resultado.getString("correo"));
					Afiliado.setTelefono(resultado.getString("telefono"));
					
					InstitucionEntity institucion = InstitucionEntity.build();
					institucion.setId(UUIDHelper.convertToUUID(resultado.getString("idInstitucion")));
					Afiliado.setInstitucion(institucion );

					TipoIdentificacionEntity tipoInstitucion = TipoIdentificacionEntity.build();
					tipoInstitucion.setId(UUIDHelper.convertToUUID(resultado.getString("idTipoInstitucion")));
					Afiliado.setTipoIdentificacion(tipoInstitucion);

					Afiliados.add(Afiliado);
				}
			}

		} catch (SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			throw new DataDeviUcopayException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			throw new DataDeviUcopayException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return Afiliados;
	}

}
