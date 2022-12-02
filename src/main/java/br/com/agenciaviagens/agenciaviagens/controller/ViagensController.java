package br.com.agenciaviagens.agenciaviagens.controller;

import br.com.agenciaviagens.agenciaviagens.error.IdNaoEncontradoException;
import br.com.agenciaviagens.agenciaviagens.model.Viagens;
import br.com.agenciaviagens.agenciaviagens.repository.ViagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/viagens")
public class ViagensController {

    @Autowired
    private ViagensRepository viagensDAO;

    @GetMapping
    public ResponseEntity<?> buscarTodasAsViagens(){
        return new ResponseEntity<>(viagensDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarViagemPorId(@PathVariable Long id){
        verificarSeIdExiste(id);
        return new ResponseEntity<>(viagensDAO.findById(id), HttpStatus.OK);
    }

    @GetMapping("/buscarPorLocal/{local}")
    public ResponseEntity<?> buscarViagemPorLocal(@PathVariable String local){
        return new ResponseEntity<>(viagensDAO.findByLocalContainingIgnoreCase(local), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postarNovaViagem(@RequestBody Viagens viagem){
        return new ResponseEntity<>(viagensDAO.save(viagem), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> atualizarViagem(@RequestBody Viagens viagem){
        verificarSeIdExiste(viagem.getId());
        viagensDAO.save(viagem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarViagem(@PathVariable("id") Long id){
        verificarSeIdExiste(id);
        viagensDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    public void verificarSeIdExiste(Long id){
        //falta classe que lança a mensagem e classe que mostra detalhes do erro
        if(viagensDAO.findById(id).isEmpty()){
            throw new IdNaoEncontradoException("Id não encontrado para o id: " + id);
        }
    }

}
