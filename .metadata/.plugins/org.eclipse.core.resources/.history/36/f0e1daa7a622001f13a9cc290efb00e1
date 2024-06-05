package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.entity.TipoCuentaDAO;
import co.edu.uco.deviucopay.entity.TipoCuentaEntity;

public class TipoCuentaAzureSqlDAO implements TipoCuentaDAO {

    private Connection connection;

    public TipoCuentaAzureSqlDAO(Connection connection) {
        this.connection = connection;
    }

    private Connection getConexion() {
        return connection;
    }

    @Override
    public List<TipoCuentaEntity> consultar(TipoCuentaEntity data) {
        final List<TipoCuentaEntity> tipoCuentas = new ArrayList<>();
        String sentenciasSql =
                "SELECT id, nombre, identificadorTipoCuenta " +
                "FROM tipocuenta ";

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
            if (data.getIdentificadorTipoCuenta() != null && !data.getIdentificadorTipoCuenta().isEmpty()) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "identificadorTipoCuenta LIKE ? ";
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
                if (data.getIdentificadorTipoCuenta() != null && !data.getIdentificadorTipoCuenta().isEmpty()) {
                    sentenciaSqlPreparada.setString(index++, "%" + data.getIdentificadorTipoCuenta() + "%");
                }
            }

            try (var resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    TipoCuentaEntity tipoCuenta = new TipoCuentaEntity();
                    tipoCuenta.setId((UUID) resultado.getObject("id"));
                    tipoCuenta.setNombre(resultado.getString("nombre"));
                    tipoCuenta.setIdentificadorTipoCuenta(resultado.getString("identificadorTipoCuenta"));

                    tipoCuentas.add(tipoCuenta);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las tipoCuentas por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las tipoCuentas para más detalles revise laexcepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las tipoCuentas por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las tipoCuentas para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        }

        return tipoCuentas;
    }

	@Override
	public TipoCuentaEntity obtenerPorID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
}