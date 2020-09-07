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

import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;
import com.patricio.contreras.GastosBackend.models.services.ITipoGastoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class TipoGastoRestController {

	@Autowired
	private ITipoGastoService tipoGastoService;
	
	@GetMapping("/tipogastos")
	public List<TipoGasto> index(){
		return tipoGastoService.findAll();
	}
	
	@GetMapping("/tipogastos/page/{page}")
	public Page<TipoGasto> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return tipoGastoService.findAll(pageable);
	}
	
	@GetMapping("/tipogastos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		TipoGasto tipoGasto = null;
		Map<String, Object> response  = new HashMap<>();
		
		try {
			tipoGasto = tipoGastoService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(tipoGasto == null) {
			response.put("mensaje", "El tipo de gasto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TipoGasto>(tipoGasto,HttpStatus.OK);
	}
	
	@PostMapping("/tipogastos")
	public ResponseEntity<?> create(@Valid @RequestBody TipoGasto tipoGasto,BindingResult result){
		
		TipoGasto tipoGastoNew = null;
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
			tipoGastoNew = tipoGastoService.save(tipoGasto); 
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//se podria pasar un map con un mensaje y con el tipo gasto creado
				response.put("mensaje", "El tipo de gasto ha sido creado con éxito! ");
				response.put("Tipo Gasto",tipoGastoNew);
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/tipogastos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody TipoGasto tipoGasto,BindingResult result, @PathVariable Long id){
		
		TipoGasto tipoGastoActual = tipoGastoService.findById(id);
		
		TipoGasto tipoGastoUpdated = null;
		
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
		
		if(tipoGastoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el tipo de gasto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			tipoGastoActual.setNombre(tipoGasto.getNombre());
			
			tipoGastoUpdated = tipoGastoService.save(tipoGastoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el tipo de gasto en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El tipo de gasto ha sido actualizado con éxito!");
		response.put("tipo gasto", tipoGastoUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED) ;
	}
	
	@DeleteMapping("/tipogastos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		//Map para guardar el contenido que enviaremos en el ResponseEntity con mensajes
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoGastoService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el tipo de gasto de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El tipo de gasto fue eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
}
