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

import com.uisrael.petsHome.modelo.entidades.Mascota;
import com.uisrael.petsHome.modelo.entidades.TipoAnimal;
import com.uisrael.petsHome.servicio.IClienteServicio;
import com.uisrael.petsHome.servicio.IMascotaServicio;
import com.uisrael.petsHome.servicio.ITipoAnimalServicio;

@Controller
public class MascotaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IMascotaServicio mascotaServicio;

	@Autowired
	private IClienteServicio clienteServicio;

	@Autowired
	private ITipoAnimalServicio tipoAnimalServicio;

	@GetMapping("/listarMascota")
	public String listarMascota(Model modelMascota) {

		/* BreadCrumbs */
		modelMascota.addAttribute("breadHome", "Home");
		modelMascota.addAttribute("tituloPagina", "Listar Mascota");

		/* Clase del div */

		modelMascota.addAttribute("columnaVacia", "col-lg-1");
		modelMascota.addAttribute("columnaContent", "col-lg-10");

		List<Mascota> mascotas = mascotaServicio.listarMascota();
		modelMascota.addAttribute("mascotas", mascotas);
		return "petshome/mascota/mascota";
	}

	@GetMapping("/crearMascota")
	private String crearMascota(Model modelMascota) {

		/* BreadCrumbs */
		modelMascota.addAttribute("breadHome", "Home");
		modelMascota.addAttribute("tituloPagina", "Editar Cliente");

		/* Clase del div */

		modelMascota.addAttribute("columnaVacia", "col-lg-3");
		modelMascota.addAttribute("columnaContent", "col-lg-6");

		modelMascota.addAttribute("clientes", clienteServicio.listarCliente());
		modelMascota.addAttribute("mascotaForm", new Mascota());
		modelMascota.addAttribute("listadoAnimal", tipoAnimalServicio.buscarTipoAnimalEstado("A"));
		modelMascota.addAttribute(new Mascota());

		return "petshome/mascota/nueva-mascota";
	}

	@GetMapping("/editarMascota/{id}")
	private String editarMascota(@PathVariable("id") Integer id, Model modelMascota) {

		/* BreadCrumbs */
		modelMascota.addAttribute("breadHome", "Home");
		modelMascota.addAttribute("tituloPagina", "Editar Mascota");

		/* Clase del div */
		Mascota mascota =mascotaServicio.buscarMascotaId(id);
		
		List<TipoAnimal> listadoTipo =tipoAnimalServicio.buscarTipoAnimalEstado("A");
		listadoTipo.add(
				tipoAnimalServicio
				.buscarTipoAnimalId(
						mascota.getFkTipoAnimal().getId()));
		
		modelMascota.addAttribute("columnaVacia", "col-lg-3");
		modelMascota.addAttribute("columnaContent", "col-lg-6");

		modelMascota.addAttribute("clientes", clienteServicio.listarCliente());
		modelMascota.addAttribute("mascotaForm", mascota);
		modelMascota.addAttribute("listadoAnimal", listadoTipo );
		modelMascota.addAttribute(new Mascota());

		return "petshome/mascota/nueva-mascota";
	}

	@PostMapping("/guardarMascota")
	public String guardarMascota(@ModelAttribute("mascotaForm") Mascota mascota, RedirectAttributes redirectAttrs) {

		String mensaje = mascota.getIdMascota() != 0 ? "Editado" : "Creado";

		try {

			mascotaServicio.insertarMascota(mascota);

			redirectAttrs.addFlashAttribute("mensaje", mensaje + " correctamente").addFlashAttribute("class",
					"success");

		} catch (Exception e) {

			redirectAttrs.addFlashAttribute("mensaje", "No se puede " + mensaje + " cliente").addFlashAttribute("class",
					"danger");

			System.err.print(e.getMessage());
		}

		return "redirect:/listarMascota";
	}

	@GetMapping("/eliminarMascota/{id}")
	private String eliminarMascota(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {

		try {
			Mascota mascota = new Mascota();
			mascota.setIdMascota(id);
			mascotaServicio.eliminarMascota(mascota);
			redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("class", "success");

		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("mensaje", "No se puede eliminar registro").addFlashAttribute("class",
					"danger");
			System.err.println("Error:" + this.toString() + ": " + e.getMessage());
		}

		return "redirect:/listarMascota";
	}

}
