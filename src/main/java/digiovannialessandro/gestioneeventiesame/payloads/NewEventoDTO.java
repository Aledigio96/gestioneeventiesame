package digiovannialessandro.gestioneeventiesame.payloads;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewEventoDTO(
        @NotBlank(message = "Il titolo è obbligatorio")
        String title,
        @NotBlank(message = "La location è obbligatoria")
        String location,
        @NotBlank(message = "La descrizione è obbligatoria")
        String description,
        @NotNull(message = "La data è obbligatoria")
        LocalDate date,
        @Min(value = 1,message = "il numero min di partecipanti deve essere 1")
        int maxPeople,
        @NotNull(message = "L'organizzatore è obbligatorio")
        Integer organizzatoreId

) {
}
