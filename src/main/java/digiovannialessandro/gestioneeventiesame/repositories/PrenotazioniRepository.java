package digiovannialessandro.gestioneeventiesame.repositories;

import digiovannialessandro.gestioneeventiesame.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione,Integer> {
}
