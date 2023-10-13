package br.com.wswork.cars.repository;

import br.com.wswork.cars.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
