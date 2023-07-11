package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

// O contorlador é quem expõem um endpoint para o mundo externo
@RestController
@RequestMapping(value = "/games") // Caminho da URL
public class GameController {

	// Injetar um GameService
	@Autowired
	private GameService gameService;
	
	@GetMapping // Mapear com o verbo GET do HTTP
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
