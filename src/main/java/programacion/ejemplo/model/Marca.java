package programacion.ejemplo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String denominacion;
    private String observaciones;
    @NotNull
    private int estado;
         public static final int COMUN=0;
        public static final int ELIMINADO=1;

        public void asEliminar() {
             this.setEstado(1);
       }

}
