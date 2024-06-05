package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.entity.TipoInstitucionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.TipoInstitucionEntity;

public class TipoInstitucionAzuereSqlDAO extends SqlConnection implements TipoInstitucionDAO {

	public TipoInstitucionAzuereSqlDAO(final Connection connection) {
		super(connection);
		
	}

	@Override
    public final List<TipoInstitucionEntity> consultar(final TipoInstitucionEntity data) {
        final List<TipoInstitucionEntity> tipoInstituciones = new ArrayList<>();
        String sentenciasSql =
                "SELECT id, nombre" +
                "FROM tipoinstitucion ";

        if (data != null) {
            boolean whereAdded = false;
            if (data.getId() != null) {
                sentenciasSql += "WHERE id = ? ";
                whereAdded = true;
            }
            if (data.getNombre() != null && !data.getNombre().isEmpty()) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "nombre LIKE ? ";
                whereAdded = true;
            }
    
        }

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql)) {

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
                    TipoInstitucionEntity tipoInstitucion = new TipoInstitucionEntity();
                    tipoInstitucion.setId((UUID) resultado.getObject("id"));
                    tipoInstitucion.setNombre(resultado.getString("nombre"));

                    tipoInstituciones.add(tipoInstitucion);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las tipoInstituciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las tipoInstituciones para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las tipoInstituciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las tipoInstituciones para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        }

        return tipoInstituciones;
    }

}