package co.edu.uco.deviucopay.business.assembler.dto.impl;

import static co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.List;

import co.edu.uco.deviucopay.business.assembler.dto.AssemblerDTO;
import co.edu.uco.deviucopay.business.domain.TipoCuentaDomain;
import co.edu.uco.deviucopay.business.domain.TipoIdentificacionDomain;
import co.edu.uco.deviucopay.business.domain.TipoInstitucionDomain;
import co.edu.uco.deviucopay.dto.TipoCuentaDTO;
import co.edu.uco.deviucopay.dto.TipoIdentificacionDTO;
import co.edu.uco.deviucopay.dto.TipoInstitucionDTO;

public class TipoIdentificacionAssemblerDTO implements AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> {

	private static final AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO>  instance = new TipoIdentificacionAssemblerDTO();
	
	
	private TipoIdentificacionAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<TipoIdentificacionDomain, TipoIdentificacionDTO> getInstance(){
		return instance;
	}
	@Override
	public final TipoIdentificacionDomain toDomain(final TipoIdentificacionDTO date) {
		var tipoIdentificacionDtoTmp =getObjectHelper().getDefaultValue(date , TipoIdentificacionDTO.build());
		
		return TipoIdentificacionDomain.build(tipoIdentificacionDtoTmp.getId(),tipoIdentificacionDtoTmp.getNombre());
	}

	@Override
	public final TipoIdentificacionDTO toDTO(final TipoIdentificacionDomain domain) {
		var tipoIdentificacionDomainTmp = getObjectHelper().getDefaultValue(domain , TipoIdentificacionDomain.build());
	
		return TipoIdentificacionDTO.build().setId(tipoIdentificacionDomainTmp.getId()).setNombre(tipoIdentificacionDomainTmp.getNombre());
	}

	@Override
	public final List<TipoIdentificacionDomain> toDomainCollection(final List<TipoIdentificacionDTO> dtoCollection) {
		
		
		return null;
	}
	@Override
	public final List<TipoIdentificacionDTO> toDTOCollection(final List<TipoIdentificacionDomain> domainCollection) {
		
		return null;
	}
	
}