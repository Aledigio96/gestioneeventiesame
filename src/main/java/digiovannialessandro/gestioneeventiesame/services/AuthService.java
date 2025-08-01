package digiovannialessandro.gestioneeventiesame.services;

import digiovannialessandro.gestioneeventiesame.entities.Utente;
import digiovannialessandro.gestioneeventiesame.exceptions.UnauthorizedException;
import digiovannialessandro.gestioneeventiesame.payloads.LoginDTO;
import digiovannialessandro.gestioneeventiesame.tools.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UtentiService utentiService;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;

    public String checkCredentialsAndGenerateToken(LoginDTO body) {

        Utente found = this.utentiService.findByEmail(body.username());

        if (bcrypt.matches(body.password(), found.getPassword())) {
            String accessToken = jwtTools.createToken(found);

            return accessToken;
        } else {
            throw new UnauthorizedException("Credenziali errate!");
        }
    }
}
