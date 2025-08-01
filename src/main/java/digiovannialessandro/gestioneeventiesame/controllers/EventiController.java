package digiovannialessandro.gestioneeventiesame.controllers;

import digiovannialessandro.gestioneeventiesame.entities.Evento;
import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.payloads.NewEventoDTO;
import digiovannialessandro.gestioneeventiesame.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventi")
public class EventiController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAll() {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    public Evento getById(@PathVariable int id) {
        return eventoService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public Evento creazioneEvento(@RequestBody @Valid NewEventoDTO body, @AuthenticationPrincipal Utente currentUtente) {
        return eventoService.creazioneEvento(body, currentUtente);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public void deleteEvento(@PathVariable int id,
                             @AuthenticationPrincipal Utente currentUser) {
        Evento evento = eventoService.findById(id);

        if (evento.getOrganizzatore().getId() != currentUser.getId()) {
            throw new RuntimeException("Puoi cancellare solo i tuoi eventi.");
        }

        eventoService.findByIdAndDelete(id);
    }
}

