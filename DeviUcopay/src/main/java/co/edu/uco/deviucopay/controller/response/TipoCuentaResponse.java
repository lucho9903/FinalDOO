package co.edu.uco.deviucopay.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviucopay.dto.TipoCuentaDTO;

public class TipoCuentaResponse extends Response<TipoCuentaDTO>{
	public TipoCuentaResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
