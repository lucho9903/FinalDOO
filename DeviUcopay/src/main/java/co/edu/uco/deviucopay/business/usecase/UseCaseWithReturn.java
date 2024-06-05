package co.edu.uco.deviucopay.business.usecase;

public interface UseCaseWithReturn<T, R> {
	
	R execute (T data);

}

