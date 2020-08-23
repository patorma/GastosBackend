package com.patricio.contreras.GastosBackend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@OneToMany(mappedBy = "tipo",cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
	private List<Gasto> gastos;
	
	
	private static final long serialVersionUID = 1L;

}
