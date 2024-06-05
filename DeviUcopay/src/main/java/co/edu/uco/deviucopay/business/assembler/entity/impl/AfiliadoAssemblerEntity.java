package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.AfiliadoDomain;
import co.edu.uco.deviucopay.business.domain.InstitucionDomain;
import co.edu.uco.deviucopay.business.domain.TipoIdentificacionDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.AfiliadoEntity;
import co.edu.uco.deviucopay.entity.InstitucionEntity;
import co.edu.uco.deviucopay.entity.TipoIdentificacionEntity;


public class AfiliadoAssemblerEntity implements AssemblerEntity<AfiliadoDomain, AfiliadoEntity>{
	private static final AssemblerEntity<AfiliadoDomain, AfiliadoEntity> INSTANCE=new AfiliadoAssemblerEntity();
	private static final AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity> tipoIdentificacionAssembler = TipoIdentificacionAssemblerEntity.getInstance(); 
	private static final AssemblerEntity<InstitucionDomain, InstitucionEntity> institucionAssembler = InstitucionAssemblerEntity.getInstance();

	
	private AfiliadoAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<AfiliadoDomain, AfiliadoEntity> getInstance() {
		return INSTANCE;
	}
	
	@Override
	public final AfiliadoDomain toDomain(final AfiliadoEntity data) {
		var afiliadoEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, AfiliadoEntity.build());
		var institucionDomain = institucionAssembler.toDomain(afiliadoEntityTmp.getInstitucion());
		var tipoIdentificacionDomain = tipoIdentificacionAssembler.toDomain(afiliadoEntityTmp.getTipoIdentificacion());
		return AfiliadoDomain.build(afiliadoEntityTmp.getId(),afiliadoEntityTmp.getNumeroIdAfiliado(),afiliadoEntityTmp.getNombre()
				,afiliadoEntityTmp.getCorreo(),afiliadoEntityTmp.getTelefono(),tipoIdentificacionDomain, institucionDomain );
	}
	
	@Override
	public final AfiliadoEntity toEntity(final AfiliadoDomain domain) {
		var afiliadoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, AfiliadoDomain.build());
		var institucionEntity = institucionAssembler.toEntity(afiliadoDomainTmp.getInstitucion());
		var tipoIdentificacionEntity = tipoIdentificacionAssembler.toEntity(afiliadoDomainTmp.getTipoIdentificacion());	
		return AfiliadoEntity.build().setId(afiliadoDomainTmp.getId()).setNumeroIdAfiliado(afiliadoDomainTmp.getNumeroIdAfiliado())
				.setNombre(afiliadoDomainTmp.getNombre()).setCorreo(afiliadoDomainTmp.getCorreo()).setTelefono(afiliadoDomainTmp.getTelefono())
				.setTipoIdentificacion(tipoIdentificacionEntity).setInstitucion(institucionEntity);
	}

	@Override
	public List<AfiliadoDomain> toDomainCollection(List<AfiliadoEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<AfiliadoEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<AfiliadoEntity> toEntityCollection(List<AfiliadoDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<AfiliadoDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}
