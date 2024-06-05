package co.edu.uco.deviucopay.business.domain;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CarnetDomain {
    private UUID id;
    private String numeroCarnet;
    private CuentaDomain cuenta;

    private CarnetDomain(final UUID id, final String numeroCarnet, final CuentaDomain cuenta) {
        setId(id);
        setNumeroCarnet(numeroCarnet);
        setCuenta(cuenta);
}
	
	public static final CarnetDomain build (final UUID id, final String numeroCarnet, final CuentaDomain cuenta) {
		return new CarnetDomain(id, numeroCarnet, cuenta);
	}
	
	public static CarnetDomain build(){
        return new CarnetDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, CuentaDomain.build());
    }
	
	public static final  CarnetDomain build (final UUID id) {
		return new CarnetDomain(id, TextHelper.EMPTY, CuentaDomain.build());
	}
	
	private final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	
	private final void setNumeroCarnet(final String numeroCarnet) {
		this.numeroCarnet = TextHelper.applyTrim(numeroCarnet);
	}
	
	private final void setCuenta(CuentaDomain cuenta ) {
		this.cuenta = ObjectHelper.getObjectHelper().getDefaultValue(cuenta, CuentaDomain.build());
	}
	
	public final UUID getId() {
		return id;
	}
	
	public final String getNumeroCarnet() {
		return numeroCarnet;
	}
	
	public final CuentaDomain getCuenta() {
		return cuenta;
	}

}
