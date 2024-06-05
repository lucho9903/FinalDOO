package co.edu.uco.deviucopay.business.assembler.dto.impl;

import static co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.List;
import java.util.ArrayList;
import co.edu.uco.deviucopay.business.assembler.dto.AssemblerDTO;
import co.edu.uco.deviucopay.business.domain.TipoCuentaDomain;
import co.edu.uco.deviucopay.business.domain.TipoIdentificacionDomain;
import co.edu.uco.deviucopay.dto.TipoCuentaDTO;
import co.edu.uco.deviucopay.dto.TipoIdentificacionDTO;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;

public class TipoCuentaAssemblerDTO implements AssemblerDTO<TipoCuentaDomain, TipoCuentaDTO> {

	private static final AssemblerDTO<TipoCuentaDomain, TipoCuentaDTO>  instance = new TipoCuentaAssemblerDTO();
	
	
	private TipoCuentaAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<TipoCuentaDomain, TipoCuentaDTO> getInstance(){
		return instance;
	}
	@Override
	public final TipoCuentaDomain toDomain(final TipoCuentaDTO date) {
		var tipoCuentaDtoTmp =getObjectHelper().getDefaultValue(date , TipoCuentaDTO.build());
		
		return TipoCuentaDomain.build(tipoCuentaDtoTmp.getId(),tipoCuentaDtoTmp.getNombre());
	}

	@Override
	public final TipoCuentaDTO toDTO(final TipoCuentaDomain domain) {
		var tipoCuentaDomainTmp = getObjectHelper().getDefaultValue(domain , TipoCuentaDomain.build());
	
		return TipoCuentaDTO.build().setId(tipoCuentaDomainTmp.getId()).setNombre(tipoCuentaDomainTmp.getNombre());
	}

	@Override
	public final List<TipoCuentaDomain> toDomainCollection(final List<TipoCuentaDTO> dtoCollection) {
		
		
		return null;
	}
	@Override
	public final List<TipoCuentaDTO> toDTOCollection(final List<TipoCuentaDomain> domainCollection) {
		
		return null;
	}
	
}