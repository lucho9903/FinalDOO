package co.edu.uco.deviucopay.dto;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;


public final class TipoInstitucionDTO {
	
	private UUID id;
	private String nombre;
	
	
	public TipoInstitucionDTO () {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}
	
	public TipoInstitucionDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoInstitucionDTO build() {
		return new TipoInstitucionDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoInstitucionDTO setId( final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoInstitucionDTO setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}	
}