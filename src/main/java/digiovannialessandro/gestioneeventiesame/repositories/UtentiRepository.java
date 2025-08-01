package digiovannialessandro.gestioneeventiesame.repositories;

import digiovannialessandro.gestioneeventiesame.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentiRepository extends JpaRepository<Utente,Integer> {
}
