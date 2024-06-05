package co.edu.uco.deviucopay.dto;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;


public final class TipoCuentaDTO {
	
	private UUID id;
	private String nombre;
	private String identificadorTipoCuenta;
	
	
	public TipoCuentaDTO(final UUID id, final String nombre, final String identificadorTipoCuenta) {
		setId(id);
		setNombre(nombre);
		setIdentificadorTipoCuenta(identificadorTipoCuenta);
	}
	
	public TipoCuentaDTO () {
		super();
	}
	
	public static final TipoCuentaDTO build() {
		return new TipoCuentaDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoCuentaDTO setId( final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	
	public final TipoCuentaDTO setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}
	
	
	
	public String getIdentificadorTipoCuenta() {
		return identificadorTipoCuenta;
	}

	public void setIdentificadorTipoCuenta(String identificadorTipoCuenta) {
		this.identificadorTipoCuenta = TextHelper.applyTrim(identificadorTipoCuenta);
	}

	public static void main(String[] args) {
		TipoCuentaDTO tipoCuenta = TipoCuentaDTO.build();
	}
	
	
}