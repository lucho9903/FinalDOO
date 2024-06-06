package co.edu.uco.deviucopay.business.facade.impl.cuenta;

import co.edu.uco.deviucopay.business.assembler.dto.impl.CuentaAssemblerDTO;
import co.edu.uco.deviucopay.business.facade.FacadeWithoutReturn;
import co.edu.uco.deviucopay.business.usecase.impl.cuenta.ModificarCuenta;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.dto.CuentaDTO;

public class ModificarCuentaFacade implements FacadeWithoutReturn<CuentaDTO> {

    private DAOFactory daoFactory;

    public ModificarCuentaFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public void excute(final CuentaDTO dto) {
        try {
            var usecase = new ModificarCuenta(daoFactory);
            var cuentaDomain = CuentaAssemblerDTO.getInstance().toDomain(dto);
            usecase.execute(cuentaDomain);
        } catch (final DeviUcopayException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema modificando la cuenta";
            var mensajeTecnico = "Se ha presentado un problema inesperado tratando de modificar la cuenta";
            throw new BusinessDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
