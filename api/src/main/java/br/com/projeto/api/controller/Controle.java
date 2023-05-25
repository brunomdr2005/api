package br.com.projeto.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.model.Jogo;
import br.com.projeto.api.repository.repository;
import br.com.projeto.api.serviço.Servico;

@RestController
public class Controle {

    @Autowired
    private repository acao;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<Object> cadastrar(@RequestBody Jogo obj){
        try{
            return new ResponseEntity<>(servico.cadastrar(obj),HttpStatus.CREATED);
        }catch(IllegalArgumentException iae){
            return new ResponseEntity<>(iae.getMessage(),HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>("Houve um erro",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api")
    public List<Jogo> selecionar() {
        return servico.selecionar();
    } 

    @GetMapping("/api/{nome}")
    public List<Jogo> selecionarPeloNome(@PathVariable String nome){
        return acao.findByNome(nome);
    }

    @PutMapping("/api")
    public ResponseEntity<Object> editar(@RequestBody Jogo obj){
        try{
            return new ResponseEntity<>(servico.cadastrar(obj),HttpStatus.CREATED);
        }catch(IllegalArgumentException iae){
            return new ResponseEntity<>(iae.getMessage(),HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>("Houve um erro",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/api/{nome}")
    public void remover(@PathVariable String nome){
        List<Jogo> list = selecionarPeloNome(nome);

        for (Jogo jogo : list) {
            acao.deleteById(jogo.getCodigo());
        }
    }

    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("")
    public String mensagem(){
        return "Hello world!";
    }

    @GetMapping("/boasvindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return " seja bem vindo(a) " + nome;
    }

    @PostMapping("/jogo")
    public Jogo jogo(@RequestBody Jogo j){
        return j;
    }

}
