package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.entity.InstitucionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.InstitucionEntity;
import co.edu.uco.deviucopay.entity.TipoInstitucionEntity;

public class InstitucionAzuereSqlDAO extends SqlConnection implements InstitucionDAO {
	public InstitucionAzuereSqlDAO(final Connection connection) {
		super(connection);
		
	}

    

    @Override
    public List<InstitucionEntity> consultar(InstitucionEntity data) {
        final List<InstitucionEntity> instituciones = new ArrayList<>();
        String sentenciasSql =
                "SELECT i.id, i.nombre, i.tipo_institucion, i.correo, ti.id, ti.nombre" +
                "FROM institucion i" +
                "INNER JOIN tipo_institucion ti ON i.tipo_institucion = ti.id";

        if (data!= null) {
            boolean whereAdded = false;
            if (data.getId()!= null) {
                sentenciasSql += "WHERE i.id =? ";
                whereAdded = true;
            }
            if (data.getNombre()!= null &&!data.getNombre().isEmpty()) {
                sentenciasSql += (whereAdded? "AND " : "WHERE ") + "i.nombre LIKE? ";
                whereAdded = true;
            }
            if (data.getTipoInstitucion()!= null && data.getTipoInstitucion().getId()!= null) {
                sentenciasSql += (whereAdded? "AND " : "WHERE ") + "ti.id =? ";
            }
            if (data.getCorreo()!= null &&!data.getCorreo().isEmpty()) {
                sentenciasSql += (whereAdded? "AND " : "WHERE ") + "i.correo LIKE? ";
            }
        }

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql)) {

            int index = 1;
            if (data!= null) {
                if (data.getId()!= null) {
                    sentenciaSqlPreparada.setObject(index++, data.getId());
                }
                if (data.getNombre()!= null &&!data.getNombre().isEmpty()) {
                    sentenciaSqlPreparada.setString(index++, "%" + data.getNombre() + "%");
                }
                if (data.getTipoInstitucion()!= null && data.getTipoInstitucion().getId()!= null) {
                    sentenciaSqlPreparada.setObject(index++, data.getTipoInstitucion().getId());
                }
                if (data.getCorreo()!= null &&!data.getCorreo().isEmpty()) {
                    sentenciaSqlPreparada.setString(index++, "%" + data.getCorreo() + "%");
                }
            }

            try (var resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    InstitucionEntity institucion = new InstitucionEntity();
                    institucion.setId((UUID) resultado.getObject("id"));
                    institucion.setNombre(resultado.getString("nombre"));
                    institucion.setCorreo(resultado.getString("correo"));

                    TipoInstitucionEntity tipoInstitucion = new TipoInstitucionEntity();
                    tipoInstitucion.setId((UUID) resultado.getObject("ti.id"));
                    tipoInstitucion.setNombre(resultado.getString("ti.nombre"));
                    institucion.setTipoInstitucion(tipoInstitucion);

                    instituciones.add(institucion);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las instituciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las instituciones para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las instituciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta delas instituciones, revise el log para obtener más detalles y si el problema persiste contacte al administrador.";

            System.err.println(mensajeTecnico);
            System.err.println(exception.getMessage());
            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario);
        }

        return instituciones;
    }

    public List<InstitucionEntity> obtenerInstituciones(final Integer offset, final Integer limit) throws DataDeviUcopayException {
        final List<InstitucionEntity> instituciones = new ArrayList<>();

        final String sentenciasSql = "SELECT i.id, i.nombre, i.tipo_institucion, i.correo, ti.id, ti.nombre" +
                "FROM institucion i" +
                "INNER JOIN tipo_institucion ti ON i.tipo_institucion = ti.id" +
                "LIMIT? OFFSET?";

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql)) {
            sentenciaSqlPreparada.setObject(1, limit);
            sentenciaSqlPreparada.setObject(2, offset);

            try (var resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    InstitucionEntity institucion = new InstitucionEntity();
                    institucion.setId((UUID) resultado.getObject("id"));
                    institucion.setNombre(resultado.getString("nombre"));
                    institucion.setCorreo(resultado.getString("correo"));

                    TipoInstitucionEntity tipoInstitucion = new TipoInstitucionEntity();
                    tipoInstitucion.setId((UUID) resultado.getObject("ti.id"));
                    tipoInstitucion.setNombre(resultado.getString("ti.nombre"));
                    institucion.setTipoInstitucion(tipoInstitucion);

                    instituciones.add(institucion);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las instituciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las instituciones para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las instituciones por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las instituciones, revise el log para obtener más detalles y si el problema persiste contacte al administrador.";

            System.err.println(mensajeTecnico);
            System.err.println(exception.getMessage());
            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario);
        }

        return instituciones;
    }

}