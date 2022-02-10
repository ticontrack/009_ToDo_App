package com.curso.tablero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.curso.domain.Producto;
import com.curso.tablero.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;
import com.curso.tablero.services.TableroService;

@Controller
public class TableroController {

	@Autowired
	private TableroService tableroService;

	// get /tablero
	@GetMapping({ "/tablero", "/" })
	public String mostrarTablero(Model model) {

		model.addAttribute("columnaToDo", tableroService.getTareasToDo());
		model.addAttribute("columnaInProgress", tableroService.getTareasInProgress());
		model.addAttribute("columnaDone", tableroService.getTareasDone());
		return "tablero";
	}

	// get /tablero/nueva-tarea
	@GetMapping("/tablero/{id}/{nuevoestado}")
	public String cambiarEstado(@PathVariable("id") int id, @PathVariable("nuevoestado") String nuevoEstado)
			throws TareasException {

		switch (nuevoEstado) {
		case "TODO":
			tableroService.moverAToDo(id);
			break;
		case "INPROGRESS":
			tableroService.moverAInProgres(id);
			break;
		case "DONE":
			tableroService.moverADone(id);
			break;
		default:
			throw new TareasException("No ha indicado un estado válido");
		}

		return "redirect:/tablero";
	}


	@GetMapping("/tablero/nueva-tarea")
	public String getCrearNuevaTareaFormulario(Model model) {
		Tarea tarea = new Tarea();
		model.addAttribute("nuevaTarea", tarea);
		return "crear-tarea";
	}

	@PostMapping("/tablero/nueva-tarea")
	public String crearNuevaTarea(
			@ModelAttribute("nuevaTarea")  Tarea nueva,
    		Model model ) throws TareasException {
		
		tableroService.crearTarea(nueva);
		
		return "redirect:/tablero";
	}
	
	

}
