package digiovannialessandro.gestioneeventiesame.payloads;


import jakarta.validation.constraints.NotNull;

public record NewPrenotazioneDTO(
        @NotNull(message = "L'ID dell'utente è obbligatorio")
        Integer utenteId,

        @NotNull(message = "L'ID dell'evento è obbligatorio")
        Integer eventoId)  {
}
