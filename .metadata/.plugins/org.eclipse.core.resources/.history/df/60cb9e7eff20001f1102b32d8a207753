package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.AfiliadoDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.AfiliadoEntity;

public class AfiliadoAssemblerEntity implements AssemblerEntity<AfiliadoDomain, AfiliadoEntity> {
	private static final AssemblerEntity<AfiliadoDomain, AfiliadoEntity> instance=new AfiliadoAssemblerEntity();
	
	private AfiliadoAssemblerEntity(){
        super();
    }

    public static final AssemblerEntity<AfiliadoDomain, AfiliadoEntity> getInstance(){
    	return instance;
    }

	@Override
	public AfiliadoDomain toDomain(AfiliadoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AfiliadoDomain> toDomainCollection(List<AfiliadoEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(entityCollection,new ArrayList<AfiliadoEntity>());
		
		return entityCollectionTmp.stream()
				.map(this::toDomain).toList();
	}

	@Override
	public AfiliadoEntity toEntity(AfiliadoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
