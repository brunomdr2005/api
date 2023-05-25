package br.com.projeto.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.model.Jogo;

@Repository
public interface repository extends CrudRepository<Jogo, Integer> {
    
    List<Jogo> findAll();  
    
    List<Jogo> findByNome(String nome);

}
