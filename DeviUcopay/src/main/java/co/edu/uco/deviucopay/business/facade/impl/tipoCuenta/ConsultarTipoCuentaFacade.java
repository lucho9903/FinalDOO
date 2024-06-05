package co.edu.uco.deviucopay.business.facade.impl.tipoCuenta;

import java.util.List;


import co.edu.uco.deviucopay.business.assembler.dto.impl.TipoCuentaAssemblerDTO;
import co.edu.uco.deviucopay.business.assembler.dto.impl.TipoIdentificacionAssemblerDTO;
import co.edu.uco.deviucopay.business.facade.FacadeWithReturn;
import co.edu.uco.deviucopay.business.usecase.impl.tipoCuenta.ConsultarTipoCuentas;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.dto.TipoCuentaDTO;

public class ConsultarTipoCuentaFacade implements FacadeWithReturn<TipoCuentaDTO, List<TipoCuentaDTO>>  {
	
	private DAOFactory daoFactory;

	public ConsultarTipoCuentaFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public List<TipoCuentaDTO> execute(final TipoCuentaDTO dto) {

		try {
			var usecase = new ConsultarTipoCuentas(daoFactory);
			var tipoCuentaDomain = TipoCuentaAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = usecase.execute(tipoCuentaDomain);
			return TipoCuentaAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

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
