package br.com.unicuritiba.atividadediegao.controllers;

import br.com.unicuritiba.atividadediegao.models.Game;
import br.com.unicuritiba.atividadediegao.repositories.GameRepository;
import br.com.unicuritiba.atividadediegao.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class GameController {

    @Autowired
    GameRepository repository;

    @Autowired
    GameService service;

    @GetMapping
    public ResponseEntity<List<Game>> getGames(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        Game jogoSalvo = repository.save(game);
        return ResponseEntity.ok(jogoSalvo);
    }

    @DeleteMapping("/{id}")
    public void removeGame(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Game updateGame (@PathVariable Long id, @RequestBody Game newGame){
        return service.updateGame(id, newGame);
    }


}
