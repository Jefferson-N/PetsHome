package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.petsHome.modelo.entidades.Mascota;
import com.uisrael.petsHome.servicio.IMascotaServicio;

@SpringBootTest
class IMascotaServicioImplTest {

	@Autowired
	private IMascotaServicio mascotaServicio;

	@Test
	@org.springframework.core.annotation.Order(1)
	void probarCreacionMascota() {

		Mascota mascota = new Mascota();

		mascota.setNombreMascota("Mandy");
		mascota.setEdadMascota(1);

		mascotaServicio.insertarMascota(mascota);

	}

	@Test
	@org.springframework.core.annotation.Order(2)
	void probarListarMascotas() {

		List<Mascota> mascotas;
		mascotas = mascotaServicio.listarMascota();

		mascotas.forEach(a -> {
			System.out.println("*********Mascota: " + a.getIdMascota() + " *******");
			System.out.println(a.getNombreMascota());
			System.out.println(a.getEdadMascota());
			System.out.println(a.getFkCliente());
			System.out.println(a.getFkTipoAnimal());
			System.out.println(a.getVacuna());
		});

	}

}
