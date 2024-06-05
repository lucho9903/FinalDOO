package co.edu.uco.deviucopay.business.domain;

import java.util.UUID;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;

public class AfiliadoDomain {
    private UUID id;
    private String numeroIdAfiliado;
    private String nombre;
    private String correo;
    private String telefono;
    private TipoIdentificacionDomain tipoIdentificacion;
    private InstitucionDomain institucion;

    private AfiliadoDomain(final UUID id, final String numeroIdAfiliado, final String nombre, final String correo, final String telefono, final TipoIdentificacionDomain tipoIdentificacion, final InstitucionDomain institucion) {
        setId(id);
        setNumeroIdAfiliado(numeroIdAfiliado);
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
        setTipoIdentificacion(tipoIdentificacion);
        setInstitucion(institucion);
    }

    public static final  AfiliadoDomain build(final UUID id, final String numeroIdAfiliado,
    		final String nombre, final String correo,
    		final String telefono, final TipoIdentificacionDomain tipoIdentificacion, 
    		final InstitucionDomain institucion) {
        return new AfiliadoDomain(id, numeroIdAfiliado, nombre, correo, telefono, tipoIdentificacion, institucion);
    }

    public static AfiliadoDomain build(final UUID id) {
        return new AfiliadoDomain(id, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TipoIdentificacionDomain.build(), InstitucionDomain.build());
    }

    public static AfiliadoDomain build() {
        return new AfiliadoDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TipoIdentificacionDomain.build(), InstitucionDomain.build());
    }

    private final void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private final void setNumeroIdAfiliado(String numeroIdAfiliado) {
        this.numeroIdAfiliado = TextHelper.applyTrim(numeroIdAfiliado);
    }

    private final void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private final void setCorreo(String correo) {
        this.correo = TextHelper.applyTrim(correo);
    }

    private final void setTelefono(String telefono) {
        this.telefono = TextHelper.applyTrim(telefono);
    }

    private final void setTipoIdentificacion(TipoIdentificacionDomain tipoIdentificacion) {
        this.tipoIdentificacion = ObjectHelper.getObjectHelper().getDefaultValue(tipoIdentificacion, TipoIdentificacionDomain.build());
    }

    private final void setInstitucion(InstitucionDomain institucion) {
        this.institucion = ObjectHelper.getObjectHelper().getDefaultValue(institucion, InstitucionDomain.build());
    }

    public final UUID getId() {
        return id;
    }

    public final String getNumeroIdAfiliado() {
        return numeroIdAfiliado;
    }

    public final String getNombre() {
        return nombre;
    }

    public final String getCorreo() {
        return correo;
    }

    public final String getTelefono() {
        return telefono;
    }

    public final TipoIdentificacionDomain getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public final InstitucionDomain getInstitucion() {
        return institucion;
    }
}
