package co.edu.uco.deviucopay.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.deviucopay.business.assembler.entity.AssemblerEntity;
import co.edu.uco.deviucopay.business.domain.TipoIdentificacionDomain;
import co.edu.uco.deviucopay.crosscutting.helpers.ObjectHelper;
import co.edu.uco.deviucopay.entity.TipoIdentificacionEntity;

public class TipoIdentificacionAssemblerEntity implements AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity>{

	private static final AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity> instance = new TipoIdentificacionAssemblerEntity();


	private TipoIdentificacionAssemblerEntity() {
		super();
	}
	public static final AssemblerEntity<TipoIdentificacionDomain, TipoIdentificacionEntity> getInstance(){
		return instance; 
		
	}	
	@Override
	public TipoIdentificacionDomain toDomain(TipoIdentificacionEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoIdentificacionDomain> toDomainCollection(final List<TipoIdentificacionEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(entityCollection,new ArrayList<TipoIdentificacionEntity>());
		
		return entityCollectionTmp.stream()
				.map(this::toDomain).toList();
	}

	@Override
	public TipoIdentificacionEntity toEntity(TipoIdentificacionDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
