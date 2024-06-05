package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.FloatHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviucopay.dto.TipoIdentificacionDTO;

public class AfiliadoEntity {
	
	private UUID id;
	private String numeroIdAfiliado;
	private String nombre;
	private String correo;
	private String telefono;
	private TipoIdentificacionEntity tipoIdentificacion;
	private InstitucionEntity institucion;
	
	
	public AfiliadoEntity() {
		setId(UUIDHelper.getDefault());
		setNumeroIdAfiliado(TextHelper.EMPTY);
		setNombre(TextHelper.EMPTY);
		setCorreo(TextHelper.EMPTY);
		setTelefono(TextHelper.EMPTY);
		setTipoIdentificacion(TipoIdentificacionEntity.build());
		setInstitucion(InstitucionEntity.build());
	}
	
	
	public AfiliadoEntity(final UUID id,final String numeroIdAfiliado,final String nombre,final String correo,final String telefono,
			final TipoIdentificacionEntity tipoIdentificacion,final InstitucionEntity institucion) {
		setId(id);
		setNumeroIdAfiliado(numeroIdAfiliado);
		setNombre(nombre);
		setCorreo(correo);
		setTelefono(telefono);
		setTipoIdentificacion(tipoIdentificacion);
		setInstitucion(institucion);
	}
	
	public static final AfiliadoEntity build() {
		return new AfiliadoEntity();
	}

	public UUID getId() {
		return id;
	}


	public final AfiliadoEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}


	public String getNumeroIdAfiliado() {
		return numeroIdAfiliado;
	}


	public final AfiliadoEntity setNumeroIdAfiliado(final String numeroIdAfiliado) {
		this.numeroIdAfiliado = TextHelper.applyTrim(numeroIdAfiliado);
		return this;
	}


	public String getNombre() {
		return nombre;
	}


	public final AfiliadoEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}


	public String getCorreo() {
		return correo;
	}


	public final AfiliadoEntity setCorreo(final String correo) {
		this.correo = TextHelper.applyTrim(correo);
		return this;
	}


	public String getTelefono() {
		return telefono;
	}


	public final AfiliadoEntity setTelefono(final String telefono) {
		this.telefono = TextHelper.applyTrim(telefono);
		return this;
	}


	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public final AfiliadoEntity setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = ObjectHelper.getObjectHelper().getDefaultValue(tipoIdentificacion, new TipoIdentificacionEntity());
		return this;
	}


	public InstitucionEntity getInstitucion() {
		return institucion;
	}


	public final AfiliadoEntity setInstitucion(final InstitucionEntity institucion) {
		this.institucion = ObjectHelper.getObjectHelper().getDefaultValue(institucion, new InstitucionEntity());
		return this;
	}
}
