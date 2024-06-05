package co.edu.uco.deviucopay.business.facade.impl.afiliado;

import java.util.List;

import co.edu.uco.deviucopay.business.assembler.dto.impl.AfiliadoAssemblerDTO;
import co.edu.uco.deviucopay.business.facade.FacadeWithReturn;
import co.edu.uco.deviucopay.business.usecase.impl.afiliado.ConsultarAfiliados;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.dto.AfiliadoDTO;

public class ConsultarAfiliadoFacade implements FacadeWithReturn<AfiliadoDTO, List<AfiliadoDTO>> {
	private DAOFactory daoFactory;

	public ConsultarAfiliadoFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public List<AfiliadoDTO> execute(final AfiliadoDTO dto) {

		try {
			var usecase = new ConsultarAfiliados(daoFactory);
			var AfiliadoDomain = AfiliadoAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = usecase.execute(AfiliadoDomain);
			return AfiliadoAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

		} catch (final DeviUcopayException exception) {
			throw exception;
		} catch (final Exception exception) {

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);
			
			throw new BusinessDeviUcopayException(mensajeTecnico, mensajeUsuario, exception);

		} finally {
			daoFactory.cerrarConexion();
		}
	}


}
