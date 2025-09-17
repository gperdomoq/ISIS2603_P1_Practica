package co.edu.uniandes.dse.parcial1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class EstadioEntity extends BaseEntity {

    private String nombre;
    private Long precioAlquiler;
    private int capacidad;
    private String nombreCiudad;


    @PodamExclude
    @ManyToOne @JoinColumn(name = "concierto")
    private ConciertoEntity concierto;
}
