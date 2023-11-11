package com.uisrael.petsHome.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.petsHome.modelo.entidades.Vacuna;
import com.uisrael.petsHome.modelo.repositorio.IVacunaRepositorio;
import com.uisrael.petsHome.servicio.IVacunaServicio;

@Service
@Component
public class IVacunaServicioImpl implements IVacunaServicio {

	@Autowired
	private IVacunaRepositorio vacunaRepositorio;

	@Override
	public void insertarVacuna(Vacuna vacuna) {

		try {
			vacunaRepositorio.save(vacuna);
		} catch (Exception e) {
			System.err.println("Error al insertar cliente " + vacuna.getNombreVacuna() + " " + e.getMessage());
		}

	}

	@Override
	public List<Vacuna> listarVacuna() {

		return vacunaRepositorio.findAll();
	}

	@Override
	public List<Vacuna> buscarVacunaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return vacunaRepositorio.buscarVacunaPorNombre(nombre);
	}

	@Override
	public List<Vacuna> buscarVacunaPorNombrefecha(String nombre, Date fecha) {
		// TODO Auto-generated method stub
		return vacunaRepositorio.buscarVacunaPorNombrefecha(nombre, fecha);
	}

	@Override
	public List<Vacuna> buscarVacunaPorFiltroNombreFecha(String nombre, Date fecha) {
		// TODO Auto-generated method stub
		return vacunaRepositorio.buscarVacunaPorFiltroNombreFecha(nombre, fecha);
	}

	@Override
	public Vacuna buscarVacunaId(int id) {
		// TODO Auto-generated method stub
		return vacunaRepositorio.buscarVacunaId(id);
	}

	@Override
	public void eliminarVacuna(Vacuna vacuna) {
		// TODO Auto-generated method stub
		 vacunaRepositorio.delete(vacuna);
	}

}
