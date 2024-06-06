package co.edu.uco.deviucopay.business.usecase.impl.cuenta;

import co.edu.uco.deviucopay.business.assembler.entity.impl.CuentaAssemblerEntity;
import co.edu.uco.deviucopay.business.domain.CuentaDomain;
import co.edu.uco.deviucopay.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;

public class ModificarCuenta implements UseCaseWithoutReturn<CuentaDomain> {

    private DAOFactory factory;

    public ModificarCuenta(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de modificar la cuenta";
            var mensajeTecnico = "El DAOFactory para crear la cuenta llegó nulo...";
            throw new BusinessDeviUcopayException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final CuentaDomain data) {
        var cuentaEntity = CuentaAssemblerEntity.getInstance().toEntity(data);
        factory.getCuentaDAO().modificar(cuentaEntity);
    }
}
