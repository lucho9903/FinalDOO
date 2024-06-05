package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;

import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.TipoIdentificacionDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.TipoIdentificacionEntity;

public class TipoIdentificacionAssemblerEntity implements AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity>{

	private static final AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity> INSTANCE = new TipoIdentificacionAssemblerEntity();


	private TipoIdentificacionAssemblerEntity() {
		super();
	}
	public static final AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity> getInstance(){
		return INSTANCE; 
		
	}	
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionEntity data) {
		var TipoIdentificacionEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, TipoIdentificacionEntity.build());
		return TipoIdentificacionDomain.build(TipoIdentificacionEntityTmp.getId(), TipoIdentificacionEntityTmp.getNombre());
	}

	@Override
	public TipoIdentificacionEntity toEntity(TipoIdentificacionDomain domain) {
		var TipoIdentificacionDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, TipoIdentificacionDomain.build());
		return TipoIdentificacionEntity.build().setId(TipoIdentificacionDomainTmp.getId())
				.setNombre(TipoIdentificacionDomainTmp.getNombre());
	}

	@Override
	public List<TipoIdentificacionDomain> toDomainCollection(List<TipoIdentificacionEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<TipoIdentificacionEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<TipoIdentificacionEntity> toEntityCollection(List<TipoIdentificacionDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<TipoIdentificacionDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}
