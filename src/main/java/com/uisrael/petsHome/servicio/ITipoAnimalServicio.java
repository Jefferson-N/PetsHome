package com.uisrael.petsHome.servicio;

import java.util.List;

import com.uisrael.petsHome.modelo.entidades.TipoAnimal;

public interface ITipoAnimalServicio {

	public void insertarTipoAnimal(TipoAnimal tipoAnimal);

	public List<TipoAnimal> listarTipoAnimal();

	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimal(String tipo);

	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimalEstado(String tipo, String estado);

	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimalOrEstado(String tipo, String estado);

	public TipoAnimal buscarTipoAnimalId(int id);

	public List<TipoAnimal> buscarTipoAnimalEstado(String estado);

	public void eliminarTipoAnimal(TipoAnimal tipoAnimal);

}
