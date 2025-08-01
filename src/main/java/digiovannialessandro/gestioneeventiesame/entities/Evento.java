package digiovannialessandro.gestioneeventiesame.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String location;
    private String description;
    private LocalDate date;
    private int maxPeople;
    @ManyToOne
    @JoinColumn(name = "organizzatore_id",nullable = false)
    private Utente organizzatore;

    public Evento(Utente organizzatore, int maxPeople, LocalDate date, String description, String location, String title) {
        this.organizzatore = organizzatore;
        this.maxPeople = maxPeople;
        this.date = date;
        this.description = description;
        this.location = location;
        this.title = title;
    }

    public void setOrganizzatore(Utente organizzatore) {
        this.organizzatore = organizzatore;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
