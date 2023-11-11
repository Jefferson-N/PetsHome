package com.uisrael.petsHome.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.modelo.entidades.Raza;

@Repository
@Component
public interface IRazaRepositorio extends JpaRepository<Raza, Integer> {

	@Query("select r from Raza r where r.detalleRaza = ?1")
	public List<Raza> buscarRazaPordetalle(String detalle);

	@Query("select  r from Raza r where r.detalleRaza = :detalle and r.estadoRaza = :estado ")
	public List<Raza> buscarRazaPordetalleEstado(@Param("detalle") String detalle, @Param("estado") String estado);

	@Query("select  r from Raza r where r.detalleRaza = :detalle or r.estadoRaza = :estado ")
	public List<Raza> buscarRazaPorDetalleOrEstado(@Param("detalle") String detalle, @Param("estado") String estado);

	@Query("select r from Raza r where r.idRaza=?1")
	public Raza buscarRazaId(int id);
	
	@Query("select  r from Raza r where r.estadoRaza = :estado ")
	public List<Raza> buscarRazaEstado(@Param("estado") String estado);


}
