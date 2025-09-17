package co.edu.uniandes.dse.parcial1.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class ConciertoEntity extends BaseEntity {

    private String nombre;
    private LocalDateTime fecha;
    private String nombreArtista;
    private Long presupuesto;
    private int aforo;

    @PodamExclude
    @OneToMany(mappedBy = "concierto", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<EstadioEntity> estadios = new ArrayList<>();
}
