package co.edu.uco.deviucopay.crosscutting.exceptions.customs;

import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.enums.Lugar;

public final class EntityDeviUcopayException extends DeviUcopayException{
	private static final long serialVersionUID = -3662331984905572117L;

	public EntityDeviUcopayException(final String mensajeUsuario , Lugar lugar) {
		super(mensajeUsuario, Lugar.ENTITY);
	}
	
	public EntityDeviUcopayException(final String mensajeTecnico,final String mensajeUsuario, 
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.ENTITY, exceptionRaiz);
	}
	
	
}
