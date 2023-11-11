package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.uisrael.petsHome.modelo.entidades.TipoAnimal;
import com.uisrael.petsHome.servicio.ITipoAnimalServicio;

@SpringBootTest
class ITipoAnimalServicioImplTest {
	@Autowired
	private ITipoAnimalServicio tipoAnimalServicio;

	@Test
	@Order(1)
	void probarCreacionraza() {

		TipoAnimal tipoAnimal = new TipoAnimal();

		tipoAnimal.setDescripcionTipo("Chihuahua");
		tipoAnimal.setEstado("V");

		tipoAnimalServicio.insertarTipoAnimal(tipoAnimal);

	}

	@Test
	@Order(2)
	void probarListartipoAnimal() {

		List<TipoAnimal> tipoAnimal;
		tipoAnimal = tipoAnimalServicio.listarTipoAnimal();

		tipoAnimal.forEach(a -> {
			System.out.println("*********Tipo Animal: " + a.getId() + " *******");
			System.out.println(a.getDescripcionTipo());
			System.out.println(a.getEstado());
		});

	}

}
