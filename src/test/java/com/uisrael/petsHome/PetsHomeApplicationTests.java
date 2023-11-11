package com.uisrael.petsHome;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.petsHome.modelo.entidades.Cliente;
import com.uisrael.petsHome.modelo.entidades.Mascota;
import com.uisrael.petsHome.modelo.entidades.Raza;
import com.uisrael.petsHome.modelo.entidades.TipoAnimal;
import com.uisrael.petsHome.modelo.entidades.Vacuna;
import com.uisrael.petsHome.servicio.IClienteServicio;
import com.uisrael.petsHome.servicio.IMascotaServicio;
import com.uisrael.petsHome.servicio.IRazaServicio;
import com.uisrael.petsHome.servicio.ITipoAnimalServicio;
import com.uisrael.petsHome.servicio.IVacunaServicio;

@SpringBootTest
class PetsHomeApplicationTests {

	@Autowired
	private IRazaServicio razaServicio;
	@Autowired
	private ITipoAnimalServicio tipoAnimalServicio;
	@Autowired
	private IClienteServicio clienteServicio;
	@Autowired
	private IVacunaServicio vacunaServicio;
	@Autowired
	private IMascotaServicio mascotaServicio;

	@Test
	void probarRegistroMascota() {

		/* REGISTRO DE RAZA */
		Raza raza = new Raza();

		raza.setDetalleRaza("Chihuahua");
		raza.setEstadoRaza("V");
		razaServicio.insertarRaza(raza);

		Raza raza2 = new Raza();

		raza2.setDetalleRaza("Persa");
		raza2.setEstadoRaza("V");
		razaServicio.insertarRaza(raza2);

		Raza raza3 = new Raza();

		raza3.setDetalleRaza("Cantor");
		raza3.setEstadoRaza("F");
		razaServicio.insertarRaza(raza3);

		/* REGISTRO DE TIPO ANIMAL */
		TipoAnimal tipoAnimal = new TipoAnimal();

		tipoAnimal.setDescripcionTipo("Perro");
		tipoAnimal.setEstado("F");
		tipoAnimal.setFkRaza(raza);
		tipoAnimalServicio.insertarTipoAnimal(tipoAnimal);

		TipoAnimal tipoAnimal2 = new TipoAnimal();

		tipoAnimal2.setDescripcionTipo("Gato");
		tipoAnimal2.setEstado("V");
		tipoAnimal2.setFkRaza(raza2);
		tipoAnimalServicio.insertarTipoAnimal(tipoAnimal2);

		TipoAnimal tipoAnimal3 = new TipoAnimal();

		tipoAnimal3.setDescripcionTipo("Canario");
		tipoAnimal3.setEstado("F");
		tipoAnimal.setFkRaza(raza3);
		tipoAnimalServicio.insertarTipoAnimal(tipoAnimal3);

		/* REGISTRO DE CLIENTE */
		Cliente cliente = new Cliente();

		cliente.setNombreCliente("Jeffer");
		cliente.setApellidoCliente("N");
		cliente.setEmailCliente("jm@mail.com");
		cliente.setIdentificacionCliente("1724185600");
		clienteServicio.insertarCliente(cliente);

		Cliente cliente2 = new Cliente();

		cliente2.setNombreCliente("Carlos");
		cliente2.setApellidoCliente("Perez");
		cliente2.setEmailCliente("prueba@mail.com");
		cliente2.setIdentificacionCliente("1234567890");
		clienteServicio.insertarCliente(cliente2);

		Cliente cliente3 = new Cliente();

		cliente3.setNombreCliente("Martha");
		cliente3.setApellidoCliente("Sandoval");
		cliente3.setEmailCliente("martha@mail.com");
		cliente3.setIdentificacionCliente("0987654321");
		clienteServicio.insertarCliente(cliente3);

		/* REGISTRO DE MASCOTA */
		Mascota mascota = new Mascota();

		mascota.setNombreMascota("Mandy");
		mascota.setEdadMascota(1);
		mascota.setFkCliente(cliente);
		mascota.setFkTipoAnimal(tipoAnimal);
		mascota.setFechaRegistro(new Date());
		mascotaServicio.insertarMascota(mascota);

		Mascota mascota2 = new Mascota();

		mascota2.setNombreMascota("Toby");
		mascota2.setEdadMascota(1);
		mascota2.setFkCliente(cliente);
		mascota2.setFkTipoAnimal(tipoAnimal);
		try {
			mascota2.setFechaRegistro(new SimpleDateFormat("yyyy-mm-dd").parse("2020-01-01"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		mascotaServicio.insertarMascota(mascota2);

		Mascota mascota3 = new Mascota();

		mascota3.setNombreMascota("Garfield");
		mascota3.setEdadMascota(1);
		mascota3.setFkCliente(cliente2);
		mascota3.setFkTipoAnimal(tipoAnimal2);
		try {
			mascota3.setFechaRegistro(new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		mascotaServicio.insertarMascota(mascota3);

		Mascota mascota4 = new Mascota();

		mascota4.setNombreMascota("Piolin");
		mascota4.setEdadMascota(1);
		mascota4.setFkCliente(cliente3);
		mascota4.setFkTipoAnimal(tipoAnimal3);
		try {
			mascota4.setFechaRegistro(new SimpleDateFormat("yyyy-mm-dd").parse("2024-01-01"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		mascotaServicio.insertarMascota(mascota4);

		/* REGISTRO DE VACUNA */
		Date date = new Date();
		Vacuna vacuna = new Vacuna();

		vacuna.setNombreVacuna("VAC-RAB");
		vacuna.setMotivoVacuna("Vacuna para evitar la rabia");
		vacuna.setFechaVacuna(date);
		vacuna.setFkMascota(mascota);
		vacunaServicio.insertarVacuna(vacuna);

		Vacuna vacuna2 = new Vacuna();

		vacuna2.setNombreVacuna("VAC-RBX");
		vacuna2.setMotivoVacuna("VITAMINAS");
		try {
			vacuna2.setFechaVacuna(new SimpleDateFormat("yyyy-mm-dd").parse("2024-01-01"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		vacuna2.setFkMascota(mascota2);
		vacunaServicio.insertarVacuna(vacuna2);

		Vacuna vacuna3 = new Vacuna();

		vacuna3.setNombreVacuna("VAC-RBX");
		vacuna3.setMotivoVacuna("VITAMINAS");
		try {
			vacuna3.setFechaVacuna(new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		vacuna3.setFkMascota(mascota3);
		vacunaServicio.insertarVacuna(vacuna3);

		/* LISTAR MASCOTAS */
		List<Mascota> mascotas = mascotaServicio.listarMascota();

		mascotas.forEach(a -> {
			System.out.println("ID MASCOTA: " + a.getIdMascota());
			System.out.println("NOMBRE MASCOTA: " + a.getNombreMascota());
			System.out.println("EDAD MASCOTA: " + a.getEdadMascota());
			System.out.println("ID CLIENTE: " + a.getFkCliente().getId());
			System.out.println("ID TIPO ANIMAL: " + a.getFkTipoAnimal().getId());

		});

		List<Mascota> mascotas2 = mascotaServicio.buscarMascotaPorNombre("Mandy");
		System.out.println("****** NOMBRE **********\n");
		mascotas2.forEach(a -> {
			System.out.println("ID MASCOTA: " + a.getIdMascota());
			System.out.println("NOMBRE MASCOTA: " + a.getNombreMascota());
			System.out.println("EDAD MASCOTA: " + a.getEdadMascota());
			System.out.println("ID CLIENTE: " + a.getFkCliente().getId());
			System.out.println("ID TIPO ANIMAL: " + a.getFkTipoAnimal().getId());

		});

		List<Mascota> mascotas3 = mascotaServicio.buscarMascotaPorFlitroNombre("G");
		System.out.println("****** COMIENXZA CON**********\n");
		mascotas3.forEach(a -> {
			System.out.println("EMPIEZA CON");
			System.out.println("NOMBRE MASCOTA: " + a.getNombreMascota());
			System.out.println("EDAD MASCOTA: " + a.getEdadMascota());
			System.out.println("ID CLIENTE: " + a.getFkCliente().getId());
			System.out.println("ID TIPO ANIMAL: " + a.getFkTipoAnimal().getId());

		});

		List<Mascota> mascotas4 = mascotaServicio.buscarMascotaFiltroNombreEdad("Mandy", 1);
		System.out.println("****** CONTIENE - EDAD MAYOR QUE**********\n");
		mascotas4.forEach(a -> {
			System.out.println("NOMBRE Y EDAD");
			System.out.println("NOMBRE MASCOTA: " + a.getNombreMascota());
			System.out.println("EDAD MASCOTA: " + a.getEdadMascota());
			System.out.println("ID CLIENTE: " + a.getFkCliente().getId());
			System.out.println("ID TIPO ANIMAL: " + a.getFkTipoAnimal().getId());

		});

		/* CLIENTE */
		List<Cliente> c1 = clienteServicio.buscarClientePorNombreApellido("Jeffer", "N");
		System.out.println("****** NOMBRE - APELLIDO**********\n");
		c1.forEach(a -> {

			System.out.println("NOMBRE MASCOTA: " + a.getNombreCliente());
			System.out.println("EDAD : " + a.getApellidoCliente());
			System.out.println("ID : " + a.getIdentificacionCliente());
			System.out.println("MAIL: " + a.getEmailCliente());

		});

		List<Cliente> c2 = clienteServicio.buscarClientePorCorreo("prueba@mail.com");
		System.out.println("****** CORREO**********\n");
		c2.forEach(a -> {

			System.out.println("NOMBRE MASCOTA: " + a.getNombreCliente());
			System.out.println("EDAD : " + a.getApellidoCliente());
			System.out.println("ID : " + a.getIdentificacionCliente());
			System.out.println("MAIL: " + a.getEmailCliente());

		});

		List<Cliente> c3 = clienteServicio.buscarClientePorCedula("1234567890");
		System.out.println("****** IDENTIFICACION **********\n");
		c3.forEach(a -> {

			System.out.println("NOMBRE : " + a.getNombreCliente());
			System.out.println("EDAD : " + a.getApellidoCliente());
			System.out.println("ID : " + a.getIdentificacionCliente());
			System.out.println("MAIL " + a.getEmailCliente());

		});

		/* RAZA */
		List<Raza> r1 = razaServicio.buscarRazaPordetalle("Chihuahua");
		System.out.println("****** DETALLE **********\n");
		r1.forEach(a -> {

			System.out.println("NOMBRE : " + a.getDetalleRaza());
			System.out.println("ESTADO : " + a.getEstadoRaza());

		});

		List<Raza> r2 = razaServicio.buscarRazaPordetalleEstado("Cantor", "F");
		System.out.println("****** DETALLE- ESTADO **********\n");
		r2.forEach(a -> {

			System.out.println("NOMBRE : " + a.getDetalleRaza());
			System.out.println("ESTADO : " + a.getEstadoRaza());

		});

		List<Raza> r3 = razaServicio.buscarRazaPorDetalleOrEstado("HASKI", "V");
		System.out.println("****** DETALLE O ESTADO **********\n");
		r3.forEach(a -> {

			System.out.println("NOMBRE : " + a.getDetalleRaza());
			System.out.println("ESTADO : " + a.getEstadoRaza());

		});

		/* TIPO ANIMAL */
		List<TipoAnimal> t1 = tipoAnimalServicio.buscarTipoAnimalPorTipoAnimal("PERRO");
		System.out.println("****** DETALLE **********\n");
		t1.forEach(a -> {

			System.out.println("NOMBRE : " + a.getDescripcionTipo());
			System.out.println("ESTADO : " + a.getEstado());

		});

		List<TipoAnimal> t2 = tipoAnimalServicio.buscarTipoAnimalPorTipoAnimalEstado("Canario", "F");
		System.out.println("****** DETALLE- ESTADO **********\n");
		t2.forEach(a -> {

			System.out.println("NOMBRE : " + a.getDescripcionTipo());
			System.out.println("ESTADO : " + a.getEstado());

		});

		List<TipoAnimal> t3 = tipoAnimalServicio.buscarTipoAnimalPorTipoAnimalOrEstado("Gato", "F");
		System.out.println("****** DETALLE O ESTADO **********\n");
		t3.forEach(a -> {

			System.out.println("NOMBRE : " + a.getDescripcionTipo());
			System.out.println("ESTADO : " + a.getEstado());

		});

		/* VACUNA */
		List<Vacuna> v1 = vacunaServicio.buscarVacunaPorNombre("VAC-RAB");
		System.out.println("****** NOMBRE **********\n");
		v1.forEach(a -> {

			System.out.println("NOMBRE : " + a.getNombreVacuna());
			System.out.println("MOTIVO : " + a.getMotivoVacuna());
			System.out.println("MOTIVO : " + a.getFechaVacuna());

		});

		List<Vacuna> v2;
		try {
			v2 = vacunaServicio.buscarVacunaPorNombrefecha("VAC-RBX",
					new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01"));
			System.out.println("****** NOMBRE - FECHA MAYOR QUE**********\n");
			v2.forEach(a -> {

				System.out.println("NOMBRE : " + a.getNombreVacuna());
				System.out.println("MOTIVO : " + a.getMotivoVacuna());
				System.out.println("MOTIVO : " + a.getFechaVacuna());
			});
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Vacuna> v3;
		try {
			v3 = vacunaServicio.buscarVacunaPorFiltroNombreFecha("A",
					new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01"));
			System.out.println("****** CONTIENE Y  FECHA **********\n");
			v3.forEach(a -> {

				System.out.println("NOMBRE : " + a.getNombreVacuna());
				System.out.println("MOTIVO : " + a.getMotivoVacuna());
				System.out.println("MOTIVO : " + a.getFechaVacuna());
			});
		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

}
