package digiovannialessandro.gestioneeventiesame.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Integer id) {
        super("La risorsa con id " + id + " non è stata trovata!");
    }
}
