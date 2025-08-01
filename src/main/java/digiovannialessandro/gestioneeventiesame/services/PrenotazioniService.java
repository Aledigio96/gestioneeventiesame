package digiovannialessandro.gestioneeventiesame.services;

import digiovannialessandro.gestioneeventiesame.entities.Evento;
import digiovannialessandro.gestioneeventiesame.entities.Prenotazione;
import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.repositories.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioniService {
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    @Autowired
    private EventoService eventoService;

    public Prenotazione prenotazione(int eventoId, Utente utente){
        Evento evento=eventoService.findById(eventoId);
        Prenotazione prenotazione=new Prenotazione(evento,utente);
        return prenotazioniRepository.save(prenotazione);
    }
}
