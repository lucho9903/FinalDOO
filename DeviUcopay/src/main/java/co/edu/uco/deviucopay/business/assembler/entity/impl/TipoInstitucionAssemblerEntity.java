package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.TipoInstitucionDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.TipoInstitucionEntity;

public class TipoInstitucionAssemblerEntity implements AssemblerEntity<TipoInstitucionDomain, TipoInstitucionEntity>{
	private static final AssemblerEntity<TipoInstitucionDomain, TipoInstitucionEntity> instance = new TipoInstitucionAssemblerEntity();


	private TipoInstitucionAssemblerEntity() {
		super();
	}
	public static final AssemblerEntity<TipoInstitucionDomain, TipoInstitucionEntity> getInstance(){
		return instance;
	}
	@Override
	public TipoInstitucionDomain toDomain(TipoInstitucionEntity data) {
		var tipoInstitucionEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, TipoInstitucionEntity.build());
		return TipoInstitucionDomain.build(tipoInstitucionEntityTmp.getId(), tipoInstitucionEntityTmp.getNombre());
	}

	@Override
	public TipoInstitucionEntity toEntity(TipoInstitucionDomain domain) {
		var tipoInstitucionDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, TipoInstitucionDomain.build());
		return TipoInstitucionEntity.build().setId(tipoInstitucionDomainTmp.getId()).setNombre(tipoInstitucionDomainTmp.getNombre());
	}

	@Override
	public List<TipoInstitucionDomain> toDomainCollection(List<TipoInstitucionEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<TipoInstitucionEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<TipoInstitucionEntity> toEntityCollection(List<TipoInstitucionDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<TipoInstitucionDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}