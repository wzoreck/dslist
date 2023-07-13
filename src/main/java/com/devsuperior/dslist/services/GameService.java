package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

/*@Component ou @Service para registrar a classe como um componente do sistema,
  utilizado para informar ao Spring os componentes que ele pode utilizar (Ex: injetar um componente no outro)
*/
@Service
public class GameService {

	// Injetar um GameRepository no GameService
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) // Permite apenas a leitura dos dados
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result); // Vai copiar os valores do Game para o GameDTO com o BeanUtils
		return dto;
	}
	
	@Transactional(readOnly = true)
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
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId)  {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
