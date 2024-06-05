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
	private CarnetEntity carnet;
	
	
	public AfiliadoEntity(UUID id, String numeroIdAfiliado, String nombre, String correo, String telefono,
			TipoIdentificacionEntity tipoIdentificacion, InstitucionEntity institucion, CarnetEntity carnet) {
		super();
		this.id = id;
		this.numeroIdAfiliado = numeroIdAfiliado;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.tipoIdentificacion = tipoIdentificacion;
		this.institucion = institucion;
		this.carnet = carnet;
	}

	
	public AfiliadoEntity() {
		super();
	}
	
	public static final AfiliadoEntity build() {
		return new AfiliadoEntity();
	}

	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault();
	}


	public String getNumeroIdAfiliado() {
		return numeroIdAfiliado;
	}


	public void setNumeroIdAfiliado(String numeroIdAfiliado) {
		this.numeroIdAfiliado = TextHelper.applyTrim(numeroIdAfiliado);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = TextHelper.applyTrim(correo);
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = TextHelper.applyTrim(telefono);
	}


	public TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public void setTipoIdentificacion(TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = ObjectHelper.getObjectHelper().getDefaultValue(tipoIdentificacion, new TipoIdentificacionEntity());
	}


	public InstitucionEntity getInstitucion() {
		return institucion;
	}


	public void setInstitucion(InstitucionEntity institucion) {
		this.institucion =  ObjectHelper.getObjectHelper().getDefaultValue(institucion,new InstitucionEntity());
	}


	public CarnetEntity getCarnet() {
		return carnet;
	}


	public void setCarnet(CarnetEntity carnet) {
		this.carnet =  ObjectHelper.getObjectHelper().getDefaultValue(carnet, new CarnetEntity());
	}
	
	
	
	
	

}
