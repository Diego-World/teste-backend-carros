package br.com.wswork.cars.Service;

import br.com.wswork.cars.DTO.CarroDTO;
import br.com.wswork.cars.model.Carro;
import br.com.wswork.cars.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    public List<CarroDTO> getAllCarros(){
        List<Carro> carros = this.carroRepository.findAll();

        List<CarroDTO> carrosDTO = carros.stream()
                .map(this::convertCarToCarroDTO)
                .collect(Collectors.toList());

        return carrosDTO;
    }
    private CarroDTO convertCarToCarroDTO(Carro carro) {
        return new CarroDTO(
                carro.getId(),
                carro.getTimeStampCadastro().toEpochSecond(ZoneOffset.UTC),
                carro.getModelo().getModeloId(),
                carro.getAno(),
                carro.getCombustivel(),
                carro.getNumPortas(),
                carro.getCor(),
                carro.getModelo().getNome(),
                carro.getModelo().getValorFipe()
        );
    }
}
