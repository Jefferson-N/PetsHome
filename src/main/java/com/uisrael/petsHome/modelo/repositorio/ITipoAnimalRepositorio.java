package com.uisrael.petsHome.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.modelo.entidades.TipoAnimal;

@Repository
@Component
public interface ITipoAnimalRepositorio extends JpaRepository<TipoAnimal, Integer> {

	@Query("select ta from TipoAnimal ta where ta.descripcionTipo = ?1")
	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimal(String tipo);

	@Query("select  ta from TipoAnimal ta where ta.descripcionTipo = :tipo and ta.estado = :estado ")
	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimalEstado(@Param("tipo") String tipo,
			@Param("estado") String estado);

	@Query("select  ta from TipoAnimal ta where ta.descripcionTipo = :tipo or ta.estado = :estado ")
	public List<TipoAnimal> buscarTipoAnimalPorTipoAnimalOrEstado(@Param("tipo") String tipo,
			@Param("estado") String estado);
	
	@Query("select  ta from TipoAnimal ta where ta.estado = :estado ")
	public List<TipoAnimal> buscarTipoAnimalEstado(	@Param("estado") String estado);

	@Query("select t from TipoAnimal t where t.id =?1")
	public TipoAnimal buscarTipoAnimalId(int id);
			
	
}
