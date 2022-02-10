package com.curso.tablero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.curso.tablero.services.TableroService;

@Controller
public class TableroController {

	@Autowired
	private TableroService tableroService;
	
	//get  /tablero
	@GetMapping("/tablero")
	public String mostrarTablero(Model model) {
		
		model.addAttribute("columnaToDo", tableroService.getTareasToDo());
		model.addAttribute("columnaInProgresss", tableroService.getTareasInProgress());
		model.addAttribute("columnaDone", tableroService.getTareasDone());
		return "tablero";
	}
	
	
	
	
	
	// get  /tablero/nueva-tarea 
	
	// post  /tablero/nueva-tarea
	
	// get /tablero/tarea/{id}/{nuevoEstado}
	
	
}
