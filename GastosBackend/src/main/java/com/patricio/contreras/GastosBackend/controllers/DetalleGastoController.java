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

import com.patricio.contreras.GastosBackend.models.entity.DetalleGasto;
import com.patricio.contreras.GastosBackend.models.entity.Gasto;
import com.patricio.contreras.GastosBackend.models.entity.Local;
import com.patricio.contreras.GastosBackend.models.entity.TipoGasto;
import com.patricio.contreras.GastosBackend.models.services.IDetalleGastoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class DetalleGastoController {

	@Autowired
	private IDetalleGastoService detalleGastoService;
	
	@GetMapping("/detalles")
	public List<DetalleGasto> index(){
		
		return detalleGastoService.findAll();
	}
	
	@GetMapping("/detalles/page/{page}")
	public Page<DetalleGasto> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return detalleGastoService.findAll(pageable);
	}
	
	@GetMapping("/detalles/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		DetalleGasto detalleGasto = null;
		
		Map<String, Object> response  = new HashMap<>();
		try {
			detalleGasto = detalleGastoService.findById(id);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(detalleGasto == null) {
			response.put("mensaje", "El detalle del gasto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<DetalleGasto>(detalleGasto,HttpStatus.OK);
		
	}
	
	@PostMapping("/detalles")
	public ResponseEntity<?> create(@Valid @RequestBody DetalleGasto detalleGasto,BindingResult result ){
		// es el nuevo detalle del gasto creado
		DetalleGasto detalleGastoNew = null;
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
		    	 detalleGastoNew = detalleGastoService.save(detalleGasto);
		    	 
		     }catch(DataAccessException e) {
					response.put("mensaje", "Error al realizar el insert en la base de datos!");
					response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}
		     
		 	//se podria pasar un map con un mensaje y con el detalle del gasto creado
				response.put("mensaje", "El detalle del gasto ha sido creado con éxito! ");
				response.put("detalle", detalleGastoNew);
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/detalles/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody DetalleGasto detalleGasto,BindingResult result,@PathVariable Long id){
		
		//obtenemos el detalle del gasto que queremos modificar de la bd por Id
		DetalleGasto detalleGastoActual = detalleGastoService.findById(id);
		
		//Detalle del gasto ya actualizado
		DetalleGasto detalleGastoupdated = null;
		
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
		
		if(detalleGastoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el detalle del gasto con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			//modificamos los datos del detalle del gasto actual con los datos que te envien
			detalleGastoActual.setDescripcion(detalleGasto.getDescripcion());
			detalleGastoActual.setCantidad(detalleGasto.getCantidad());
			detalleGastoActual.setTipo(detalleGasto.getTipo());
			detalleGastoActual.setLocales(detalleGasto.getLocales());
			detalleGastoActual.setGasto(detalleGasto.getGasto());
			
			detalleGastoupdated = detalleGastoService.save(detalleGastoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el detalle del gasto en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El detalle del gasto ha sido actualizado con éxito!");
		response.put("detalle",detalleGastoupdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED) ;
		
	}
	
	@DeleteMapping("/detalles/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			detalleGastoService.delete(id);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el detalle del gasto de la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El detalle del gasto fue eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/detalle/tipos")
	public List<TipoGasto> listarTipos(){
		return detalleGastoService.findAllTipos();
	}
	
	@GetMapping("/detalle/gastos")
	public List<Gasto> listarGasto(){
		return detalleGastoService.findAllGastos();
	
	}
	@GetMapping("/detalle/locales")
	public List<Local> listarLocales(){
		return detalleGastoService.findAllLocales();
	}
}
