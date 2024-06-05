package co.edu.uco.deviucopay.dto;

import java.util.UUID;

import co.edu.uco.deviucopay.crosscutting.helpers.FloatHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CuentaDTO {
	private UUID id;
	private String numeroCuenta;
	private String pin;
	private Float saldo;
	private AfiliadoDTO afiliado;
	private TipoCuentaDTO tipoCuenta;
	private CarnetDTO carnet;
	
	public CuentaDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNumeroCuenta(TextHelper.EMPTY);
		setPin(TextHelper.EMPTY);
		setSaldo(FloatHelper.ZERO);
		setAfiliado(AfiliadoDTO.build());
		setTipoCuenta(TipoCuentaDTO.build());
		setCarnet(CarnetDTO.build());
	}	
	public CuentaDTO(UUID id, String numeroCuenta, String pin, Float saldo, AfiliadoDTO afiliado,TipoCuentaDTO tipoCuenta, CarnetDTO carnet) {
		super();
		setId(id);
		setNumeroCuenta(numeroCuenta);
		setPin(pin);
		setSaldo(saldo);
		setAfiliado(afiliado);
		setTipoCuenta(tipoCuenta);
		setCarnet(carnet);
	}
	public static final CuentaDTO build() {
		return new CuentaDTO();
	}
	
	public final UUID getId() {
		return id;
	}
	public final CuentaDTO setId(final UUID id) {
		this.id = ObjectHelper.getObjectHelper().getDefaultValue(id,UUIDHelper.generate());
		return this;
	}
	public final String getNumeroCuenta() {
		return numeroCuenta;
	}
	public final CuentaDTO setNumeroCuenta(final String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
		return this;
	}
	public final String getPin() {
		return pin;
	}
	public final CuentaDTO setPin(final String pin) {
		this.pin = pin;
		return this;
	}
	public final Float getSaldo() {
		return saldo;
	}
	public final CuentaDTO setSaldo(final Float saldo) {
		this.saldo = saldo;
		return this;
	}
	public final AfiliadoDTO getAfiliado() {
		return afiliado;
	}
	public final CuentaDTO setAfiliado(final AfiliadoDTO afiliado) {
		this.afiliado = afiliado;
		return this;
	}
	public final TipoCuentaDTO getTipoCuenta() {
		return tipoCuenta;
	}
	public final CuentaDTO setTipoCuenta(final TipoCuentaDTO tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
		return this;
	}
	public final CarnetDTO getCarnet() {
		return carnet;
	}
	public final CuentaDTO setCarnet(final CarnetDTO carnet) {
		this.carnet = carnet;
		return this;
	}
}