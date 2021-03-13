package com.patricio.contreras.GastosBackend.models.entity;
import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "gastos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Gasto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min=3, max=50)
	@NotEmpty 
	@Column(nullable = false,unique=true) 
	private String nombre;
	
	@Column(nullable = false)  
	private int valor;
	
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Tipos tipo;
	
	@Column(nullable = false)
	@NotEmpty  
	@Size(min=30, max=400)
	private String descripcion;
	
	/*@Column(nullable = false)
	@NotNull(message = "no puede estar vacio")
	private int cantidad;*/
	
	/*@Column(name = "nombre_local")
	@Size(min=6, max=60)
	private String nombreLocal;
	
	@Column(nullable = false)
	@Size(min=4, max=45)
	private String ciudad;*/
	
	@Column(name = "fecha_gasto")
	@NotNull(message = "no puede estar vacio")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
