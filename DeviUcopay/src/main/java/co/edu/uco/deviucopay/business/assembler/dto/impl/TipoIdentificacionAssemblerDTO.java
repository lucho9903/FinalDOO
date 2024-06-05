package co.edu.uco.deviucopay.business.assembler.dto.impl;

import static co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.dto.AssemblerDTO;
import co.edu.uco.deviucopay.business.domain.TipoCuentaDomain;
import co.edu.uco.deviucopay.business.domain.TipoIdentificacionDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.dto.TipoCuentaDTO;
import co.edu.uco.deviucopay.dto.TipoIdentificacionDTO;

public class TipoIdentificacionAssemblerDTO implements AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> {

	private static final AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> instance = new TipoIdentificacionAssemblerDTO();

	private TipoIdentificacionAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> getInstance() {
		return instance;
	}

	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionDTO data) {
		var tipoIdentificacionDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, TipoIdentificacionDTO.build());
		return TipoIdentificacionDomain.build(tipoIdentificacionDtoTmp.getId(), tipoIdentificacionDtoTmp.getNombre());
	}

	@Override
	public List<TipoIdentificacionDomain> toDomainCollection(List<TipoIdentificacionDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection,
				new ArrayList<TipoIdentificacionDTO>());
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<TipoIdentificacionDTO> toDTOCollection(List<TipoIdentificacionDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<TipoIdentificacionDomain>());
		return domainCollectionTmp.stream().map(this::toDTO).toList();
	}

	@Override
	public TipoIdentificacionDTO toDTO(TipoIdentificacionDomain domain) {
		var tipoIdentificacionDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, TipoIdentificacionDomain.build());
		return TipoIdentificacionDTO.build().setId(tipoIdentificacionDomainTmp.getId()).setNombre(tipoIdentificacionDomainTmp.getNombre());
	}

}