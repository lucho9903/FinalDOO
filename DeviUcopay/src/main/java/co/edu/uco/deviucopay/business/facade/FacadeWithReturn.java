package co.edu.uco.deviucopay.business.facade;

public interface FacadeWithReturn<T, K> {
	
	K execute(T dto);

}