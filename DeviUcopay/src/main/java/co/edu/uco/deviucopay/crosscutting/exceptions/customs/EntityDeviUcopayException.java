package co.edu.uco.deviucopay.crosscutting.exceptions.customs;

import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.enums.Lugar;

public final class EntityDeviUcopayException extends DeviUcopayException{
	private static final long serialVersionUID = 2325104002394078932L;

	public EntityDeviUcopayException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.ENTITY);
	}
	
	public EntityDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.ENTITY);
	}
	
	public EntityDeviUcopayException(final String mensajeTecnico, final String mensajeUsuario, final Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.ENTITY, exeptionRaiz);
	}

}
