package digiovannialessandro.gestioneeventiesame.services;

import digiovannialessandro.gestioneeventiesame.entities.Evento;
import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.enums.Role;
import digiovannialessandro.gestioneeventiesame.exceptions.BadRequestException;
import digiovannialessandro.gestioneeventiesame.exceptions.NotFoundException;
import digiovannialessandro.gestioneeventiesame.payloads.NewEventoDTO;
import digiovannialessandro.gestioneeventiesame.repositories.EventiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventiRepository eventiRepository;

    public Evento creazioneEvento(NewEventoDTO payload, Utente organizzatore){
        if (organizzatore.getRole() != Role.ORGANIZZATORE){
            throw new BadRequestException("Solo gli organizzatori possono creare eventi!!!");
        }
        Evento newEvento = new Evento(organizzatore, payload.maxPeople(), payload.date(),payload.description(),payload.location(), payload.title());
        return eventiRepository.save(newEvento);
    }

    public Evento findById(int eventoId) {
        return this.eventiRepository.findById(eventoId).orElseThrow(() -> new NotFoundException(eventoId));
    }
    public List<Evento> findAll() {
        return eventiRepository.findAll();
    }

    public void findByIdAndDelete(int eventoId) {
        Evento found = this.findById(eventoId);
        this.eventiRepository.delete(found);
    }


}
