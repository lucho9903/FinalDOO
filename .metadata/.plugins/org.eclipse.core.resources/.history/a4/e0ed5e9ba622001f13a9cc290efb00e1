package co.edu.uco.deviucopay.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.DataDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.entity.AfiliadoDAO;
import co.edu.uco.deviucopay.data.dao.entity.CuentaDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoCuentaDAO;
import co.edu.uco.deviucopay.data.dao.entity.TipoIdentificacionDAO;
import co.edu.uco.deviucopay.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.deviucopay.entity.AfiliadoEntity;
import co.edu.uco.deviucopay.entity.CuentaEntity;
import co.edu.uco.deviucopay.entity.TipoCuentaEntity;

public class CuentaAzureSqlDAO extends SqlConnection implements CuentaDAO{
	private final TipoCuentaDAO tipoCuentaDAO;
	
	public CuentaAzureSqlDAO(final Connection connection, final TipoCuentaDAO tipoCuentaDAO) {
		super(connection);
		this.tipoCuentaDAO = tipoCuentaDAO;
	}

	@Override
	public final void crear(final CuentaEntity data) {
        final StringBuilder sentenciasSql = new StringBuilder();

        sentenciasSql.append("INSERT INTO cuenta (id, nombre, departamento) ");
        sentenciasSql.append("VALUES (?, ?, ?, ?, ?, ?)");

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql.toString())) {
        	sentenciaSqlPreparada.setObject(1, data.getId());
            sentenciaSqlPreparada.setString(2, data.getNumeroCuenta());
            sentenciaSqlPreparada.setObject(3, data.getContraseña());
            sentenciaSqlPreparada.setObject(4, data.getSaldo());
            sentenciaSqlPreparada.setObject(5, data.getTipoCuenta().getId());
            sentenciaSqlPreparada.setObject(6, data.getAfiliado().getId());
       

            sentenciaSqlPreparada.executeUpdate();

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de crear la cuenta  por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar el INSERT de la cuenta para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de crear la cuenta  por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el INSERT de la cuenta  para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

	@Override
	public void modificar(CuentaEntity data) {
		 final StringBuilder sentenciasSql = new StringBuilder();

	        sentenciasSql.append("UPDATE cuenta ");
	        sentenciasSql.append("SET contraseña = ?");
	        sentenciasSql.append("WHERE id = ?");

	        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql.toString())) {

	            sentenciaSqlPreparada.setString(1, data.getContraseña());
	            

	            sentenciaSqlPreparada.executeUpdate();

	        } catch (final SQLException exception) {
	            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la cuenta por favor intente de nuevo y si el problema persiste contacte al administrador...";
	            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar el UPDATE de la cuenta para más detalles revise la excepción raíz presentada..";

	            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
	        } catch (final Exception exception) {
	            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la cuenta  por favor intente de nuevo y si el problema persiste contacte al administrador...";
	            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el UPDATE de la cuenta  para más detalles revise la excepción raíz presentada..";

	            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
	        }
	}

	@Override
	public List<CuentaEntity> consultar(CuentaEntity data) {
	    final List<CuentaEntity> cuentas = new ArrayList<>();
        String sentenciasSql =
                "SELECT id, numero_cuenta, tipo_cuenta, afiliado" +
                "FROM cuenta ";

        if (data != null) {
            boolean whereAdded = false;
            if (data.getId() != null) {
                sentenciasSql += "WHERE id = ? ";
                whereAdded = true;
            }
            if (data.getNumeroCuenta() != null && !data.getNumeroCuenta().isEmpty()) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "nombre LIKE ? ";
                whereAdded = true;
            }
            if (data.getAfiliado() != null && data.getAfiliado().getId() != null) {
                sentenciasSql += (whereAdded ? "AND " : "WHERE ") + "afiliado = ? ";
            }
        }

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql)) {

            int index = 1;
            if (data != null) {
                if (data.getId() != null) {
                    sentenciaSqlPreparada.setObject(index++, data.getId());
                }
                if (data.getNumeroCuenta() != null && !data.getNumeroCuenta().isEmpty()) {
                    sentenciaSqlPreparada.setString(index++, "%" + data.getNumeroCuenta() + "%");
                }
                if (data.getAfiliado() != null && data.getAfiliado().getId() != null) {
                    sentenciaSqlPreparada.setObject(index++, data.getAfiliado().getId());
                }
            }

            try (var resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    CuentaEntity cuenta = new CuentaEntity();
                    cuenta.setId((UUID) resultado.getObject("id"));
                    cuenta.setNumeroCuenta(resultado.getString("numero_cuenta"));

                    UUID tipoCuentaId = (UUID) resultado.getObject("tipo_cuenta");
                    TipoCuentaEntity tipoCuenta = tipoCuentaDAO.obtenerPorID(tipoCuentaId);

                    cuenta.setTipoCuenta(tipoCuenta);

                    cuentas.add(cuenta);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las cuentas por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar la consulta de las cuentas para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar las cuentas por favor intente de nuevo y si el problema persiste contacte al administrador...";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las cuentas para más detalles revise la excepción raíz presentada..";

            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        }

        return cuentas;
    }

	@Override
	public void eliminar (final UUID id) {
		 final StringBuilder sentenciasSql = new StringBuilder();

	     sentenciasSql.append("DELETE FROM cuenta ");
	     sentenciasSql.append("WHERE id = ?");

	        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql.toString())) {

	            sentenciaSqlPreparada.setObject(1, id);

	            sentenciaSqlPreparada.executeUpdate();

	        } catch (final SQLException exception) {
	            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la cuenta con ID  por favor intente de nuevo y si el problema persiste contacte al administrador...";
	            var mensajeTecnico = "Se ha presentado una excepción de tipo SQLException tratando de realizar el DELETE de la cuenta con ID  para más detalles revise la excepción raíz presentada..";

	            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
	        } catch (final Exception exception) {
	            var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la cuenta con ID por favor intente de nuevo y si el problema persiste contacte al administrador...";
	            var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el DELETE de la cuenta con ID  para más detalles revise la excepción raíz presentada..";

	            throw new DataDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
	        }
	    }


}