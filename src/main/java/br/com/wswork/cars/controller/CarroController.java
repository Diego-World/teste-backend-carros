package br.com.wswork.cars.controller;

import br.com.wswork.cars.DTO.CarroDTO;
import br.com.wswork.cars.Service.CarroService;
import br.com.wswork.cars.Utils.Utils;
import br.com.wswork.cars.model.Carro;
import br.com.wswork.cars.model.Marca;
import br.com.wswork.cars.model.Modelo;
import br.com.wswork.cars.repository.CarroRepository;
import br.com.wswork.cars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cars")
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private CarroService carroService;

    // CREATE
    @PostMapping("/{modeloId}")
    public ResponseEntity createModelo(@RequestBody Carro carro, @PathVariable Long modeloId) {
        Modelo modelo = this.modeloRepository.findById(modeloId).orElse(null);
        if (modelo != null) {
            if(carro.getNumPortas() <= 1){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O carro deve ter no mínimo duas portas");
            }
            if(carro.getAno() < 1886){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ano do veículo não pode ser menor que a data de invenção do carro");
            }
            if(carro.getCombustivel().isBlank()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O carro deve ter um tipo de combustível");
            }
            if(carro.getCor().isBlank()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O carro deve ter uma cor");
            }
            carro.setModelo(modelo);
            var novoModelo = carroRepository.save(carro);
            return ResponseEntity.status(HttpStatus.OK).body("Carro Salvo com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ID do modelo associado ao carro deve ser válido");
        }
    }

    @GetMapping("")
    public ResponseEntity<List<CarroDTO>> getAll() {
        List<CarroDTO> carrosDTO = this.carroService.getAllCarros();
        return ResponseEntity.status(HttpStatus.OK).body(carrosDTO);
    }

    //READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        if (this.carroRepository.existsById(id)) {
            var carro = this.carroRepository.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(carro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID inválido");
        }
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro carro) {
        var carroBanco = this.carroRepository.findById(id).orElse(null);
        Utils.copyNonNullProperties(carro, carroBanco);
        carroBanco = this.carroRepository.save(carroBanco);
        return ResponseEntity.status(HttpStatus.OK).body(carroBanco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (this.carroRepository.existsById(id)) {
            var carro = this.carroRepository.findById(id);
            this.carroRepository.delete(carro.get());
            return ResponseEntity.status(HttpStatus.OK).body("Carro excluido com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID inválido");
        }
    }
}
