package co.edu.uco.deviucopay.entity;
import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.dto.TipoInstitucionDTO;


public class InstitucionEntity {
	
	private UUID id;
	private String nombre;
	private TipoInstitucionEntity tipoInstitucion;	
	private String correo;
	
	
	
	public InstitucionEntity(final UUID id, final  String nombre, final TipoInstitucionEntity tipoInstitucion, final String correo) {		
		setId(id);
		setNombre(nombre);
		setTipoInstitucion(tipoInstitucion);
		setCorreo(correo);
	}

	public InstitucionEntity () {
		super();
	}
	
	public TipoInstitucionEntity getTipoInstitucion() {
		return tipoInstitucion;
	}

	public void setTipoInstitucion(TipoInstitucionEntity tipoInstitucion) {
		this.tipoInstitucion = ObjectHelper.getObjectHelper().getDefaultValue(tipoInstitucion,new TipoInstitucionEntity());
	}

	public static final InstitucionEntity build() {
		return new InstitucionEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final InstitucionEntity setId( final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final InstitucionEntity setNombre(final String nombre) {
		this.nombre=TextHelper.applyTrim(nombre);
		return this;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo =TextHelper.applyTrim(correo);
	}
	
	
	
}
