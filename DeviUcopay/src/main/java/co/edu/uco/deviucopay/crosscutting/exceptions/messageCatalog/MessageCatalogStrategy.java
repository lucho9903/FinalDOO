package co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog;

import co.edu.uco.deviucopay.crosscutting.exceptions.customs.CrossCuttingDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.data.Mensaje;
import co.edu.uco.deviucopay.crosscutting.exceptions.messageCatalog.impl.MessageCatalogBase;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;


public class MessageCatalogStrategy {
	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService= new MessageCatalogBase();
	
	private MessageCatalogStrategy() {
		super();
	}
	
	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();
	}
	
	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase ? base: externalService;
	}
	
	public static final Mensaje getMensaje(final CodigoMensaje codigo,
			final String...parametros){
		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrossCuttingDeviUcopayException(mensajeTecnico, mensajeUsuario);
			}
		return getStrategy(codigo.isBase())
				.obtenerMensaje(codigo, parametros);
	}
	public static final String getContenidoMensaje(final CodigoMensaje codigo,
			final String...parametros) {
		return getMensaje(codigo, parametros).getContenido();		
	}
	public static void main(String[] args) {
		System.out.println(getContenidoMensaje(CodigoMensaje.M00007));
		
	}
}