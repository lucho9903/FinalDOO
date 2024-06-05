package co.edu.uco.deviucopay.business.assembler.dto.impl;

import static co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.List;
import java.util.ArrayList;
import co.edu.uco.deviucopay.business.assembler.dto.AssemblerDTO;
import co.edu.uco.deviucopay.business.domain.TipoCuentaDomain;
import co.edu.uco.deviucopay.dto.TipoCuentaDTO;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;

public class TipoCuentaAssemblerDTO implements AssemblerDTO<TipoCuentaDomain, TipoCuentaDTO> {

	private static final AssemblerDTO<TipoCuentaDomain, TipoCuentaDTO> instance = new TipoCuentaAssemblerDTO();

	private TipoCuentaAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<TipoCuentaDomain, TipoCuentaDTO> getInstance() {
		return instance;
	}

	@Override
	public TipoCuentaDomain toDomain(TipoCuentaDTO data) {
		var tipoCuentaDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, TipoCuentaDTO.build());
		return TipoCuentaDomain.build(tipoCuentaDtoTmp.getId(), tipoCuentaDtoTmp.getNombre());
	}

	@Override
	public List<TipoCuentaDomain> toDomainCollection(List<TipoCuentaDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection,
				new ArrayList<TipoCuentaDTO>());
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<TipoCuentaDTO> toDTOCollection(List<TipoCuentaDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<TipoCuentaDomain>());
		return domainCollectionTmp.stream().map(this::toDTO).toList();
	}

	@Override
	public TipoCuentaDTO toDTO(TipoCuentaDomain domain) {
		var tipoCuentaDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, TipoCuentaDomain.build());
		return TipoCuentaDTO.build().setId(tipoCuentaDomainTmp.getId()).setNombre(tipoCuentaDomainTmp.getNombre());
	}

}