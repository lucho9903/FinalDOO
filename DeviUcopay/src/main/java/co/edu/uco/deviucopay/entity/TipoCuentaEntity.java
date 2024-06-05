package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;


public final class TipoCuentaEntity {
	
	private UUID id;
	private String nombre;

	
	public TipoCuentaEntity() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}
	
	
	public TipoCuentaEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	
	
	public static final TipoCuentaEntity build() {
		return new TipoCuentaEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoCuentaEntity setId( final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	
	public final TipoCuentaEntity setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}	
}