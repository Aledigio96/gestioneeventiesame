package digiovannialessandro.gestioneeventiesame.controllers;

import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.payloads.NewUtenteDTO;
import digiovannialessandro.gestioneeventiesame.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
public class UtentiController {

    @Autowired
    private UtentiService utentiService;

    @GetMapping("/me")
    public Utente getCurrentUser(@AuthenticationPrincipal Utente currentUser) {
        return currentUser;
    }

    @PutMapping("/me")
    public Utente updateOwnProfile(@AuthenticationPrincipal Utente currentAuthenticatedUser, @RequestBody @Validated NewUtenteDTO payload) {
        return this.utentiService.findByIdAndUpdate(currentAuthenticatedUser.getId(), payload);
    }

    @DeleteMapping("/me")
    public void deleteOwnProfile(@AuthenticationPrincipal Utente currentAuthenticatedUser) {
        this.utentiService.findByIdAndDelete(currentAuthenticatedUser.getId());
    }
}
