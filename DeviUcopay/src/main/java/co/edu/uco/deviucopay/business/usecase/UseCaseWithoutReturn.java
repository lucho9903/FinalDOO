package co.edu.uco.deviucopay.business.usecase;

public interface UseCaseWithoutReturn <T> {
	
	void execute(T data);
}