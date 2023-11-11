package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.petsHome.modelo.entidades.Mascota;
import com.uisrael.petsHome.modelo.repositorio.IMascotaRepositorio;
import com.uisrael.petsHome.servicio.IMascotaServicio;

@Service
@Component
public class IMascotaServicioImpl implements IMascotaServicio {

	@Autowired
	private IMascotaRepositorio mascotaRepositorio;

	@Override
	public void insertarMascota(Mascota mascota) {
		try {
			mascotaRepositorio.save(mascota);
		} catch (Exception e) {
			System.err.println("Error al insertar Mascota " + mascota.getNombreMascota() + " " + e.getMessage());
		}
	}

	@Override
	public List<Mascota> listarMascota() {

		return mascotaRepositorio.findAll();
	}

	@Override
	public List<Mascota> buscarMascotaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return mascotaRepositorio.buscarMascotaPorFlitroNombre(nombre);
	}

	@Override
	public List<Mascota> buscarMascotaPorFlitroNombre(String filtro) {
		// TODO Auto-generated method stub
		return mascotaRepositorio.buscarMascotaPorFlitroNombre(filtro);
	}

	@Override
	public List<Mascota> buscarMascotaFiltroNombreEdad(String filtro, int edad) {
		// TODO Auto-generated method stub
		return mascotaRepositorio.buscarMascotaFiltroNombreEdad(filtro, edad);
	}

	@Override
	public Mascota buscarMascotaId(int id) {
		// TODO Auto-generated method stub
		return mascotaRepositorio.buscarMascotaId(id);
	}

	@Override
	public void eliminarMascota(Mascota mascota) {
		// TODO Auto-generated method stub
		mascotaRepositorio.delete(mascota);
	}






}
