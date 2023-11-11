package com.uisrael.petsHome.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.petsHome.modelo.entidades.Mascota;

@Repository
@Component
public interface IMascotaRepositorio extends JpaRepository<Mascota, Integer> {

	@Query("select m from Mascota m where m.nombreMascota = ?1")
	public List<Mascota> buscarMascotaPorNombre(String nombre);

	@Query("select  m from Mascota m where m.nombreMascota like ?1%")
	public List<Mascota> buscarMascotaPorFlitroNombre(String filtro);

	@Query("select  m from Mascota m where m.nombreMascota like %:filtro% and m.edadMascota = :edad")
	public List<Mascota>buscarMascotaFiltroNombreEdad(@Param("filtro") String filtro,@Param("edad")	int edad);
	
	@Query("select m from Mascota m where m.idMascota =?1")
	public Mascota buscarMascotaId(int id);

}
