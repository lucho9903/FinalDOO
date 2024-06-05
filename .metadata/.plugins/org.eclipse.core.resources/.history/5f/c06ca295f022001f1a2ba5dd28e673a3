package co.edu.uco.deviucopay.dto;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CarnetDTO {
	
	private UUID id;
	private String numeroCarnet;
	private CuentaDTO cuenta;
	
	
	public CarnetDTO(final UUID id, final String numeroCarnet, final CuentaDTO ciuenta) {
		setId(id);
		setNumeroCarnet(numeroCarnet);
		setCuenta(cuenta);
	}

	public CarnetDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNumeroCarnet(TextHelper.EMPTY);
		setCuenta(CuentaDTO.build());
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
	public final CuentaDTO get() {
		return cuenta;
	}
	public final CarnetDTO setCuenta(final CuentaDTO cuenta) {
		this.cuenta = ObjectHelper.getObjectHelper().getDefaultValue(cuenta, new CuentaDTO());
		return this;
	}
}
