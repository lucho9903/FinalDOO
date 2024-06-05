package co.edu.uco.deviucopay.crosscutting.exceptions;

import co.edu.uco.deviucopay.crosscutting.exceptions.enums.Lugar;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;

public class DeviUcopayException extends RuntimeException{
	
	private static final long serialVersionUID=1L;
	protected String mensajeUsuario;
	protected Lugar lugar;
	
	public DeviUcopayException(String mensajeTecnico,String mensajeUsuario, 
		Lugar lugar, Throwable exceptionRaiz) {
		super(mensajeTecnico, exceptionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}
	
	public DeviUcopayException(final String mensajeUsuario, Lugar lugar) {
			super(mensajeUsuario);
			setMensajeUsuario(mensajeUsuario);
			setLugar(lugar);
		}
	
	public DeviUcopayException(String mensajeTecnico, String mensajeUsuario, Lugar lugar ) {
		super(mensajeUsuario);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario =TextHelper.applyTrim(mensajeUsuario);
	}

	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.DEFAULT);
		
	}

	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public final Lugar getLugar() {
		return lugar;
	}
	
	
	
	
	

}

