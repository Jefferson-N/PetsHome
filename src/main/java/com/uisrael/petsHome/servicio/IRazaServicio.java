package com.uisrael.petsHome.servicio;

import java.util.List;

import com.uisrael.petsHome.modelo.entidades.Raza;

public interface IRazaServicio {

	public void insertarRaza(Raza raza);

	public List<Raza> listarRaza();

	public List<Raza> buscarRazaPordetalle(String detalle);

	public List<Raza> buscarRazaPordetalleEstado(String detalle, String estado);

	public List<Raza> buscarRazaPorDetalleOrEstado(String detalle, String estado);

	public Raza buscarRazaId(int id);

	public List<Raza> buscarRazaEstado(String estado);

	public void eliminarRaza(Raza raza);

}
