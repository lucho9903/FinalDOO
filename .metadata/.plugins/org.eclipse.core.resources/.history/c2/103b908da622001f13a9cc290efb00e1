package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.entity.AfiliadoDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.AfiliadoEntity;
import co.edu.uco.deviucopay.entity.TipoIdentificacionEntity;

public class AfiliadoAzureSqlDAO extends SqlConnection implements AfiliadoDAO {
	private final TipoIdentificacionDAO tipoIdentificacionDAO;
	
	
	
	public AfiliadoAzureSqlDAO(final Connection connection, final TipoIdentificacionDAO tipoIdentificacionDAO) {
		super(connection);
		this.tipoIdentificacionDAO = tipoIdentificacionDAO;
	}
	
	
	@Override
	public final List<AfiliadoEntity> consultar(final AfiliadoEntity data) {
        final List<AfiliadoEntity> afiliados = new ArrayList<>();
        String sentenciasSql =
                "SELECT id, nombre, numero_afiliado, telefono, correo, tipo_identificacion, institucion, carnet " +
                "FROM afiliado ";

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
            if (data.getNumeroIdAfiliado() != null && data.getNumeroIdAfiliado().isEmpty()) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "numero_afiliado LIKE = ? ";
                whereAdded = true;
            }
            if (data.getTelefono() != null && data.getTelefono().isEmpty()) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "telefono LIKE = ? ";
                whereAdded = true;
            }
            
            if (data.getCorreo() != null && data.getCorreo().isEmpty()) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "correo LIKE = ? ";
                whereAdded = true;
            }
            if (data.getInstitucion() != null && data.getInstitucion().getId() != null) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "institucion = ? ";
                whereAdded = true;
            }
            
            if (data.getCarnet() != null && data.getCarnet().getId() != null) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "carnet = ? ";
                whereAdded = true;
            }
            if (data.getTipoIdentificacion() != null && data.getTipoIdentificacion().getId() != null) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "tipo_identificacion = ? ";
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
                    AfiliadoEntity afiliado = new AfiliadoEntity();
                    afiliado.setId((UUID) resultado.getObject("id"));
                    afiliado.setNombre(resultado.getString("nombre"));
                    afiliado.setNumeroIdAfiliado(resultado.getString("numero_afiliado"));
                    afiliado.setTelefono(resultado.getString("telefono"));
                    afiliado.setCorreo(resultado.getString("correo"));
                    
                    UUID tipoIdentificacionId = (UUID) resultado.getObject("tipo_identificacion");
                    TipoIdentificacionEntity tipoIdentificacion = tipoIdentificacionDAO.obtenerPorId(tipoIdentificacionId);
                    afiliado.setTipoIdentificacion(tipoIdentificacion);
;

                    afiliados.add(afiliado);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las afiliados por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las afiliados para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las afiliados por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las afiliados para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        }

        return afiliados;
    }

	

}