package co.edu.uco.deviucopay.dto;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class AfiliadoDTO {
	
	private UUID id;
	private String numeroIdAfiliado;
	private String nombre;
	private String correo;
	private String telefono;
	private TipoIdentificacionDTO tipoIdentificacion;
	private InstitucionDTO institucion;
	
	
	public AfiliadoDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNumeroIdAfiliado(TextHelper.EMPTY);
		setNombre(TextHelper.EMPTY);
		setCorreo(TextHelper.EMPTY);
		setTelefono(TextHelper.EMPTY);
		setTipoIdentificacion(TipoIdentificacionDTO.build());
		setInstitucion(InstitucionDTO.build());
		
		
	}	
	
	public AfiliadoDTO(UUID id, String numeroIdAfiliado, String nombre, String correo, String telefono,
			TipoIdentificacionDTO tipoIdentificacion, InstitucionDTO institucion) {
		setId (id);
		setNumeroIdAfiliado (numeroIdAfiliado);
		setNombre(nombre);
		setCorreo(correo);
		setTelefono(telefono);
		setTipoIdentificacion (tipoIdentificacion);
		setInstitucion(institucion);
	}

	
	public static final AfiliadoDTO build() {
		return new AfiliadoDTO();
	}

	public final UUID getId() {
		return id;
	}
	public final AfiliadoDTO setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}
	public final String getNumeroIdAfiliado() {
		return numeroIdAfiliado;
	}
	public final AfiliadoDTO setNumeroIdAfiliado(final String numeroIdAfiliado) {
		this.numeroIdAfiliado = TextHelper.applyTrim(numeroIdAfiliado);
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final AfiliadoDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	public final String getCorreo() {
		return correo;
	}
	public final AfiliadoDTO setCorreo(final String correo) {
		this.correo = TextHelper.applyTrim(correo);
		return this;
	}
	public final String getTelefono() {
		return telefono;
	}
	public final AfiliadoDTO setTelefono(final String telefono) {
		this.telefono = TextHelper.applyTrim(telefono);
		return this;
	}

	public TipoIdentificacionDTO getTipoIdentificacion() {
		return getTipoIdentificacion();
	}


	public final AfiliadoDTO setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = ObjectHelper.getObjectHelper().getDefaultValue(tipoIdentificacion,new TipoIdentificacionDTO());
		return this;
	}


	public InstitucionDTO getInstitucion() {
		return getInstitucion();
	}


	public final AfiliadoDTO setInstitucion(InstitucionDTO institucion) {
		this.institucion =  ObjectHelper.getObjectHelper().getDefaultValue(institucion, new InstitucionDTO());
		return this;
	}
}
