package co.edu.uco.deviucopay.crosscutting.exceptions.customs;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.enums.Lugar;

public final class CrossCuttingDeviUcopayException extends DeviUcopayException{
	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.CROSSCUTTING;

	public CrossCuttingDeviUcopayException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public CrossCuttingDeviUcopayException(final String mensajeTecnico,final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario,lugar);
	}
	
	public CrossCuttingDeviUcopayException(final String mensajeTecnico,final String mensajeUsuario,
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, lugar, exceptionRaiz);
	}
	
}


