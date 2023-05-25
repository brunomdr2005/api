package br.com.projeto.api.serviço;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.model.Jogo;
import br.com.projeto.api.model.Mensagem;
import br.com.projeto.api.repository.repository;

@Service
public class Servico {
    
    @Autowired
    private repository acao;

    // Método para cadastrar jogos
    public Jogo cadastrar(Jogo obj){

        if(obj.getNome().equals("")){
            throw new IllegalArgumentException("O nome precisa ser preenchido");
        }else if(obj.getAnoDeLancamento() < 1958){
            throw new IllegalArgumentException("Ano inválido");
        }else if(obj.getEmpresa().equals("")){
            throw new IllegalArgumentException("O nome da empresa precisa ser preenchido");
        }
        return acao.save(obj);

    }

    // Método para selecionar jogos
    public List<Jogo> selecionar(){
        return acao.findAll();
    }
}
