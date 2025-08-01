package digiovannialessandro.gestioneeventiesame.controllers;

import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.exceptions.ValidationException;
import digiovannialessandro.gestioneeventiesame.payloads.LoginDTO;
import digiovannialessandro.gestioneeventiesame.payloads.LoginRespDTO;
import digiovannialessandro.gestioneeventiesame.payloads.NewUtenteDTO;
import digiovannialessandro.gestioneeventiesame.payloads.NewUtenteRespDTO;
import digiovannialessandro.gestioneeventiesame.services.AuthService;
import digiovannialessandro.gestioneeventiesame.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UtentiService utentiService;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody LoginDTO body) {
        String accessToken = authService.checkCredentialsAndGenerateToken(body);
        return new LoginRespDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewUtenteRespDTO save(@RequestBody @Validated NewUtenteDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {

            throw new ValidationException(validationResult.getFieldErrors()
                    .stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        } else {
            Utente newUtente = this.utentiService.save(payload);
            return new NewUtenteRespDTO(newUtente.getId());
        }



    }
}
