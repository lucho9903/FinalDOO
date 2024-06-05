package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.InstitucionDomain;
import co.edu.uco.deviucopay.business.domain.TipoInstitucionDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.InstitucionEntity;
import co.edu.uco.deviucopay.entity.TipoInstitucionEntity;

public class InstitucionAssemblerEntity implements AssemblerEntity<InstitucionDomain, InstitucionEntity> {

	private static final AssemblerEntity<InstitucionDomain, InstitucionEntity> instance=new InstitucionAssemblerEntity();
	private static final AssemblerEntity<TipoInstitucionDomain, TipoInstitucionEntity> tipoInstitucionAssembler = TipoInstitucionAssemblerEntity.getInstance();
	
	private InstitucionAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<InstitucionDomain, InstitucionEntity> getInstance(){
    	return instance;
    }

    @Override
	public final InstitucionDomain toDomain(final InstitucionEntity data) {
		var institucionEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, InstitucionEntity.build());
		var tipoInstitucionDomain = tipoInstitucionAssembler.toDomain(institucionEntityTmp.getTipoInstitucion());
		return InstitucionDomain.build(institucionEntityTmp.getId(), institucionEntityTmp.getNombre(),institucionEntityTmp.getCorreo() ,tipoInstitucionDomain);
	}

	@Override
	public final InstitucionEntity toEntity(final InstitucionDomain domain) {
		var institucionDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, InstitucionDomain.build());
		var tipoInstitucionEntity = tipoInstitucionAssembler.toEntity(institucionDomainTmp.getTipoInstitucion());
		return InstitucionEntity.build().setId(institucionDomainTmp.getId())
				.setNombre(institucionDomainTmp.getNombre()).setCorreo(institucionDomainTmp.getCorreo())
				.setTipoInstitucion(tipoInstitucionEntity);
	}

	@Override
	public List<InstitucionDomain> toDomainCollection(List<InstitucionEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<InstitucionEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<InstitucionEntity> toEntityCollection(List<InstitucionDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<InstitucionDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}