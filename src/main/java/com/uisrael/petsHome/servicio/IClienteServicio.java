package com.uisrael.petsHome.servicio;

import java.util.List;

import com.uisrael.petsHome.modelo.entidades.Cliente;

public interface IClienteServicio {

	public void insertarCliente(Cliente cliente);

	public List<Cliente> listarCliente();

	public List<Cliente> buscarClientePorCedula(String cedula);

	public List<Cliente> buscarClientePorNombreApellido(String nombre, String apellido);

	public List<Cliente> buscarClientePorCorreo(String email);

	public Cliente buscarClientePorId(int id);

	public void eliminarCliente(Cliente cliente);
}
