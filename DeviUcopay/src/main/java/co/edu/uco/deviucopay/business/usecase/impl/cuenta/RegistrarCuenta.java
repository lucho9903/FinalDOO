package co.edu.uco.deviucopay.business.usecase.impl.cuenta;

import java.util.List;
import java.util.UUID;

import co.edu.uco.deviucopay.business.assembler.entity.impl.AfiliadoAssemblerEntity;
import co.edu.uco.deviucopay.business.assembler.entity.impl.TipoCuentaAssemblerEntity;
import co.edu.uco.deviucopay.business.domain.CuentaDomain;
import co.edu.uco.deviucopay.business.usecase.UseCaseWithoutReturn;
import co.edu.uco.deviucopay.crosscutting.exceptions.customs.BusinessDeviUcopayException;
import co.edu.uco.deviucopay.crosscutting.helpers.FloatHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.TextHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;
import co.edu.uco.deviucopay.data.dao.factory.DAOFactory;
import co.edu.uco.deviucopay.entity.AfiliadoEntity;
import co.edu.uco.deviucopay.entity.CuentaEntity;

public final class RegistrarCuenta implements UseCaseWithoutReturn<CuentaDomain> {

    private DAOFactory factory;

    public RegistrarCuenta(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de las Cuentas";
            var mensajeTecnico = "El DAOFactory para crear la Cuentas llegó nulo...";
            throw new BusinessDeviUcopayException(mensajeTecnico, mensajeUsuario);
        }

        this.factory = factory;
    }

    @Override
    public void execute(final CuentaDomain data) {
        validarDatos(data);

        List<AfiliadoEntity> afiliadoEntities = factory.getAfiliadoDAO().consultar(AfiliadoEntity.build().setId(data.getAfiliado().getId()));

        if (afiliadoEntities == null || afiliadoEntities.isEmpty()) {
            var mensajeUsuario = "El afiliado no está registrado en la institución.";
            throw new BusinessDeviUcopayException(mensajeUsuario);
        }

        AfiliadoEntity afiliadoEntity = afiliadoEntities.get(0);

        // Verificar si el afiliado ya tiene una cuenta registrada
        var cuentaExistente = factory.getCuentaDAO().consultar(CuentaEntity.build().setAfiliado(afiliadoEntity));
        if (cuentaExistente.isEmpty()) {
            var mensajeUsuario = "El afiliado ya tiene una cuenta registrada.";
            throw new BusinessDeviUcopayException(mensajeUsuario);
        }

        var numeroCuenta = generarNumeroCuentaUnico();
        var cuentaEntity = CuentaEntity.build()
            .setId(generarIdentificadorCuenta())
            .setNumeroCuenta(numeroCuenta)
            .setPin(data.getPin()) // Se establece el pin proporcionado en los datos de la cuenta
            .setSaldo(FloatHelper.ZERO)
            .setAfiliado(AfiliadoAssemblerEntity.getInstance().toEntity(data.getAfiliado()))
            .setTipoCuenta(TipoCuentaAssemblerEntity.getInstance().toEntity(data.getTipoCuenta()));

        factory.getCuentaDAO().crear(cuentaEntity);
    }


    private void validarDatos(CuentaDomain data) {
        validarPin(data.getPin());
        validarSaldo(data.getSaldo());
    }

    private UUID generarIdentificadorCuenta() {
        UUID id = UUIDHelper.generate();
        boolean existeId = true;

        while (existeId) {
            id = UUIDHelper.generate();
            var cuentaEntity = CuentaEntity.build().setId(id);
            var resultados = factory.getCuentaDAO().consultar(cuentaEntity);
            existeId = !resultados.isEmpty();
        }
        return id;
    }

    private String generarNumeroCuentaUnico() {
        String numeroCuenta;
        boolean existeNumero;
        do {
            // Generar un número aleatorio de 10 dígitos entre 1000000000 y 9999999999
            numeroCuenta = String.valueOf(1000000000L + (long)(Math.random() * 9000000000L));
            var cuentaEntity = CuentaEntity.build().setNumeroCuenta(numeroCuenta);
            var resultados = factory.getCuentaDAO().consultar(cuentaEntity);
            existeNumero = !resultados.isEmpty();
        } while (existeNumero);
        return numeroCuenta;
    }

    private void validarPin(final String pin) {
        if (TextHelper.isNullOrEmpty(pin)) {
            var mensajeUsuario = "El pin no puede estar vacío.";
            throw new BusinessDeviUcopayException(mensajeUsuario);
        }

        if (!pin.matches("\\d{4}")) {
            var mensajeUsuario = "El pin debe contener exactamente 4 dígitos.";
            throw new BusinessDeviUcopayException(mensajeUsuario);
        }
    }

    private void validarSaldo(final float saldo) {
        if (saldo != FloatHelper.ZERO) {
            var mensajeUsuario = "El saldo inicial debe ser 0.";
            throw new BusinessDeviUcopayException(mensajeUsuario);
        }
    }
}
