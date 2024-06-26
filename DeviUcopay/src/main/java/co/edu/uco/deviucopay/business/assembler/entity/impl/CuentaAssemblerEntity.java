package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.AfiliadoDomain;
import co.edu.uco.deviucopay.business.domain.CuentaDomain;
import co.edu.uco.deviucopay.business.domain.InstitucionDomain;
import co.edu.uco.deviucopay.business.domain.TipoCuentaDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.AfiliadoEntity;
import co.edu.uco.deviucopay.entity.CuentaEntity;
import co.edu.uco.deviucopay.entity.InstitucionEntity;
import co.edu.uco.deviucopay.entity.TipoCuentaEntity;

public class CuentaAssemblerEntity implements AssemblerEntity<CuentaDomain, CuentaEntity> {
	private static final AssemblerEntity<CuentaDomain, CuentaEntity> instance=new CuentaAssemblerEntity();
	private static final AssemblerEntity<AfiliadoDomain, AfiliadoEntity> afiliadoAssembler = AfiliadoAssemblerEntity.getInstance();
	private static final AssemblerEntity<TipoCuentaDomain, TipoCuentaEntity> tipoCuentaAssembler = TipoCuentaAssemblerEntity.getInstance();

	
	private CuentaAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<CuentaDomain, CuentaEntity> getInstance(){
    	return instance;
    }

    public final CuentaDomain toDomain(final CuentaEntity data) {
		var cuentaEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, CuentaEntity.build());
		var afiliadoDomain = afiliadoAssembler.toDomain(cuentaEntityTmp.getAfiliado());
		var tipoCuentaDomain = tipoCuentaAssembler.toDomain(cuentaEntityTmp.getTipoCuenta());
		return CuentaDomain.build(cuentaEntityTmp.getId(), cuentaEntityTmp.getNumeroCuenta(),cuentaEntityTmp.getPin(),
				cuentaEntityTmp.getSaldo(), afiliadoDomain, tipoCuentaDomain );
	}

	@Override
	public final CuentaEntity toEntity(final CuentaDomain domain) {
		var cuentaDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, CuentaDomain.build());
		var afiliadoEntity = afiliadoAssembler.toEntity(cuentaDomainTmp.getAfiliado());
		var tipoCuentaEntity = tipoCuentaAssembler.toEntity(cuentaDomainTmp.getTipoCuenta());
		return CuentaEntity.build().setId(cuentaDomainTmp.getId())
				.setNumeroCuenta(cuentaDomainTmp.getNumeroCuenta()).setPin(cuentaDomainTmp.getPin())
				.setSaldo(cuentaDomainTmp.getSaldo()).setAfiliado(afiliadoEntity).setTipoCuenta(tipoCuentaEntity);
	}

	@Override
	public List<CuentaDomain> toDomainCollection(List<CuentaEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<CuentaEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<CuentaEntity> toEntityCollection(List<CuentaDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<CuentaDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}