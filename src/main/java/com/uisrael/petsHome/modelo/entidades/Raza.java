package com.uisrael.petsHome.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ph_raza")
public class Raza implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ra_id")
	private int idRaza;

	@Column(name = "ra_detalle", length = 45)
	private String detalleRaza;
	@Column(name = "ra_estado", length = 1)
	private String estadoRaza;
	// @ToString.Exclude
	@OneToMany(mappedBy = "fkRaza")
	private List<TipoAnimal> tipoAnimal;

}
