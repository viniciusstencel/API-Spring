package br.com.unicuritiba.atividadediegao.services;

import br.com.unicuritiba.atividadediegao.models.Aluno;
import br.com.unicuritiba.atividadediegao.models.Game;
import br.com.unicuritiba.atividadediegao.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game updateGame(Long id, Game novoJogo){
        return gameRepository.findById(id).map(jogo -> {
            jogo.setNome(novoJogo.getNome());
            jogo.setDev(novoJogo.getDev());
            jogo.setGenero(novoJogo.getGenero());
            jogo.setData_lancamento(novoJogo.getData_lancamento());
            jogo.setPlataforma(novoJogo.getPlataforma());
            jogo.setPreco(novoJogo.getPreco());
            return gameRepository.save(jogo);
        }).orElseThrow(() -> new RuntimeException("Jogo não encontrado com o ID: " + id));
    }
}
