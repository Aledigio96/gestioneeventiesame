package digiovannialessandro.gestioneeventiesame.payloads;

import java.time.LocalDate;

public record NewEventoRespDTO(
        int id,
        String title,
        String location,
        String description,
        LocalDate date,
        int maxPeople,
        NewUtenteRespDTO organizzatore
) {
}
