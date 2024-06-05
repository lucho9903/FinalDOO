package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;


public final class TipoCuentaEntity {
	
	private UUID id;
	private String nombre;
	private String identificadorTipoCuenta;
	
	
	public TipoCuentaEntity(final UUID id, final String nombre, final String identificadorTipoCuenta) {
		setId(id);
		setNombre(nombre);
		setIdentificadorTipoCuenta(identificadorTipoCuenta);
	}
	
	public TipoCuentaEntity () {
		super();
	}
	
	public static final TipoCuentaEntity build() {
		return new TipoCuentaEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoCuentaEntity setId( final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	
	public final TipoCuentaEntity setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}
	
	
	
	public String getIdentificadorTipoCuenta() {
		return identificadorTipoCuenta;
	}

	public void setIdentificadorTipoCuenta(String identificadorTipoCuenta) {
		this.identificadorTipoCuenta = TextHelper.applyTrim(identificadorTipoCuenta);
	}

	
	
}