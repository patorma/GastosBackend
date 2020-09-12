package com.patricio.contreras.GastosBackend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.patricio.contreras.GastosBackend.models.entity.Ciudad;
import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;
import com.patricio.contreras.GastosBackend.models.services.IGastoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class GastoRestController {
	
	@Autowired
	private IGastoService gastoService;
	
	@GetMapping("/gastos")
	public List<Gasto> index(){
		return gastoService.findAll();
		
	}
	
	@GetMapping("/gastos/page/{page}")
	public Page<Gasto> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return gastoService.findAll(pageable);
	}
	
	@GetMapping("/gastos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Gasto gasto = null;
		Map<String, Object> response  = new HashMap<>();
		try {
			gasto = gastoService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(gasto == null) {
			response.put("mensaje", "El gasto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Gasto>(gasto,HttpStatus.OK);
	}
	
	@PostMapping("/gastos")
	public ResponseEntity<?> create(@Valid @RequestBody Gasto gasto,BindingResult result){
		// es el nuevo gasto creado
		Gasto gastoNew = null;
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
			gastoNew = gastoService.save(gasto);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//se podria pasar un map con un mensaje y con el gasto creado
		response.put("mensaje", "El gasto ha sido creado con éxito! ");
		response.put("gasto",gastoNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/gastos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Gasto gasto,BindingResult result,@PathVariable Long id){
		
		//obtenemos el gasto que queremos modificar de la bd por Id
		Gasto gastoActual = gastoService.findById(id);
		
		//Gasto ya actualizado
		Gasto gastoUpdated = null;
		
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
		
		if(gastoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el gasto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			//modificamos los datos del gasto actual con los datos del gasto que te envien
			gastoActual.setNombre(gasto.getNombre());
			gastoActual.setDescripcion(gasto.getDescripcion());
			gastoActual.setFecha(gasto.getFecha());
			gastoActual.setLocal(gasto.getLocal());
			gastoActual.setValor(gasto.getValor());
			gastoActual.setTipo(gasto.getTipo());
			gastoActual.setCiudad(gasto.getCiudad());
			
			gastoUpdated = gastoService.save(gastoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el gasto en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El gasto ha sido actualizado con éxito!");
		response.put("gasto",gastoUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED) ;
	}
	
	@DeleteMapping("/gastos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		//Map para guardar el contenido que enviaremos en el ResponseEntity con mensajes
		Map<String, Object> response = new HashMap<>();
		try {
			gastoService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el gasto de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El gasto fue eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
			
	}
	
	@GetMapping("/gastos/tipos")
	public List<TipoGasto> listarTipos(){
		return gastoService.findAllTipos();
	}
	
	@GetMapping("/gastos/ciudades")
	public List<Ciudad> listarCiudades(){
		return gastoService.findAllCiudades();
	}

}
