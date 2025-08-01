package digiovannialessandro.gestioneeventiesame.services;

import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.exceptions.NotFoundException;
import digiovannialessandro.gestioneeventiesame.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UtentiService {

    @Autowired
    private UtentiRepository utentiRepository;

    public Utente findById(int utenteId) {
        return this.utentiRepository.findById(utenteId).orElseThrow(() -> new NotFoundException(utenteId));
    }
}
