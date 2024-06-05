package co.edu.uco.deviucopay.business.domain;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CarnetDomain {
    private UUID id;
    private String numeroCarnet;

    private CarnetDomain(final UUID id, final String numeroCarnet) {
        setId(id);
        setNumeroCarnet(numeroCarnet);
}
	
	public static final CarnetDomain build (final UUID id, final String numeroCarnet) {
		return new CarnetDomain(id, TextHelper.EMPTY);
	}
	
	public static CarnetDomain build(){
        return new CarnetDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
    }
	
	public static final  CarnetDomain build (final UUID id) {
		return new CarnetDomain(id, TextHelper.EMPTY);
	}
	
	private final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	private final void setNumeroCarnet(final String numeroCarnet) {
		this.numeroCarnet = TextHelper.applyTrim(numeroCarnet);
	}
	
	public final UUID getId() {
		return id;
	}
	
	public final String getNumeroCarnet() {
		return numeroCarnet;
	}

}
