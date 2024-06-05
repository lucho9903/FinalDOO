package co.edu.uco.deviucopay.business.assembler.dto.impl;

import static co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.List;
import java.util.ArrayList;
import co.edu.uco.deviucopay.business.assembler.dto.AssemblerDTO;
import co.edu.uco.deviucopay.business.domain.AfiliadoDomain;
import co.edu.uco.deviucopay.dto.AfiliadoDTO;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;

public class AfiliadoAssemblerDTO implements AssemblerDTO<AfiliadoDomain, AfiliadoDTO> {
	
	private static final AssemblerDTO<AfiliadoDomain, AfiliadoDTO>  instance = new AfiliadoAssemblerDTO();
	
	
	private AfiliadoAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<AfiliadoDomain, AfiliadoDTO> getInstance(){
		return instance;
	}

	@Override
	public AfiliadoDomain toDomain(AfiliadoDTO data) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AfiliadoDTO toDTO(final AfiliadoDomain domain) {
		var ciudadDomainTmp = getObjectHelper().getDefaultValue(domain, AfiliadoDomain.build());
		return AfiliadoDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre());
	}

	@Override
	public final List<AfiliadoDomain> toDomainCollection(final List<AfiliadoDTO> dtoCollection) {
		var dtoCollectioTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection, new ArrayList<AfiliadoDTO>());
		var resultadoDomain = new ArrayList<AfiliadoDomain>();
		
		for (AfiliadoDTO afiliadoDto : dtoCollectioTmp) {
			var afiliadoDomainTmp = toDomain(afiliadoDto);
			resultadoDomain.add(afiliadoDomainTmp);
		}
		
		return resultadoDomain;
	}

	@Override
	public final List<AfiliadoDTO> toDTOCollection(final List<AfiliadoDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(domainCollection, new ArrayList<AfiliadoDomain>());
		return domainCollectionTmp.stream().map(this::toDTO).toList();
	}
	
}