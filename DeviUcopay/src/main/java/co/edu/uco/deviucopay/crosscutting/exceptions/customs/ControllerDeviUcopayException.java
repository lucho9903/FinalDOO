package co.edu.uco.deviucopay.crosscutting.exceptions.customs;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.enums.Lugar;

public final class ControllerDeviUcopayException extends DeviUcopayException{
	private static final long serialVersionUID = 2325104002394078932L;

	public ControllerDeviUcopayException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CRONTROLLER);
	}
	
	public ControllerDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CRONTROLLER);
	}
	
	public ControllerDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario, final Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CRONTROLLER, exeptionRaiz);
	}

}

