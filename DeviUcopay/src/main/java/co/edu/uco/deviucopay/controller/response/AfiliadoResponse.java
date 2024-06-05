package co.edu.uco.deviucopay.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviucopay.dto.AfiliadoDTO;

public class AfiliadoResponse extends Response<AfiliadoDTO>{
	public AfiliadoResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
