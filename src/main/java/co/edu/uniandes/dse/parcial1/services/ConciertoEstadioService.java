package co.edu.uniandes.dse.parcial1.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConciertoEstadioService {

    @Autowired
    private ConciertoRepository conciertoRepository;


    @Transactional
    public ConciertoEntity createConcierto(ConciertoEntity concierto) throws IllegalAccessException {
        log.info("Inicia proceso de creación del concierto");

        if (conciertoRepository.findById(concierto.getId()) != null)
            throw new IllegalAccessException("Ya existe un concierto con el mismo Id \"" + concierto.getId() + "\"");

        if (conciertoRepository.findByFecha(concierto.getFecha()) == LocalDateTime.now() && conciertoRepository.findByFecha(concierto.getFecha()) 
            throw new IllegalAccessException("Ya existe un concierto con el mismo nombre \"" + concierto.getNombre() + "\"");
        return conciertoRepository.save(concierto);
    }


    public void asignarEstadioAConcierto(ConciertoEntity concierto, EstadioEntity estadio) {
        concierto.getEstadios().add(estadio);
        estadio.setConcierto(concierto);
    }

    public void desasignarEstadioDeConcierto(ConciertoEntity concierto, EstadioEntity estadio) {
        concierto.getEstadios().remove(estadio);
        estadio.setConcierto(null);
    }



}
