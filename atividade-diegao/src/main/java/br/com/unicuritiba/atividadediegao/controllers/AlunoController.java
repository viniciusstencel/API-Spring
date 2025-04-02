package br.com.unicuritiba.atividadediegao.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.atividadediegao.models.Aluno;
import br.com.unicuritiba.atividadediegao.repositories.AlunoRepository;

@RestController
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> getAlunos(){
        return ResponseEntity.ok(repository.findAll());
    }


    @PostMapping("/alunos")
    public ResponseEntity<Aluno> saveAluno(
            @RequestBody Aluno aluno){
        Aluno alunoSalvo = repository.save(aluno);
        return ResponseEntity.ok(alunoSalvo);
    }


    @DeleteMapping("/alunos/{id}")
    public void removeAluno(@PathVariable long id) {
        repository.deleteById(id);
    }

}