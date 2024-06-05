package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.FloatHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CarnetEntity {
    private UUID id;
    private String numeroCarnet;
    private CuentaEntity cuenta;
    
    public CarnetEntity() {
    	setId(UUIDHelper.getDefault());
    	setNumeroCarnet(TextHelper.EMPTY);
    	setCuenta(CuentaEntity.build());
    }

    public CarnetEntity(final UUID id,final  String numeroCarnet,final CuentaEntity cuenta) {
        setId(id);
        setNumeroCarnet(numeroCarnet);
        setCuenta(cuenta);
    }

    

    public static CarnetEntity build() {
        return new CarnetEntity();
    }

    public final  UUID getId() {
        return id;
    }

    public final CarnetEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, null);
        return this;
    }

    public final String getNumeroCarnet() {
        return numeroCarnet;
    }

    public final CarnetEntity setNumeroCarnet(final String numeroCarnet) {
        this.numeroCarnet = TextHelper.applyTrim(numeroCarnet);
        return this;
    }
    public final CuentaEntity getCuenta() {
        return cuenta;
    }

    public final CarnetEntity setCuenta(final CuentaEntity cuenta) {
        this.cuenta = ObjectHelper.getObjectHelper().getDefaultValue(cuenta, new CuentaEntity());
        return this;
    }
}
