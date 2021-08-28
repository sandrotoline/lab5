package com.example.lab5.repository;

import java.util.List;

import com.example.lab5.entity.Personagem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>{
    
    public Personagem findByNome(String nome);

    public  List<Personagem> findByNomeContainsOrAlinhamentoContains(String nome, String alinhamento);
    
}
