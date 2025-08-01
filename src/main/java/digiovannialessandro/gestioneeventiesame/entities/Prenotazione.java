package digiovannialessandro.gestioneeventiesame.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "prenotazioni")
@Getter
@ToString

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    public Prenotazione(Evento evento, Utente utente) {
        this.evento = evento;
        this.utente = utente;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
