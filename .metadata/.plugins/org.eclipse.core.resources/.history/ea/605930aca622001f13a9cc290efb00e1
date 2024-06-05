package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.TipoIdentificacionEntity;

public class TipoIdentificacionAzureSqlDAO extends SqlConnection implements TipoIdentificacionDAO {

    private Connection connection;

    public TipoIdentificacionAzureSqlDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity data) {
    
        final List<TipoIdentificacionEntity> tipoIdentificaciones = new ArrayList<>();
        String sentenciaSql = "SELECT id, nombre FROM tipoinstitucion WHERE 1 = 1";

        if (data != null) {
            if (data.getId() != null) {
                sentenciaSql += " AND id = :id";
            }
            if (data.getNombre() != null && !data.getNombre().isEmpty()) {
                sentenciaSql += " AND nombre LIKE :nombre";
            }
        }

        try (PreparedStatement sentenciaSqlPreparada = connection.prepareStatement(sentenciaSql)) {

            int index = 1;
            if (data != null) {
                if (data.getId() != null) {
                    sentenciaSqlPreparada.setObject(index++, data.getId());
                }
                if (data.getNombre() != null && !data.getNombre().isEmpty()) {
                    sentenciaSqlPreparada.setString(index++, "%" + data.getNombre() + "%");
                }
            }

            try (var resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    TipoIdentificacionEntity tipoIdentificacion = new TipoIdentificacionEntity();
                    tipoIdentificacion.setId((UUID) resultado.getObject("id"));
                    tipoIdentificacion.setNombre(resultado.getString("nombre"));

                    tipoIdentificaciones.add(tipoIdentificacion);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las tipoIdentificaciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las tipoIdentificaciones para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las tipoIdentificaciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las tipoIdentificaciones para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        }

        return tipoIdentificaciones;
    }

	@Override
	public TipoIdentificacionEntity obtenerPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}