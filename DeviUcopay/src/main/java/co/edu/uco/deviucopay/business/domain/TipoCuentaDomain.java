package co.edu.uco.deviucopay.business.domain;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class TipoCuentaDomain {
    private UUID id;
    private String nombre;

    private TipoCuentaDomain(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static TipoCuentaDomain build(final UUID id, final String nombre) {
        return new TipoCuentaDomain(id, nombre);
    }

    public static TipoCuentaDomain build(final UUID id) {
        return new TipoCuentaDomain(id, TextHelper.EMPTY);
    }

    public static TipoCuentaDomain build() {
        return new TipoCuentaDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
    }

    private final void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private final void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
    

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
