package com.patricio.contreras.GastosBackend.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
public class Local implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre_local",nullable = false)
	@Size(min=10, max=50)
	private String nombreLocal;
	
	@Column(nullable = false)
	private String ciudad;

	
	
	
	
	
	
	
	
	
	
	private static final long serialVersionUID = 1L;

}
