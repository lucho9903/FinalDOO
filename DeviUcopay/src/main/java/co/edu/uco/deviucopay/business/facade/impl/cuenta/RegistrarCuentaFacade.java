package co.edu.uco.deviucopay.business.facade.impl.cuenta;

import co.edu.uco.deviucopay.business.assembler.dto.impl.CuentaAssemblerDTO;
import co.edu.uco.deviucopay.business.facade.FacadeWithoutReturn;
import co.edu.uco.deviucopay.business.usecase.impl.cuenta.RegistrarCuenta;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.dto.CuentaDTO;

public class RegistrarCuentaFacade implements FacadeWithoutReturn<CuentaDTO>{
	
	private DAOFactory daoFactory;
	
	public RegistrarCuentaFacade() {
		daoFactory = DAOFactory.getFactory();
		
	}
	
	

	@Override
	public void excute(final CuentaDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			var useCase= new RegistrarCuenta(daoFactory);
			var cuentaDomain = CuentaAssemblerDTO.getInstance().toDomain(dto);
			
			useCase.execute(cuentaDomain);
			
		}catch (final DeviUcopayException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
			
		}catch (final Exception exception) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion de la ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la informacion de la Ciudad";
			
			throw new BusinessDeviUcopayException(mensajeUsuario, mensajeTecnico, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
		
	}

	
}