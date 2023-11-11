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

import com.uisrael.petsHome.modelo.entidades.Cliente;
import com.uisrael.petsHome.servicio.IClienteServicio;

@Controller
public class ClienteControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String HOME = "Home";

	@Autowired
	private IClienteServicio clienteServicio;

	@GetMapping("/")
	private String home() {

		return "redirect:/listarCliente";
	}

	@GetMapping("/listarCliente")
	private String abrirCliente(Model redirectAttrs) {

		/* BreadCrumbs */
		redirectAttrs.addAttribute("breadHome", ClienteControlador.HOME);
		redirectAttrs.addAttribute("tituloPagina", "Cliente");

		/* Clase del div */

		redirectAttrs.addAttribute("columnaVacia", "col-lg-1");
		redirectAttrs.addAttribute("columnaContent", "col-lg-10");

		/* Lista de clientes */
		List<Cliente> clientes = clienteServicio.listarCliente();
		redirectAttrs.addAttribute("clientes", clientes);
		return "petshome/cliente/cliente";

	}

	@GetMapping("/crearCliente")
	private String crearCliente(Model redirectAttrs) {

		/* BreadCrumbs */
		redirectAttrs.addAttribute("breadHome", ClienteControlador.HOME);
		redirectAttrs.addAttribute("tituloPagina", "Nuevo Cliente");

		/* Clase del div */

		redirectAttrs.addAttribute("columnaVacia", "col-lg-3");
		redirectAttrs.addAttribute("columnaContent", "col-lg-6");

		Cliente nuevoCliente = new Cliente();
		redirectAttrs.addAttribute("cliente", nuevoCliente);

		return "petshome/cliente/nuevocliente";
	}

	@GetMapping("/editarCliente/{id}")
	private String editarCliente(@PathVariable Integer id, Model redirectAttrs) {

		/* BreadCrumbs */
		redirectAttrs.addAttribute("breadHome", ClienteControlador.HOME);
		redirectAttrs.addAttribute("tituloPagina", "Editar Cliente");

		/* Clase del div */

		redirectAttrs.addAttribute("columnaVacia", "col-lg-3");
		redirectAttrs.addAttribute("columnaContent", "col-lg-6");

		redirectAttrs.addAttribute("cliente", clienteServicio.buscarClientePorId(id));
		return "petshome/cliente/nuevocliente";

	}

	@PostMapping("/guardarCliente")
	public String guardarCliente(@ModelAttribute("cliente") Cliente nuevoCliente, RedirectAttributes redirectAttrs) {
		
		String mensaje = nuevoCliente.getId() != 0 ? "Editado" : "Creado";

		try {
			clienteServicio.insertarCliente(nuevoCliente);

			redirectAttrs.addFlashAttribute("mensaje", mensaje + " correctamente").addFlashAttribute("class",
					"success");

		} catch (Exception e) {

			redirectAttrs.addFlashAttribute("mensaje", "No se puede " + mensaje + " cliente").addFlashAttribute("class",
					"danger");

			System.err.print(e.getMessage());
		}

		return "redirect:/listarCliente";
	}

	@GetMapping("/eliminarCliente/{id}")
	private String eliminarCliente(@PathVariable("id") Integer id, RedirectAttributes redirectAttrs) {
		try {
			Cliente eliminar = new Cliente();
			eliminar.setId(id);
			clienteServicio.eliminarCliente(eliminar);
			redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("class", "success");
		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("mensaje", "No se puede eliminar cliente").addFlashAttribute("class",
					"danger");

			System.err.print(e.getMessage());
		}

		return "redirect:/listarCliente";

	}

}
