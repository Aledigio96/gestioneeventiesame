package digiovannialessandro.gestioneeventiesame.services;

import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.enums.Role;
import digiovannialessandro.gestioneeventiesame.exceptions.BadRequestException;
import digiovannialessandro.gestioneeventiesame.exceptions.NotFoundException;
import digiovannialessandro.gestioneeventiesame.payloads.NewUtenteDTO;
import digiovannialessandro.gestioneeventiesame.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtentiService {

    @Autowired
    private UtentiRepository utentiRepository;
    @Autowired
    private PasswordEncoder bcrypt;

    public Utente save(NewUtenteDTO payload) {

        this.utentiRepository.findByEmail(payload.email()).ifPresent(user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già in uso!");
        });
        Utente newUtente = new Utente(payload.name(), payload.surname(), payload.username(), bcrypt.encode(payload.password()), Role.USER_NORMALE, payload.email());
        Utente savedUtente = this.utentiRepository.save(newUtente);
        return savedUtente;
    }

    public Utente findById(int utenteId) {
        return this.utentiRepository.findById(utenteId).orElseThrow(() -> new NotFoundException(utenteId));
    }

    public Utente findByEmail(String email) {
        return utentiRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utente non trovato"));
    }
    public Utente findByIdAndUpdate(int userId, NewUtenteDTO payload) {

        Utente found = this.findById(userId);


        if (!found.getEmail().equals(payload.email()))
            this.utentiRepository.findByEmail(payload.email()).ifPresent(user -> {
                throw new BadRequestException("L'email " + user.getEmail() + " è già in uso!");
            });


        found.setName(payload.name());
        found.setSurname(payload.surname());
        found.setEmail(payload.email());
        found.setPassword(payload.password());
        found.setUsername(payload.surname());

        Utente modifiedUser = this.utentiRepository.save(found);


        return modifiedUser;
    }
    public void findByIdAndDelete(int utenteId) {
        Utente found = this.findById(utenteId);
        this.utentiRepository.delete(found);
    }
}
