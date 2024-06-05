package co.edu.uco.deviucopay.dto;
import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;


public class InstitucionDTO {
	
	private UUID id;
	private String nombre;
	private TipoInstitucionDTO tipoInstitucion;	
	private String correo;
	
	
	
	public InstitucionDTO(final UUID id, final  String nombre, final TipoInstitucionDTO tipoInstitucion, final String correo) {		
		setId(id);
		setNombre(nombre);
		setTipoInstitucion(tipoInstitucion);
		setCorreo(correo);
	}

	public InstitucionDTO () {
		super();
	}
	
	public TipoInstitucionDTO getTipoInstitucion() {
		return tipoInstitucion;
	}

	public void setTipoInstitucion(TipoInstitucionDTO tipoInstitucion) {
		this.tipoInstitucion = ObjectHelper.getObjectHelper().getDefaultValue(tipoInstitucion, new TipoInstitucionDTO());
	}

	public static final InstitucionDTO build() {
		return new InstitucionDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final InstitucionDTO setId( final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final InstitucionDTO setNombre(final String nombre) {
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
