package co.edu.uco.deviucopay.business.facade.impl.institucion;

import java.util.List;

import co.edu.uco.deviucopay.business.assembler.dto.impl.InstitucionAssemblerDTO;
import co.edu.uco.deviucopay.business.facade.FacadeWithReturn;
import co.edu.uco.deviucopay.business.usecase.impl.institucion.ConsultarInstituciones;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.dto.InstitucionDTO;

public class ConsultarInstitucionFacade implements FacadeWithReturn<InstitucionDTO, List<InstitucionDTO>> {

    private DAOFactory daoFactory;

    public ConsultarInstitucionFacade() {
        this.daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<InstitucionDTO> execute(InstitucionDTO dto) {
        try {
            var useCase = new ConsultarInstituciones(daoFactory);
            var InstitucionDomain = InstitucionAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = useCase.execute(InstitucionDomain);
            return InstitucionAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);
        } catch (DeviUcopayException exception) {
            throw exception;
        } catch (Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema al consultar la información de los tipos de Cuenta.";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar los tipos de Cuenta.";
            throw new BusinessDeviUcopayException(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}