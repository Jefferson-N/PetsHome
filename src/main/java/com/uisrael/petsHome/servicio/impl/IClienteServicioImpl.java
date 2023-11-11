package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.petsHome.modelo.entidades.Cliente;
import com.uisrael.petsHome.modelo.repositorio.IClienteRepositorio;
import com.uisrael.petsHome.servicio.IClienteServicio;

@Service
@Component
public class IClienteServicioImpl implements IClienteServicio {

	@Autowired
	private IClienteRepositorio clienteRepositorio;

	@Override
	public void insertarCliente(Cliente cliente) {

		try {
			clienteRepositorio.save(cliente);

		} catch (Exception e) {
			System.err
					.println("Error al insertar cliente " + cliente.getIdentificacionCliente() + " " + e.getMessage());
		}

	}

	@Override
	public List<Cliente> listarCliente() {

		return clienteRepositorio.findAll();
	}

	@Override
	public List<Cliente> buscarClientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		return clienteRepositorio.buscarClientePorCedula(cedula);
	}

	@Override
	public List<Cliente> buscarClientePorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return clienteRepositorio.buscarClientePorNombreApellido(nombre, apellido);
	}

	@Override
	public List<Cliente> buscarClientePorCorreo(String email) {
		// TODO Auto-generated method stub
		return clienteRepositorio.buscarClientePorCorreo(email);
	}

	@Override
	public Cliente buscarClientePorId(int id) {
		// TODO Auto-generated method stub
		return clienteRepositorio.buscarClientePorId(id);
	}

	@Override
	public void eliminarCliente(Cliente cliente) {
		
		clienteRepositorio.delete(cliente);
		
	}

}
