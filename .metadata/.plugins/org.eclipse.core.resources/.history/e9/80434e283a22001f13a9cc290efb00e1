package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.CuentaDomain;
import co.edu.uco.deviucopay.business.domain.InstitucionDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.CuentaEntity;
import co.edu.uco.deviucopay.entity.InstitucionEntity;

public class CuentaAssemblerEntity implements AssemblerEntity<CuentaDomain, CuentaEntity> {
	private static final AssemblerEntity<CuentaDomain, CuentaEntity> instance=new CuentaAssemblerEntity();
	
	private CuentaAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<CuentaDomain, CuentaEntity> getInstance(){
    	return instance;
    }

	@Override
	public CuentaDomain toDomain(CuentaEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaDomain> toDomainCollection(List<CuentaEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(entityCollection,new ArrayList<CuentaEntity>());
		
		return entityCollectionTmp.stream()
				.map(this::toDomain).toList();
	}

	@Override
	public CuentaEntity toEntity(CuentaDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
