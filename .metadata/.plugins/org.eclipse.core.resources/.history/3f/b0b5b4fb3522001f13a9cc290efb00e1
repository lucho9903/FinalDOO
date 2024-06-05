package co.edu.uco.deviucopay.entity;

import java.util.UUID;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;


public final class TipoIdentificacionEntity {
	
	private UUID id;
	private String nombre;
	
	public TipoIdentificacionEntity() {
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}
	public TipoIdentificacionEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoIdentificacionEntity build() {
		return new TipoIdentificacionEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final TipoIdentificacionEntity setId( final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final TipoIdentificacionEntity setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}
	
		
	
}