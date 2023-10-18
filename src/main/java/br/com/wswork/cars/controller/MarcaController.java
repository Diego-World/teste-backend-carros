package br.com.wswork.cars.controller;

import br.com.wswork.cars.model.Marca;
import br.com.wswork.cars.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    // CREATE
    @PostMapping("")
    public ResponseEntity createMarca(@RequestBody Marca marca){
        if(!marca.getNomeMarca().isEmpty()){
            var novaMarca = this.marcaRepository.save(marca);
            return ResponseEntity.status(HttpStatus.OK).body("Marca adicionada com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A marca não pode ser nula");
        }
    }
    //READ ALL
    @GetMapping("")
    public ResponseEntity<List<Marca>> getAll(){
        List<Marca> list = this.marcaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    //READ BY ID
    @GetMapping("/{marcaId}")
    public ResponseEntity getById(@PathVariable Long marcaId){
        if(this.marcaRepository.existsById(marcaId)){
            var marca = this.marcaRepository.findById(marcaId);
            return ResponseEntity.status(HttpStatus.OK).body(marca);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID inválido");
        }
    }
    //UPDATE
    @PutMapping("/{marcaId}")
    public ResponseEntity update(@PathVariable Long marcaId, @RequestBody Marca marca){
        if(this.marcaRepository.existsById(marcaId)) {
            var marcaBanco = this.marcaRepository.findById(marcaId).orElse(null);
            marcaBanco.setNomeMarca(marca.getNomeMarca());
            this.marcaRepository.save(marcaBanco);
            return ResponseEntity.status(HttpStatus.OK).body("Marca alterada com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID inválido");
        }
    }

    @DeleteMapping("/{marcaId}")
    public ResponseEntity delete(@PathVariable Long marcaId){
        if(this.marcaRepository.existsById(marcaId)){
            var marca = this.marcaRepository.findById(marcaId);
            this.marcaRepository.delete(marca.get());
            return ResponseEntity.status(HttpStatus.OK).body("Marca excluida com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID inválido");
        }
    }
}