package com.patricio.contreras.GastosBackend.models.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "detalles_gastos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class DetalleGasto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Size(min=30, max=400)
	private String descripcion;
	
	@Column(nullable = false)
	private int cantidad;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gasto_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
    private Gasto gasto;
	
	@NotNull(message = "no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","hadler"})
	private TipoGasto tipo;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="detalles_gastos_locales",joinColumns = @JoinColumn(name = "detalle_id")
	,inverseJoinColumns  = @JoinColumn(name="local_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"detalle_id","local_id"})})
	private List<Local> locales;
	
	
	
	private static final long serialVersionUID = 1L;

}
