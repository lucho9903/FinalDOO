package co.edu.uco.deviucopay.controller.response;

import java.util.ArrayList;

import co.edu.uco.deviucopay.dto.CarnetDTO;

public class CarnetResponse extends Response<CarnetDTO>{
	public CarnetResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
