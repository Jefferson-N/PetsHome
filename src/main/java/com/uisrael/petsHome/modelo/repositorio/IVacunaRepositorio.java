package com.uisrael.petsHome.modelo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.modelo.entidades.Vacuna;

@Repository
@Component
public interface IVacunaRepositorio extends JpaRepository<Vacuna, Integer> {

	@Query("select v from Vacuna v where v.nombreVacuna = ?1")
	public List<Vacuna> buscarVacunaPorNombre(String nombre);

	@Query("select  v from Vacuna v where v.nombreVacuna = :nombre and v.fechaVacuna > :fecha ")
	public List<Vacuna> buscarVacunaPorNombrefecha(@Param("nombre") String nombre, @Param("fecha") Date fecha);

	@Query("select  v from Vacuna v where v.nombreVacuna like %:nombre%  and v.fechaVacuna = :fecha ")
	public List<Vacuna> buscarVacunaPorFiltroNombreFecha(@Param("nombre") String nombre, @Param("fecha") Date fecha);

	@Query("select v from Vacuna v where v.id =?1")
	public Vacuna buscarVacunaId(int id);

}
