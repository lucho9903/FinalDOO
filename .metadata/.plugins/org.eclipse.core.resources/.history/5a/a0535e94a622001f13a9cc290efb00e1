package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.entity.CarnetDAO;
import co.edu.uco.deviucopay.entity.CarnetEntity;
import co.edu.uco.deviucopay.data.dao.entity.concrete.*;


public class CarnetAzureSqlDAO extends SqlConnection implements CarnetDAO {
	
	public CarnetAzureSqlDAO(final Connection connection) {
		super(connection);
		
	}

	@Override
	public final List<CarnetEntity> consultar(final CarnetEntity data) {
        final List<CarnetEntity> Carnets = new ArrayList<>();
        String sentenciasSql =
                "SELECT id, nombre" +
                "FROM tipoinstitucion ";

        if (data != null) {
            boolean whereAdded = false;
            if (data.getId() != null) {
                sentenciasSql += "WHERE id = ? ";
                whereAdded = true;
            }
            if (data.getNumeroCarnet() != null && !data.getNumeroCarnet().isEmpty()) {
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
                if (data.getNumeroCarnet() != null && !data.getNumeroCarnet().isEmpty()) {
                    sentenciaSqlPreparada.setString(index++, "%" + data.getNumeroCarnet() + "%");
                }
               
            }

            try (var resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    CarnetEntity tipoInstitucion = new CarnetEntity();
                    tipoInstitucion.setId((UUID) resultado.getObject("id"));
                    tipoInstitucion.setNumeroCarnet(resultado.getString("nombre"));

                    Carnets.add(tipoInstitucion);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las Carnets por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las Carnets para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las Carnets por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las Carnets para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        }

        return Carnets;
    }

	

}