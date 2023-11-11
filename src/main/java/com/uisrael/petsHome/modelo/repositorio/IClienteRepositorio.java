package com.uisrael.petsHome.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.modelo.entidades.Cliente;

@Repository
@Component
public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {

	@Query("select c  from Cliente c  where c.identificacionCliente = ?1")
	public List<Cliente> buscarClientePorCedula(String cedula);

	@Query("select  c  from Cliente c where c.nombreCliente = :nombre and c.apellidoCliente = :apellido ")
	public List<Cliente> buscarClientePorNombreApellido(@Param("nombre") String nombre,
			@Param("apellido") String apellido);

	@Query("select  c  from Cliente c  where c.emailCliente = ?1")
	public List<Cliente> buscarClientePorCorreo(String email);

	@Query("select c from Cliente c where c.id= ?1")
	public Cliente buscarClientePorId(int id);

}
