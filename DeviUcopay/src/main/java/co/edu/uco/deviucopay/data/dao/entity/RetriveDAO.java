package co.edu.uco.deviucopay.data.dao.entity;

import java.util.List;

interface RetriveDAO <E>{
	List<E>  consultar(E data);
	

}
