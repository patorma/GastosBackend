package com.patricio.contreras.GastosBackend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patricio.contreras.GastosBackend.models.entity.Local;
import com.patricio.contreras.GastosBackend.models.services.ILocalService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class LocalRestController {
	
	@Autowired
	private ILocalService localService;
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/locales")
	public List<Local> index(){
		
		return localService.findAll();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/locales/page/{page}")
	public Page<Local> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return localService.findAll(pageable);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/locales/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Local local = null;
		
		Map<String, Object> response  = new HashMap<>();
		
		try {
			local = localService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(local == null) {
			response.put("mensaje", "El local con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Local>(local,HttpStatus.OK);
		
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/locales")
	public ResponseEntity<?> create(@Valid @RequestBody Local local,BindingResult result){
		
		Local localNew = null;
		Map<String, Object> response = new HashMap<>();
		
		// se valida si contiene errores el objeto 
		if(result.hasErrors()) {
			// se debe obtener los mensajes de errror de cada campo 
			// y convertir estos en una lista de errores de tipo string
			// se debe convertir esta lista de fielderrors en String
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() + "' "+err.getDefaultMessage())//muy parecido  al operador map en angular (rxjs), mismo concepto!
					.collect(Collectors.toList());// ahora podemos convertir de regreso el stream  aun tipo List
			response.put("errors", errors);
			// se responde con un responseentity con listados de error
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			// en lo anterior se recibe un field errors y lo convertimos a string
		}
		
		try {
			
			localNew = localService.save(local);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		//se podria pasar un map con un mensaje y con el local creado
		response.put("mensaje", "El local ha sido creado con éxito! ");
		response.put("local",localNew);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/locales/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Local local,BindingResult result,@PathVariable Long id){
		//obtenemos el local que queremos modificar de la bd por Id
		Local localActual = localService.findById(id);
		
		//Local ya actualizado
		Local localUpdated = null;
		
		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {
			// se debe obtener los mensajes de errror de cada campo 
			// y convertir estos en una lista de errores de tipo string
			
			// se debe convertir esta lista de fielderrors en String
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '"+ err.getField() + "' "+err.getDefaultMessage())// muy parecido  al operador map en angular (rxjs), mismo concepto!
					.collect(Collectors.toList());// ahora podemos convertir de regreso el stream  aun tipo List
			response.put("errors", errors);
			// se responde con un responseentity con listados de error
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
			
			// en lo anterior se recibe un field errors y lo convertimos a string
		}
		
		if(localActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el local con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			//modificamos los datos del local actual con los datos del gasto que te envien
			localActual.setNombreLocal(local.getNombreLocal());
			localActual.setCiudad(local.getCiudad());
			
			localUpdated = localService.save(localActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el local en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El local ha sido actualizado con éxito!");
		response.put("local",localUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED) ;
		
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/locales/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		Map<String, Object> response = new HashMap<>();
		try {
			
			localService.delete(id);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el local de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El local fue eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	

}
