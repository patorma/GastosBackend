package com.patricio.contreras.GastosBackend.models.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@Column(nullable = false)
	@Size(min=10, max=50)
	private String nombre;
	
	@Column(nullable = false)
	@Size(min=30, max=400)
	private String descripcion;
	
	@Column(nullable = false)
	private int cantidad;
	
	
	@Column(nullable = false)
	private int valor;
	
	@Column(name = "fecha_gasto")
	@NotNull(message = "no puede estar vacio")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@NotNull(message = "no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
	private TipoGasto tipo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
