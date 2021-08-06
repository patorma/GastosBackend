package com.patricio.contreras.GastosBackend.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "notas")
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Nota implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique=true)
	@Size(min=10, max=50)
	@NotEmpty 
	private String titulo;
	
	@Column(nullable = false)
	@Size(min=30, max=400)
	@NotEmpty 
	private String descripcion;
	
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Estados estado;
	
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	
	@PrePersist
	public void prePersit() {
		fechaCreacion= LocalDate.now();
	}
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}








	public void setId(Long id) {
		this.id = id;
	}








	public String getTitulo() {
		return titulo;
	}








	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}








	public String getDescripcion() {
		return descripcion;
	}








	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}








	public Estados getEstado() {
		return estado;
	}








	public void setEstado(Estados estado) {
		this.estado = estado;
	}








	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}








	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}








	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
