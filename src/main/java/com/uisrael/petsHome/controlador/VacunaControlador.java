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

import com.uisrael.petsHome.modelo.entidades.Vacuna;
import com.uisrael.petsHome.servicio.IMascotaServicio;
import com.uisrael.petsHome.servicio.IVacunaServicio;

@Controller
public class VacunaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IVacunaServicio vacunaServicio;

	@Autowired
	private IMascotaServicio mascotaServicio;

	@GetMapping("/listarVacuna")
	private String listarVacuna(Model modelVacuna) {
		/* BreadCrumbs */
		modelVacuna.addAttribute("breadHome", "Home");
		modelVacuna.addAttribute("tituloPagina", "Vacuna");

		/* Clase del div */

		modelVacuna.addAttribute("columnaVacia", "col-lg-3");
		modelVacuna.addAttribute("columnaContent", "col-lg-6");

		List<Vacuna> vacunas = vacunaServicio.listarVacuna();
		modelVacuna.addAttribute("vacunas", vacunas);
		return "petshome/vacuna/vacuna";
	}

	@GetMapping("/crearVacuna")
	private String nuevaVacuna(Model modelVacuna) {
		/* BreadCrumbs */
		modelVacuna.addAttribute("breadHome", "Home");
		modelVacuna.addAttribute("tituloPagina", "Nueva Vacuna");

		/* Clase del div */

		modelVacuna.addAttribute("columnaVacia", "col-lg-3");
		modelVacuna.addAttribute("columnaContent", "col-lg-6");

		modelVacuna.addAttribute("mascotas", mascotaServicio.listarMascota());
		modelVacuna.addAttribute("vacunaForm", new Vacuna());

		return "petshome/vacuna/nueva-vacuna";
	}

	@GetMapping("/editarVacuna/{id}")
	private String editarVacuna(@PathVariable("id") Integer id, Model modelVacuna) {
		/* BreadCrumbs */
		modelVacuna.addAttribute("breadHome", "Home");
		modelVacuna.addAttribute("tituloPagina", "Editar Vacuna");

		/* Clase del div */

		modelVacuna.addAttribute("columnaVacia", "col-lg-3");
		modelVacuna.addAttribute("columnaContent", "col-lg-6");

		modelVacuna.addAttribute("mascotas", mascotaServicio.listarMascota());
		modelVacuna.addAttribute("vacunaForm", vacunaServicio.buscarVacunaId(id));

		return "petshome/vacuna/nueva-vacuna";

	}

	@PostMapping("/guardarVacuna")
	public String guardarVacuna(@ModelAttribute("vacunaForm") Vacuna vacuna, RedirectAttributes redirectAttrs) {
				
		String mensaje = vacuna.getId() != 0 ? "Editado" : "Creado";

		try {
		
			vacunaServicio.insertarVacuna(vacuna);

			redirectAttrs.addFlashAttribute("mensaje", mensaje + " correctamente")
			.addFlashAttribute("class", "success");

		} catch (Exception e) {

			redirectAttrs.addFlashAttribute("mensaje", "No se puede " + mensaje + " cliente").addFlashAttribute("class",
					"danger");

			System.err.print("Error: "+this.getClass() +" "+e.getMessage());
		}
		
		
		return "redirect:/listarVacuna";
	}

	@GetMapping("/eliminarVacuna/{id}")
	private String eliminarMascota(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {

		try {
			Vacuna vacuna = new Vacuna();
			vacuna.setId(id);
			
			vacunaServicio.eliminarVacuna(vacuna);
			redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente")
			.addFlashAttribute("class", "success");

		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("mensaje","No se puede eliminar registro")
			.addFlashAttribute("class", "danger");
			System.err.println("Error:" + this.toString()+": "+ e.getMessage());
		}

		return "redirect:/listarVacuna";
	}
}
