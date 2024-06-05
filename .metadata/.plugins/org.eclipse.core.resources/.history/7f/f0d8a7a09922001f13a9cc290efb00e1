package co.edu.uco.deviucopay.business.assembler.dto.impl;

import static co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper.getObjectHelper;


import java.util.List;
import java.util.ArrayList;
import co.edu.uco.deviucopay.business.assembler.dto.AssemblerDTO;
import co.edu.uco.deviucopay.business.domain.CarnetDomain;
import co.edu.uco.deviucopay.dto.CarnetDTO;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.crosscutting.helpers.UUIDHelper;

public class CarnetAssemblerDTO implements AssemblerDTO<CarnetDomain, CarnetDTO> {

	private static final AssemblerDTO<CarnetDomain, CarnetDTO>  instance = new CarnetAssemblerDTO();
	
	
	private CarnetAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<CarnetDomain, CarnetDTO> getInstance(){
		return instance;
	}

	
	@Override
	public final CarnetDomain toDomain(final CarnetDTO data) {
		var carnetDtoTmp=getObjectHelper().getDefaultValue(data, CarnetDTO.build());
		return CarnetDomain.build(carnetDtoTmp.getId(), carnetDtoTmp.getNumeroCarnet());
	}

	@Override
	public final CarnetDTO toDTO(final CarnetDomain domain) {
		var carnetDomainTmp=getObjectHelper().getDefaultValue(domain, CarnetDomain.build());
		return CarnetDTO.build().setId(carnetDomainTmp.getId()).setNumeroCarnet(carnetDomainTmp.getNumeroCarnet());
	}

	@Override
	public List<CarnetDomain> toDomainCollection(List<CarnetDTO> entituCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarnetDTO> toDTOCollection(List<CarnetDomain> domainCollection) {
		// TODO Auto-generated method stub
		return null;
	}

}