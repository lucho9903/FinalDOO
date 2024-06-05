package co.edu.uco.deviucopay.entity;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.FloatHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CuentaEntity {
	private UUID id;
	private String numeroCuenta;
	private String contraseña;
	private Float saldo;
	private AfiliadoEntity afiliado;
	private TipoCuentaEntity tipoCuenta;
	private CarnetEntity carnet;
	
	
	public CuentaEntity() {
		setId(UUIDHelper.getDefault());
		setNumeroCuenta(TextHelper.EMPTY);
		setContraseña(TextHelper.EMPTY);
		setSaldo(FloatHelper.ZERO);
		setAfiliado(AfiliadoEntity.build());
		setTipoCuenta(TipoCuentaEntity.build());
		setCarnet(CarnetEntity.build());
	}
	
	public CuentaEntity(UUID id, String numeroCuenta, String contraseña,
			Float saldo, AfiliadoEntity afiliado,
			TipoCuentaEntity tipoCuenta, CarnetEntity carnet) {
		setId(id);
		setNumeroCuenta(numeroCuenta);
		setContraseña(contraseña);
		setSaldo(saldo);
		setAfiliado(afiliado);
		setTipoCuenta(tipoCuenta);
		setCarnet(carnet);
	}
	
	public static final CuentaEntity build() {
		return new CuentaEntity();
	}
	public final UUID getId() {
		return id;
	}

	public final CuentaEntity setId(final UUID id) {
		this.id = id;
		return this;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = TextHelper.applyTrim(numeroCuenta);
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = TextHelper.applyTrim(contraseña);
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public AfiliadoEntity getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(AfiliadoEntity afiliado) {
		this.afiliado = ObjectHelper.getObjectHelper().getDefaultValue(afiliado,new AfiliadoEntity());
	}

	public TipoCuentaEntity getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuentaEntity tipoCuenta) {
		this.tipoCuenta = ObjectHelper.getObjectHelper().getDefaultValue(tipoCuenta, new TipoCuentaEntity());
	}
	public CarnetEntity getCarnet() {
		return carnet;
	}

	public void setCarnet(CarnetEntity carnet) {
		this.carnet = ObjectHelper.getObjectHelper().getDefaultValue(carnet, new CarnetEntity());
	}
	
	

	
}
