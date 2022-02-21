package program.controllers;

public class AnimalNotFoundException extends RuntimeException {
    AnimalNotFoundException(int id) {
        super("Could not find animal " + id);
    }
}
