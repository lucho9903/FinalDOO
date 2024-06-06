
package co.edu.uco.deviucopay.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.deviucopay.business.facade.impl.cuenta.ConsultarCuentaFacade;
import co.edu.uco.deviucopay.business.facade.impl.cuenta.RegistrarCuentaFacade;
import co.edu.uco.deviucopay.controller.response.CuentaResponse;
import co.edu.uco.deviucopay.crosscutting.exceptions.DeviUcopayException;
import co.edu.uco.deviucopay.dto.CuentaDTO;

@RestController
@RequestMapping("/api/v1/cuenta")
public class CuentaController {

	@GetMapping("/dummy")
	public CuentaDTO dummy() {
		return CuentaDTO.build();
	}

	@GetMapping
	public ResponseEntity<CuentaResponse> consultar() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var cuentaResponse = new CuentaResponse();

		try {
			var cuentaDto = CuentaDTO.build();
			var facade = new ConsultarCuentaFacade();
			
			cuentaResponse.setDatos(facade.execute(cuentaDto));
			cuentaResponse.getMensajes().add("Ciudades Consultadas Exitosamente");
			

		} catch (final DeviUcopayException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			cuentaResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de consultar la informacion de la ciudad";
			cuentaResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(cuentaResponse, httpStatusCode);

	}
	
	@PostMapping
	public ResponseEntity<CuentaResponse> crear(@RequestBody CuentaDTO ciudad) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var cuentaResponse = new CuentaResponse();

		try {
			var facade = new RegistrarCuentaFacade();
			facade.excute(ciudad);
			cuentaResponse.getMensajes().add("Ciudades creada Exitosamente");
			

		} catch (final DeviUcopayException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			cuentaResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de crear la nueva ciudad";
			cuentaResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<CuentaResponse>(cuentaResponse, httpStatusCode);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CuentaResponse> eliminar(@PathVariable UUID id ) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var cuentaResponse = new CuentaResponse();

		try {
			//var facade = new EliminarCiudadFacade();
			//facade.execute(id);
			cuentaResponse.getMensajes().add("Ciudades eliminada Exitosamente");
			

		} catch (final DeviUcopayException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			cuentaResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la informacion de ciudad";
			cuentaResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<CuentaResponse>(cuentaResponse, httpStatusCode);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CuentaResponse> modificar(@PathVariable UUID id,
			@RequestBody CuentaDTO cuentaDto ) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var cuentaResponse = new CuentaResponse();

		try {
			cuentaDto.setId(id);
//			var facade = new ModificarCiudadFacade();
			
//			facade.execute(id);
			cuentaResponse.getMensajes().add("Ciudades Modificada Exitosamente");
			

		} catch (final DeviUcopayException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			cuentaResponse.getMensajes().add(excepcion.getMensajeUsuario());

			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de Modificar la informacion de ciudad";
			cuentaResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<CuentaResponse>(cuentaResponse, httpStatusCode);

	}

}
