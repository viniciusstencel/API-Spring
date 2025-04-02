package br.com.unicuritiba.atividadediegao.repositories;

import br.com.unicuritiba.atividadediegao.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
