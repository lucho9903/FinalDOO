package co.edu.uco.deviucopay.business.usecase.impl.cuenta;

import java.util.UUID;

import co.edu.uco.deviucopay.business.assembler.entity.impl.CarnetAssemblerEntity;
import co.edu.uco.deviucopay.business.domain.CuentaDomain;
import co.edu.uco.deviucopay.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.entity.CarnetEntity;
import co.edu.uco.deviucopay.entity.CuentaEntity;

public class RegistrarCuenta implements UseCaseWithoutReturn<CuentaDomain> {
	
	private DAOFactory factory;

    public RegistrarCuenta(final DAOFactory factory){
        if(ObjectHelper.getObjectHelper().isNull(factory)){
            var mensajeUsuario = "Se ha presentado un porblema tratando de llevar a cabo el registro de una ciudad";
            var mensajeTecnico = "El DAOFactory para crear la ciudad llego nulo...";
            throw new BusinessDeviUcopayException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

	@Override
	public void execute(CuentaDomain data) {
		
		validarCuentaMismoNumeroMismoCarnet(data.getNumeroCuenta(), data.getCarnet().getId());

        
        var ciudadEntity = CuentaEntity.build().setId(generarIdentificadorCuenta()).
        		setNumeroCuenta(data.getNumeroCuenta()).setCarnet(CarnetAssemblerEntity.
        				getInstance().toEntity(data.getCarnet()));
        

        factory.getCarnetDAO().crear(ciudadEntity);	
	}
	private final UUID generarIdentificadorCuenta() {
		UUID id = UUIDHelper.generate();
		boolean existedId = true;
		while (existedId) {
			id = UUIDHelper.generate();
			var ciudadEntity = CuentaEntity.build().setId(id);
			var resultados = factory.getCuentaDAO().consultar(ciudadEntity);
			
			existedId = !resultados.isEmpty();
		}
		return id;
	}
	
	private final void validarCuentaMismoNumeroMismoCarnet(final String numeroCuenta, final UUID idCarnet) {
		var cuentaEntity = CuentaEntity.build().setNumeroCuenta(numeroCuenta).
				setCarnet(CarnetEntity.build().setId(idCarnet));
        var resultados = factory.getCuentaDAO().consultar(cuentaEntity);

        if (!resultados.isEmpty()){
            var mensajeUsuario= "Ya existe una ciudad con el nombre \"${1}\" asociado con " ;
            throw new BusinessDeviUcopayException(mensajeUsuario);

        }
		
		
	}
    
	
}