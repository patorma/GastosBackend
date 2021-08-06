package com.patricio.contreras.GastosBackend.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "tipos_gastos")

@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class TipoGasto implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotEmpty  
	@Size(min=4, max=90)
	private String tipo;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getTipo() {
		return tipo;
	}






	public void setTipo(String tipo) {
		this.tipo = tipo;
	}






	private static final long serialVersionUID = 1L;

}
