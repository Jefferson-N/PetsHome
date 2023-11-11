package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.petsHome.modelo.entidades.Cliente;
import com.uisrael.petsHome.modelo.entidades.Mascota;
import com.uisrael.petsHome.servicio.IClienteServicio;

@SpringBootTest
class IClienteServicioImplTest {

	@Autowired
	private IClienteServicio clienteServicio;

	@Test
	void probarCreacionCliente() {

		Cliente cliente = new Cliente();

		cliente.setNombreCliente("Jeffer");
		cliente.setApellidoCliente("N");
		cliente.setEmailCliente("jmnorona@mail.com");
		cliente.setIdentificacionCliente("1724185600");

		clienteServicio.insertarCliente(cliente);

	}

	@Test
	void probarListarcCLientes() {

		List<Cliente> clientes;
		clientes = clienteServicio.listarCliente();

		// System.err.println(clientes.get(0).getApellidoCliente());

		clientes.forEach(a -> {
			System.out.println("*********Cliente: " + a.getId() + " *******");
			System.out.println(a.getIdentificacionCliente());
			System.out.println(a.getApellidoCliente());
			System.out.println(a.getNombreCliente());
			System.out.println(a.getEmailCliente());
		});


	}

}
