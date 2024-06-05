package co.edu.uco.deviucopay.business.assembler.dto.impl;

import java.util.List;
import java.util.ArrayList;
import static co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper.getObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.business.assembler.dto.AssemblerDTO;
import co.edu.uco.deviucopay.business.domain.CuentaDomain;
import co.edu.uco.deviucopay.dto.CuentaDTO;

public class CuentaAssemblerDTO implements AssemblerDTO<CuentaDomain, CuentaDTO> {

	private static final AssemblerDTO<CuentaDomain, CuentaDTO>  instance = new CuentaAssemblerDTO();
	
	
	private CuentaAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<CuentaDomain, CuentaDTO> getInstance(){
		return instance;
	}
	@Override
	public CuentaDomain toDomain(CuentaDTO data) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public final CuentaDTO toDTO(final CuentaDomain domain) {
		
		var cuentaDomainTmp = getObjectHelper().getDefaultValue(domain , CuentaDomain.build());
		
		return CuentaDTO.build().setId(cuentaDomainTmp.getId()).setNumeroCuenta(cuentaDomainTmp.getNumeroCuenta());
	}

	@Override
	public final List<CuentaDomain> toDomainCollection(final List<CuentaDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(dtoCollection, new ArrayList<CuentaDTO>());
		var resultadoDomain = new ArrayList<CuentaDomain>();
		
		for (CuentaDTO cuentaDto : dtoCollectionTmp) {
			var cuentaDomainTmp = toDomain(cuentaDto);
			resultadoDomain.add(cuentaDomainTmp);
		}
		
		return resultadoDomain;
	}

	@Override
	public final List<CuentaDTO> toDTOCollection(final List<CuentaDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(domainCollection, new ArrayList<CuentaDomain>());
		return domainCollectionTmp.stream().map(this::toDTO).toList();
	}

	
}