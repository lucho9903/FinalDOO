package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.TipoCuentaDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.TipoCuentaEntity;

public class TipoCuentaAssemblerEntity implements AssemblerEntity<TipoCuentaDomain, TipoCuentaEntity>{

	private static final AssemblerEntity<TipoCuentaDomain, TipoCuentaEntity> instance=new TipoCuentaAssemblerEntity();
	
	private TipoCuentaAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<TipoCuentaDomain, TipoCuentaEntity> getInstance(){
		return instance;
	}
	@Override
	public TipoCuentaDomain toDomain(TipoCuentaEntity data) {
		var tipoCuentaEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, TipoCuentaEntity.build());
		return TipoCuentaDomain.build(tipoCuentaEntityTmp.getId(), tipoCuentaEntityTmp.getNombre());
	}

	@Override
	public TipoCuentaEntity toEntity(TipoCuentaDomain domain) {
		var tipoCuentaDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, TipoCuentaDomain.build());
		return TipoCuentaEntity.build().setId(tipoCuentaDomainTmp.getId()).setNombre(tipoCuentaDomainTmp.getNombre());
	}

	@Override
	public List<TipoCuentaDomain> toDomainCollection(List<TipoCuentaEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<TipoCuentaEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<TipoCuentaEntity> toEntityCollection(List<TipoCuentaDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<TipoCuentaDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}
