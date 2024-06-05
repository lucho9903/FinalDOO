package co.edu.uco.deviucopay.dto;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;


public final class TipoIdentificacionDTO {
	
	private UUID id;
	private String nombre;
	
	public TipoIdentificacionDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}
	
	public TipoIdentificacionDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoIdentificacionDTO build() {
		return new TipoIdentificacionDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionDTO setId( final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoIdentificacionDTO setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}
	
}