package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;


public final class TipoInstitucionEntity {
	
	private UUID id;
	private String nombre;
	
	public TipoInstitucionEntity () {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}	
	
	public TipoInstitucionEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	
	
	public static final TipoInstitucionEntity build() {
		return new TipoInstitucionEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoInstitucionEntity setId( final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoInstitucionEntity setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}
	
	
}