package com.uisrael.petsHome.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ph_mascota")
public class Mascota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_id")
	private int idMascota;

	@Column(name = "ma_nombre", length = 45)
	private String nombreMascota;

	@Column(name = "ma_edad")
	private int edadMascota;

	@Column(name = "ma_fecha_registro")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaRegistro;

	@ManyToOne
	@JoinColumn(name = "fkCliente")
	private Cliente fkCliente;

	@ManyToOne
	@JoinColumn(name = "fkTipoAnimal")
	private TipoAnimal fkTipoAnimal;

	@OneToMany(mappedBy = "fkMascota")
	private List<Vacuna> vacuna = new ArrayList<>();
}
