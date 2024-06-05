package co.edu.uco.deviucopay.business.facade.impl.tipoIdentificacion;

import java.util.List;

import co.edu.uco.deviucopay.business.assembler.dto.impl.TipoIdentificacionAssemblerDTO;
import co.edu.uco.deviucopay.business.facade.FacadeWithReturn;
import co.edu.uco.deviucopay.business.usecase.impl.tipoIdentificacione.ConsultarTipoIdentificaciones;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.dto.TipoIdentificacionDTO;

public class ConsultarTipoIdentificacionFacade implements FacadeWithReturn<TipoIdentificacionDTO, List<TipoIdentificacionDTO>> {

	private DAOFactory daoFactory;

	public ConsultarTipoIdentificacionFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public List<TipoIdentificacionDTO> execute(final TipoIdentificacionDTO dto) {

		try {
			var usecase = new ConsultarTipoIdentificaciones(daoFactory);
			var tipoIdentificacionDomain = TipoIdentificacionAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = usecase.execute(tipoIdentificacionDomain);
			return TipoIdentificacionAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

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