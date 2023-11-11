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
import com.uisrael.petsHome.servicio.IRazaServicio;

@Controller
public class RazaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IRazaServicio razaServicio;

	@GetMapping("/listarRaza")
	private String listarRaza(Model modelRaza) {
		
		/* BreadCrumbs */
		modelRaza.addAttribute("breadHome", "Home");
		modelRaza.addAttribute("tituloPagina", " Raza");

		/* Clase del div */

		modelRaza.addAttribute("columnaVacia", "col-lg-1");
		modelRaza.addAttribute("columnaContent", "col-lg-10");
		
		List<Raza> listadoRaza = razaServicio.listarRaza();
		modelRaza.addAttribute("listadoRaza", listadoRaza);
		return "petshome/raza/raza";
	}

	@GetMapping("/crearRaza")
	private String CrearRaza(Model modelRaza) {

		/* BreadCrumbs */
		modelRaza.addAttribute("breadHome", "Home");
		modelRaza.addAttribute("tituloPagina", "Nueva Raza");

		/* Clase del div */

		modelRaza.addAttribute("columnaVacia", "col-lg-3");
		modelRaza.addAttribute("columnaContent", "col-lg-6");

		modelRaza.addAttribute("raza", new Raza());

		return "petshome/raza/nueva-raza";
	}

	@GetMapping("/editarRaza/{id}")
	private String editarRaza(@PathVariable("id") Integer id, Model modelRaza) {

		/* BreadCrumbs */
		modelRaza.addAttribute("breadHome", "Home");
		modelRaza.addAttribute("tituloPagina", "Editar Raza");

		/* Clase del div para formulario */

		modelRaza.addAttribute("columnaVacia", "col-lg-3");
		modelRaza.addAttribute("columnaContent", "col-lg-6");

		modelRaza.addAttribute("raza", razaServicio.buscarRazaId(id));

		return "petshome/raza/nueva-raza";
	}

	@PostMapping("/insertarRaza")
	public String insertarRaza(@ModelAttribute("raza") Raza raza, RedirectAttributes redirectAttrs) {
		String mensaje = raza.getIdRaza() != 0 ? "Editado" : "Creado";

		try {
			
			raza.setEstadoRaza(raza.getIdRaza()==0? "A": raza.getEstadoRaza());

			razaServicio.insertarRaza(raza);

			redirectAttrs.addFlashAttribute("mensaje", mensaje + " correctamente").addFlashAttribute("class",
					"success");

		} catch (Exception e) {

			redirectAttrs.addFlashAttribute("mensaje", "No se puede " + mensaje + " cliente").addFlashAttribute("class",
					"danger");

			System.err.print("Error: " + this.getClass() + " " + e.getMessage());
		}
		razaServicio.insertarRaza(raza);

		return "redirect:/listarRaza";
	}

	@GetMapping("/eliminarRaza/{id}")
	private String eliminarRaza(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
		try {

			Raza raza = new Raza();
			raza.setIdRaza(id); 
			razaServicio.eliminarRaza(raza);

			redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente")
			.addFlashAttribute("class", "success");

		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("mensaje", "No se puede eliminar registro").addFlashAttribute("class",
					"danger");
			System.err.println("Error:" + this.toString() + ": " + e.getMessage());
		}

		return "redirect:/listarRaza";
	}

}
