package com.uisrael.petsHome.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ph_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cl_id")
	private int id;

	@Column(name = "cl_identificacion", length = 10)
	private String identificacionCliente;
	@Column(name = "cl_nombre", length = 45)
	private String nombreCliente;
	@Column(name = "cl_apellido", length = 45)
	private String apellidoCliente;
	@Column(name = "cl_email", length = 45)
	private String emailCliente;

	@OneToMany(mappedBy = "fkCliente")
	private List<Mascota> mascota = new ArrayList<>();

}
