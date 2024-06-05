package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.FloatHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CarnetEntity {
	
	private UUID id;
	private String numeroCarnet;
	
	
	
	
	
	public CarnetEntity(UUID id, String numeroCarnet) {
		setId(id);
		setNumeroCarnet(numeroCarnet);
	}

	public CarnetEntity() {
		super();
	}
	
	public static CarnetEntity build() {
		return new CarnetEntity();
		
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, null);
	}
	
	public String getNumeroCarnet() {
		return numeroCarnet;
	}
	
	public void setNumeroCarnet(String numeroCarnet) {
		this.numeroCarnet = TextHelper.applyTrim(numeroCarnet);
	}
		
	

}
