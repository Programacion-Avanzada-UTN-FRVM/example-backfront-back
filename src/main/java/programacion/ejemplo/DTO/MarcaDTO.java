package programacion.ejemplo.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MarcaDTO {

    private Integer id;
    @NotBlank(message = "La denominación no puede estar vacía.")
    private String denominacion;
    private String observaciones;
    private int estado;

}
