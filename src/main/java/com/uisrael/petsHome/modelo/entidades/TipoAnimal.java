package com.uisrael.petsHome.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ph_tipo_animal")
public class TipoAnimal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ta_id")
	private int id;

	@Column(name = "ta_nombre", length = 45)
	private String descripcionTipo;
	@Column(name = "ta_estado", length = 1)
	private String estado;

	@ManyToOne
	@JoinColumn(name = "fkRaza")
	private Raza fkRaza;

	@OneToMany(mappedBy = "fkTipoAnimal")
	private List<Mascota> mascota = new ArrayList<>();

}
