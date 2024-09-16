package programacion.ejemplo.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import programacion.ejemplo.DTO.MarcaDTO;
import programacion.ejemplo.Mapper.MarcaMapper;
import programacion.ejemplo.model.Marca;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import programacion.ejemplo.repository.MarcaRepository;

import java.util.List;

@Service

public class MarcaService implements IMarcaService {
    private static final Logger logger = LoggerFactory.getLogger(MarcaService.class);
    @Autowired
    private MarcaRepository modelRepository;

    @Override
    public List<MarcaDTO> listar() {
        List<Marca> marcas = modelRepository.findByEstado(Marca.COMUN);
        return marcas.stream().map(MarcaMapper::toDTO).toList();
    }

    @Override
    public Marca buscarPorId(Integer id) {

        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> guardar(MarcaDTO modelDTO) {
        // Convertir el DTO a la entidad
        Marca model = MarcaMapper.toEntity(modelDTO);

        // Guardar la entidad en la base de datos
        Marca savedModel = modelRepository.save(model);

        // Convertir la entidad guardada de nuevo a DTO
        MarcaDTO savedModelDTO = MarcaMapper.toDTO(savedModel);

        // Retornar el DTO dentro de un ResponseEntity con un código 201 (CREATED)
        return new ResponseEntity<>("Marca guardada exitosamente con ID: " + savedModel.getId(), HttpStatus.CREATED);
    }

    @Override
    public Marca guardar(Marca model) {
        return modelRepository.save(model);
    }

    @Override
    public void eliminar(Marca model) {

        model.asEliminar();
        modelRepository.save(model);
    }

    public boolean isDenominacionExiste(String denominacion) {
        return modelRepository.findByDenominacion(denominacion).isPresent();
    }
}
