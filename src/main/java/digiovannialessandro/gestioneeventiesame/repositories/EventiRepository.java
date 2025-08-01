package digiovannialessandro.gestioneeventiesame.repositories;

import digiovannialessandro.gestioneeventiesame.entities.Evento;
import digiovannialessandro.gestioneeventiesame.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventiRepository extends JpaRepository<Evento,Integer> {
    Optional<Evento> findById(Integer id);
}
