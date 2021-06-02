package com.patricio.contreras.GastosBackend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "locales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Local implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_local",unique=true)
	@Size(min=6, max=60)
	private String nombreLocal;
	
	@Column(nullable = false)
	@Size(min=4, max=45)
	private String ciudad;
	
	/*@OneToMany(mappedBy = "local")
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
	private List<Gasto> gastos;*/
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
