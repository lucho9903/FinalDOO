package co.edu.uco.deviucopay.crosscutting.exceptions.customs;

import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.enums.Lugar;

public final class DtoDeviUcopayException extends DeviUcopayException {
	private static final long serialVersionUID = 2325104002394078932L;

	public DtoDeviUcopayException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DTO);
	}
	
	public DtoDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DTO);
	}
	
	public DtoDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario, final Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DTO, exeptionRaiz);
	}

}