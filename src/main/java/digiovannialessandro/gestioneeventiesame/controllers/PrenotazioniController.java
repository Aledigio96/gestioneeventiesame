package digiovannialessandro.gestioneeventiesame.controllers;

import digiovannialessandro.gestioneeventiesame.entities.Prenotazione;
import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.services.PrenotazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

    @Autowired
    private PrenotazioniService prenotazioniService;
    @PostMapping("/{eventoId}")
    public Prenotazione creaPrenotazione(
            @PathVariable int eventoId,
            @AuthenticationPrincipal Utente currentUser) {
        return prenotazioniService.prenotazione(eventoId, currentUser);
    }
}
