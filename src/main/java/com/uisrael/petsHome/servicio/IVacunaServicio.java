package com.uisrael.petsHome.servicio;

import java.util.Date;
import java.util.List;

import com.uisrael.petsHome.modelo.entidades.Vacuna;

public interface IVacunaServicio {

	public void insertarVacuna(Vacuna vacuna);

	public List<Vacuna> listarVacuna();

	public List<Vacuna> buscarVacunaPorNombre(String nombre);

	public List<Vacuna> buscarVacunaPorNombrefecha(String nombre, Date fecha);

	public List<Vacuna> buscarVacunaPorFiltroNombreFecha(String nombre, Date fecha);

	public Vacuna buscarVacunaId(int id);
	
	public void  eliminarVacuna(Vacuna vacuna);

}
