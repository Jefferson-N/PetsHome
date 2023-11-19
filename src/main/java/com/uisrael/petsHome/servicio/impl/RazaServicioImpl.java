package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.petsHome.modelo.entidades.Raza;
import com.uisrael.petsHome.modelo.repositorio.IRazaRepositorio;
import com.uisrael.petsHome.servicio.IRazaServicio;

@Service
@Component
public class IRazaServicioImpl implements IRazaServicio {

	@Autowired
	private IRazaRepositorio razaRepositorio;

	@Override
	public void insertarRaza(Raza raza) {
		try {
			razaRepositorio.save(raza);
		} catch (Exception e) {
			System.err.println("Error al insertar raza " + raza.getDetalleRaza() + " " + e.getMessage());
		}

	}

	@Override
	public List<Raza> listarRaza() {

		return razaRepositorio.findAll();
	}

	@Override
	public List<Raza> buscarRazaPordetalle(String detalle) {
		
		return razaRepositorio.buscarRazaPordetalle(detalle);
	}

	@Override
	public List<Raza> buscarRazaPordetalleEstado(String detalle, String estado) {
		
		return razaRepositorio.buscarRazaPordetalleEstado(detalle, estado);
	}

	@Override
	public List<Raza> buscarRazaPorDetalleOrEstado(String detalle, String estado) {
		
		return razaRepositorio.buscarRazaPorDetalleOrEstado(detalle, estado);
	}

	@Override
	public Raza buscarRazaId(int id) {
		
		return razaRepositorio.buscarRazaId(id);
	}

	@Override
	public List<Raza> buscarRazaEstado(String estado) {
		
		return razaRepositorio.buscarRazaEstado(estado);
	}

	@Override
	public void eliminarRaza(Raza raza) {
		
		razaRepositorio.delete(raza);
		
	}

}
