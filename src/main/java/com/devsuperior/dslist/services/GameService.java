package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

/*@Component ou @Service para registrar a classe como um componente do sistema,
  utilizado para informar ao Spring os componentes que ele pode utilizar (Ex: injetar um componente no outro)
*/
@Service
public class GameService {

	// Injetar um GameRepository no GameService
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll()  {
		// Buscar dados no BD, a tabela de Games que vier do BD vai ser automaticamente convertida para uma lista de Games
		List<Game> result = gameRepository.findAll();
		/*	.stream() é uma lib que permite fazer operações com sequências de dados
			.map() transforma objetos de uma coisa para outra, nele informamos que
			todo objeto Game [x] será transformado em um novo GameMinDTO passando o Game [x] como argumento
			.toList() transforma o stream para lista novamente. 
		*/
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
