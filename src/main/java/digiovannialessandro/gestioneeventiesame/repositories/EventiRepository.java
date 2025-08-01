package digiovannialessandro.gestioneeventiesame.repositories;

import digiovannialessandro.gestioneeventiesame.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventiRepository extends JpaRepository<Evento,Integer> {
}
