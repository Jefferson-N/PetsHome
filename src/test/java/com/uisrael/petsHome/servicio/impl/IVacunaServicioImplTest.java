package com.uisrael.petsHome.servicio.impl;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.uisrael.petsHome.modelo.entidades.Vacuna;
import com.uisrael.petsHome.servicio.IVacunaServicio;

@SpringBootTest
class IVacunaServicioImplTest {
	@Autowired
	private IVacunaServicio vacunaServicio;

	@Test
	@Order(1)
	void probarCreacionraza() {

		Date date = new Date();
		Vacuna vacuna = new Vacuna();

		vacuna.setNombreVacuna("Vac. para Rabia");
		vacuna.setMotivoVacuna("Vacuna para evitar la rabia");
		vacuna.setFechaVacuna(date);

		vacunaServicio.insertarVacuna(vacuna);

	}

	@Test
	@Order(2)
	void probarListarrazas() {

		List<Vacuna> vacunas;
		vacunas = vacunaServicio.listarVacuna();

		vacunas.forEach(a -> {
			System.out.println("*********Vacuna: " + a.getId() + " *******");
			System.out.println(a.getNombreVacuna());
			System.out.println(a.getFkMascota());
			System.out.println(a.getFechaVacuna());

		});

	}

}
