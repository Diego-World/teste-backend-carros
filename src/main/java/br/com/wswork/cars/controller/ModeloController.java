package br.com.wswork.cars.controller;

import br.com.wswork.cars.Utils.Utils;
import br.com.wswork.cars.model.Marca;
import br.com.wswork.cars.model.Modelo;
import br.com.wswork.cars.repository.MarcaRepository;
import br.com.wswork.cars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    MarcaRepository marcaRepository;

    // CREATE
    @PostMapping("/{marcaId}")
    public ResponseEntity createModelo(@RequestBody Modelo modelo, @PathVariable Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId).orElse(null);

        if (marca != null) {
            if(!modelo.getNome().isBlank()){
                Modelo modeloBanco = modeloRepository.findByNome(modelo.getNome());
                if(modeloBanco != null){
                    return ResponseEntity.status(HttpStatus.OK).body("Modelo já existe");
                }else{
                    modelo.setMarcaId(marca);
                    var novoModelo = modeloRepository.save(modelo);
                    return ResponseEntity.status(HttpStatus.OK).body("Modelo Salvo com sucesso");
                }
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O nome do modelo não pode estar vazio");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ID da marca associado ao modelo deve ser válido");
        }
    }

    @PostMapping("")
    public ResponseEntity createMarca(@RequestBody Marca marca){
        if (marca.getNomeMarca().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O nome da marca não pode ser vazio");
        }

        Marca marcaBanco = marcaRepository.findByNomeMarca(marca.getNomeMarca());

        if (marcaBanco != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Marca já existe");
        } else {
            Marca novaMarca = marcaRepository.save(marca);
            return ResponseEntity.status(HttpStatus.OK).body("Marca criada com sucesso");
        }
    }

    //READ ALL
    @GetMapping("")
    public ResponseEntity<List<Modelo>> getAll(){
        List<Modelo> list = this.modeloRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


    //READ BY ID
    @GetMapping("/{modeloId}")
    public ResponseEntity getById(@PathVariable Long modeloId){
        if(this.modeloRepository.existsById(modeloId)){
            var marca = this.modeloRepository.findById(modeloId);
            return ResponseEntity.status(HttpStatus.OK).body(marca);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID inválido");
        }
    }

    //UPDATE
    @PutMapping("/{modeloId}")
    public ResponseEntity<Modelo> update(@PathVariable Long modeloId, @RequestBody Modelo modelo){
        var modeloBanco = this.modeloRepository.findById(modeloId).orElse(null);
        Utils.copyNonNullProperties(modelo,modeloBanco);
        modeloBanco = this.modeloRepository.save(modeloBanco);
        return ResponseEntity.status(HttpStatus.OK).body(modeloBanco);
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
