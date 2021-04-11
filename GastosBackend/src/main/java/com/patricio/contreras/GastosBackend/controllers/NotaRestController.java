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

import com.patricio.contreras.GastosBackend.models.entity.Nota;
import com.patricio.contreras.GastosBackend.models.services.INotaService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class NotaRestController {

	@Autowired
	private INotaService notaService;
	
	@GetMapping("/notas")
	public List<Nota> index(){
		return notaService.findAll();
	}
	
	@GetMapping("/notas/page/{page}")
	public Page<Nota> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return notaService.findAll(pageable);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/notas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Nota nota = null;
		Map<String, Object> response  = new HashMap<>();
		try {
			nota = notaService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(nota == null) {
			response.put("mensaje", "La nota con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Nota>(nota,HttpStatus.OK);
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/notas")
	public ResponseEntity<?> create(@Valid @RequestBody Nota nota,BindingResult result){
		// es la nota creada
		Nota notaNew = null;
		
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
			notaNew = notaService.save(nota);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//se podria pasar un map con un mensaje y con el gasto creado
		response.put("mensaje", "La nota ha sido creada con éxito! ");
		response.put("nota",notaNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@Secured("ROLE_ADMIN")
	@PutMapping("/notas/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Nota nota,BindingResult result,@PathVariable Long id){
		//obtenemos la nota que queremos modificar de la bd por Id
		Nota notaActual = notaService.findById(id);
		
		//Nota ya actualizada
		Nota notaUpdated = null;
		
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
		
		if(notaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la nota con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			//modificamos los datos de la nota actual con los datos del gasto que te envien
			notaActual.setTitulo(nota.getTitulo());
			notaActual.setDescripcion(nota.getDescripcion());
			notaActual.setEstado(nota.getEstado());
			
			notaUpdated = notaService.save(notaActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la nota en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La nota ha sido actualizada con éxito!");
		response.put("nota",notaUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED) ;
	}
	
	@Secured("ROLE_ADMIN")
	@DeleteMapping("notas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		//Map para guardar el contenido que enviaremos en el ResponseEntity con mensajes
		Map<String, Object> response = new HashMap<>();
		
		try {
			notaService.delete(id);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la nota de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La nota fue eliminada con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
}
