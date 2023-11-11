package com.uisrael.petsHome.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "ph_vacuna")
public class Vacuna implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "va_id")
	private int id;

	@Column(name = "va_nombre", length = 45)
	private String nombreVacuna;

	@Column(name = "va_motivo", length = 255)
	private String motivoVacuna;

	@Column(name = "va_fecha_vacuna")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaVacuna;

	@ManyToOne
	@JoinColumn(name = "fkMascota")
	private Mascota fkMascota;
}
