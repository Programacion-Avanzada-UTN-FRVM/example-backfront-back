package programacion.ejemplo.repository;

import programacion.ejemplo.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MarcaRepository extends JpaRepository  <Marca,Integer>{

    List<Marca> findByEstado(int estado);

    Optional<Marca> findByDenominacion(String denominacion);
}

