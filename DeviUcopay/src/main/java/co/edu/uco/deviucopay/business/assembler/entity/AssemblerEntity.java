package co.edu.uco.deviucopay.business.assembler.entity;

import java.util.List;

import co.edu.uco.deviucopay.business.assembler.Assembler;

public interface AssemblerEntity<D, K > extends Assembler<D, K> {
	
	K toEntity(D domain);
	
	List<K> toEntityCollection(List<D> domainCollection);
}
