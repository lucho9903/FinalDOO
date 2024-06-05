package co.edu.uco.deviucopay.dto;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CarnetDTO {
	
	private UUID id;
	private String numeroCarnet;
	
	
	public CarnetDTO(UUID id, String numeroCarnet) {
		setId(id);
		setNumeroCarnet(numeroCarnet);
	}

	public CarnetDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNumeroCarnet(TextHelper.EMPTY);
}
	
	public static final CarnetDTO build() {
		return new CarnetDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final CarnetDTO setId( final UUID id) {
		this.id = ObjectHelper.getObjectHelper().getDefaultValue(id,UUIDHelper.generate());
		return this;
	}
	public final String getNumeroCarnet() {
		return numeroCarnet;
	}
	public final CarnetDTO setNumeroCarnet(final String numeroCarnet) {
		this.numeroCarnet=TextHelper.applyTrim(numeroCarnet);
		return this;
	}	
}
