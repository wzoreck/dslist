package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

// Para realizar interações com o BD - Camada de acesso a dados
public interface GameRepository extends JpaRepository<Game, Long> { // Tipo <Entidade, tipo do ID da entidade Game>

}
