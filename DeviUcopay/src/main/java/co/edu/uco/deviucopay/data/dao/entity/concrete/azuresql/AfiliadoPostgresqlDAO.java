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
        sentenciaSql.append("SELECT a.id, a.numero_id_afiliado, a.nombre, a.correo, a.telefono, ");
        sentenciaSql.append("tid.id AS tipo_identificacion_id, tid.nombre AS tipo_identificacion_nombre, ");
        sentenciaSql.append("i.id AS institucion_id, i.nombre AS institucion_nombre ");
        sentenciaSql.append("FROM afiliado a ");
        sentenciaSql.append("INNER JOIN tipo_identificacion tid ON a.tipo_identificacion_id = tid.id ");
        sentenciaSql.append("LEFT JOIN institucion i ON a.institucion_id = i.id ");
        sentenciaSql.append("WHERE 1=1");

        final List<Object> parametros = new ArrayList<>();

        if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND a.id = ?");
            parametros.add(data.getId());
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

        final List<AfiliadoEntity> afiliados = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    AfiliadoEntity afiliado = new AfiliadoEntity();
                    afiliado.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
                    afiliado.setNombre(resultado.getString("nombre"));
                    afiliado.setCorreo(resultado.getString("correo"));
                    afiliado.setTelefono(resultado.getString("telefono"));

                    InstitucionEntity institucion = InstitucionEntity.build();
                    institucion.setId(UUIDHelper.convertToUUID(resultado.getString("institucion_id")));
                    institucion.setNombre(resultado.getString("institucion_nombre"));
                    afiliado.setInstitucion(institucion);

                    TipoIdentificacionEntity tipoIdentificacion = TipoIdentificacionEntity.build();
                    tipoIdentificacion.setId(UUIDHelper.convertToUUID(resultado.getString("tipo_identificacion_id")));
                    tipoIdentificacion.setNombre(resultado.getString("tipo_identificacion_nombre"));
                    afiliado.setTipoIdentificacion(tipoIdentificacion);

                    afiliados.add(afiliado);
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

        return afiliados;
    }
}
