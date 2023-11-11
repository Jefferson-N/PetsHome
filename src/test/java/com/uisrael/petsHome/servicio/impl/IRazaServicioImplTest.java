package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.uisrael.petsHome.modelo.entidades.Raza;
import com.uisrael.petsHome.servicio.IRazaServicio;

@SpringBootTest
class IRazaServicioImplTest {

	@Autowired
	private IRazaServicio razaServicio;

	@Test
	@Order(1)
	void probarCreacionraza() {

		Raza raza = new Raza();

		raza.setDetalleRaza("Chihuahua");
		raza.setEstadoRaza("V");

		razaServicio.insertarRaza(raza);

	}

	@Test
	@Order(2)
	void probarListarrazas() {

		List<Raza> razas;
		razas = razaServicio.listarRaza();

		razas.forEach(a -> {
			System.out.println("*********Raza: " + a.getIdRaza() + " *******");
			System.out.println(a.getDetalleRaza());
			System.out.println(a.getEstadoRaza());
		});

	}

}
