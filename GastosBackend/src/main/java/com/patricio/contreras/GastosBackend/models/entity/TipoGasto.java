package com.patricio.contreras.GastosBackend.models.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "tipo_gastos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class TipoGasto implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 50)
	private String tipo;
	
	
	private static final long serialVersionUID = 1L;

}
