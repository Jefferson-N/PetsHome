package com.uisrael.petsHome.controlador;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.petsHome.modelo.entidades.Raza;
import com.uisrael.petsHome.modelo.entidades.TipoAnimal;
import com.uisrael.petsHome.servicio.IRazaServicio;
import com.uisrael.petsHome.servicio.ITipoAnimalServicio;

@Controller
public class TipoAnimalControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITipoAnimalServicio tipoAnimalServicio;

	@Autowired
	private IRazaServicio razaServicio;

	@GetMapping("/listarTipoAnimal")
	private String abrirTipoAnimal(Model modelTipoAnimal) {

		/* BreadCrumbs */
		modelTipoAnimal.addAttribute("breadHome", "Home");
		modelTipoAnimal.addAttribute("tituloPagina", "Tipo Animal");

		/* Clase del div */

		modelTipoAnimal.addAttribute("columnaVacia", "col-lg-1");
		modelTipoAnimal.addAttribute("columnaContent", "col-lg-10");

		List<TipoAnimal> listadoTipo = tipoAnimalServicio.listarTipoAnimal();
		modelTipoAnimal.addAttribute("tipos", listadoTipo);

		return "petshome/tipoanimal/tipoanimal";
	}

	@GetMapping("/crearTipoAnimal")
	private String crearTipoaAnimal(Model modelTipoAnimal) {
		/* BreadCrumbs */
		modelTipoAnimal.addAttribute("breadHome", "Home");
		modelTipoAnimal.addAttribute("tituloPagina", "Nuevo Tipo Animal");

		/* Clase del div */

		modelTipoAnimal.addAttribute("columnaVacia", "col-lg-3");
		modelTipoAnimal.addAttribute("columnaContent", "col-lg-6");

		List<Raza> listadoRaza = razaServicio.buscarRazaEstado("A");
		modelTipoAnimal.addAttribute("listadoRaza", listadoRaza);
		modelTipoAnimal.addAttribute("tipoAnimalForm", new TipoAnimal());

		return "petshome/tipoanimal/nuevo-tipoanimal";
	}

	@GetMapping("/editarTipoAnimal/{id}")
	private String editarTipoaAnimal(@PathVariable("id") Integer id, Model modelTipoAnimal) {
		/* BreadCrumbs */
		modelTipoAnimal.addAttribute("breadHome", "Home");
		modelTipoAnimal.addAttribute("tituloPagina", "Editar Tipo Animal");

		/* Clase del div */

		modelTipoAnimal.addAttribute("columnaVacia", "col-lg-3");
		modelTipoAnimal.addAttribute("columnaContent", "col-lg-6");

		TipoAnimal tipoAnimal = tipoAnimalServicio.buscarTipoAnimalId(id);
		
		List<Raza> listadoRaza = razaServicio.buscarRazaEstado("A");
		listadoRaza.add(razaServicio
				.buscarRazaId(
						tipoAnimal.getFkRaza().getIdRaza()));

		modelTipoAnimal.addAttribute("listadoRaza", listadoRaza);
		modelTipoAnimal.addAttribute("tipoAnimalForm", tipoAnimal);

		return "petshome/tipoanimal/nuevo-tipoanimal";
	}

	@PostMapping("/insertarTipoAnimal")
	public String insertarTipoAnimal(@ModelAttribute("tipoAnimalForm") TipoAnimal tipoAnimal,
			RedirectAttributes redirectAttrs) {

		String mensaje = tipoAnimal.getId() != 0 ? "Editado" : "Creado";

		try {

			tipoAnimal.setEstado(tipoAnimal.getId()==0? "A":
				tipoAnimal.getEstado());
			
			tipoAnimalServicio.insertarTipoAnimal(tipoAnimal);

			redirectAttrs.addFlashAttribute("mensaje", mensaje + " correctamente").addFlashAttribute("class",
					"success");

		} catch (Exception e) {

			redirectAttrs.addFlashAttribute("mensaje", "No se puede " + mensaje + " cliente").addFlashAttribute("class",
					"danger");

			System.err.print("Error: " + this.getClass() + " " + e.getMessage());
		}
		return "redirect:/listarTipoAnimal";
	}

	@GetMapping("/eliminarTipoAnimal/{id}")
	private String eliminarTipoaAnimal(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
		try {
		
			TipoAnimal tipoAnimal = new TipoAnimal();
			tipoAnimal.setId(id);
			tipoAnimalServicio.eliminarTipoAnimal(tipoAnimal);

			redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("class", "success");

		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("mensaje", "No se puede eliminar registro").addFlashAttribute("class",
					"danger");
			System.err.println("Error:" + this.toString() + ": " + e.getMessage());
		}

		return "redirect:/listarTipoAnimal";
	}

}
