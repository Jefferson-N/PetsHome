package com.uisrael.petsHome.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.petsHome.modelo.entidades.TipoAnimal;
import com.uisrael.petsHome.modelo.repositorio.ITipoAnimalRepositorio;
import com.uisrael.petsHome.servicio.ITipoAnimalServicio;

@Service
@Component
public class ITipoAnimalServicioImpl implements ITipoAnimalServicio {

	@Autowired
	private ITipoAnimalRepositorio tipoAnimalRepositorio;

	@Override
	public void insertarTipoAnimal(TipoAnimal tipoAnimal) {
		try {
			tipoAnimalRepositorio.save(tipoAnimal);
		} catch (Exception e) {
			System.err
					.println("Error al insertar tipo animal " + tipoAnimal.getDescripcionTipo() + " " + e.getMessage());
		}
	}

	@Override
	public List<TipoAnimal> listarTipoAnimal() {
		
		return tipoAnimalRepositorio.findAll();
	}

	@Override
	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimal(String tipo) {
		
		return tipoAnimalRepositorio.buscarTipoAnimalPorTipoAnimal(tipo);
	}

	@Override
	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimalEstado(String tipo, String estado) {
		
		return tipoAnimalRepositorio.buscarTipoAnimalPorTipoAnimalEstado(tipo, estado);
	}

	@Override
	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimalOrEstado(String tipo, String estado) {
		
		return tipoAnimalRepositorio.buscarTipoAnimalPorTipoAnimalOrEstado(tipo, estado);
	}

	@Override
	public TipoAnimal buscarTipoAnimalId(int id) {
		
		return tipoAnimalRepositorio.buscarTipoAnimalId(id);
	}

	@Override
	public List<TipoAnimal> buscarTipoAnimalEstado(String estado) {
		
		return tipoAnimalRepositorio.buscarTipoAnimalEstado(estado);
	}

	@Override
	public void eliminarTipoAnimal(TipoAnimal tipoAnimal) {
		tipoAnimalRepositorio.delete(tipoAnimal);
		
	}

}
