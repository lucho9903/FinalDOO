package co.edu.uco.deviucopay.crosscutting.exceptions.customs;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.enums.Lugar;

public final class BusinessDeviUcopayException extends DeviUcopayException{
	
	private static final long serialVersionUID = -3662331984905572117L;
	private static final Lugar lugar = Lugar.BUSINNES;

	public BusinessDeviUcopayException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }
    public BusinessDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }

    public BusinessDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
    }
}