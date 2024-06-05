package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;


public final class TipoInstitucionEntity {
	
	private UUID id;
	private String nombre;
	
	
	public TipoInstitucionEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public TipoInstitucionEntity () {
		super();
	}
	
	public static final TipoInstitucionEntity build() {
		return new TipoInstitucionEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoInstitucionEntity setId( final UUID id) {
		this.id = id;
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