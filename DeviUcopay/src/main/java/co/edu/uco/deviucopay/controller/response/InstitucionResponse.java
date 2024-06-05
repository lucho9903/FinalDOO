package co.edu.uco.deviucopay.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviucopay.dto.InstitucionDTO;

public class InstitucionResponse extends Response<InstitucionDTO>{
	public InstitucionResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}
}
