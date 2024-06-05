package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.CarnetDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.CarnetEntity;

public class CarnetAssemblerEntity implements AssemblerEntity<CarnetDomain, CarnetEntity>{
	private static final AssemblerEntity<CarnetDomain, CarnetEntity> instance=new CarnetAssemblerEntity();
	
	private CarnetAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<CarnetDomain, CarnetEntity> getInstance(){
    	return instance;
    }

	@Override
	public CarnetDomain toDomain(CarnetEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarnetDomain> toDomainCollection(List<CarnetEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(entityCollection,new ArrayList<CarnetEntity>());
		
		return entityCollectionTmp.stream()
				.map(this::toDomain).toList();
	}

	@Override
	public CarnetEntity toEntity(CarnetDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
