package com.uisrael.petsHome.servicio;

import java.util.List;

import com.uisrael.petsHome.modelo.entidades.Mascota;

public interface IMascotaServicio {

	public void insertarMascota(Mascota mascota);

	public List<Mascota> listarMascota();

	public List<Mascota> buscarMascotaPorNombre(String nombre);

	public List<Mascota> buscarMascotaPorFlitroNombre(String filtro);

	public List<Mascota> buscarMascotaFiltroNombreEdad(String filtro, int edad);
	
	public Mascota buscarMascotaId(int id);
	
	public void eliminarMascota(Mascota mascota);

}
