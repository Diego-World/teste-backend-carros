package br.com.wswork.cars.repository;

import br.com.wswork.cars.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Marca findByNomeMarca(String nomeMarca);
}
