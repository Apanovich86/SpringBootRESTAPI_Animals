package program.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import program.entities.Animal;
import program.repositories.AnimalRepository;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final AnimalRepository animalRepository;

    @GetMapping("/")
    public List<Animal> index() {
        return animalRepository.findAll();
    }

    @PostMapping("/")
    Animal newAnimal(@RequestBody Animal newAnimal) {
        return animalRepository.save(newAnimal);
    }

    @GetMapping("/{id}")
    Animal one(@PathVariable int id) {

        return animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    @PutMapping("/{id}")
    Animal replaceAnimal(@RequestBody Animal newAnimal, @PathVariable int id) {

        return animalRepository.findById(id)
                .map(animal -> {
                    animal.setAnimalName(newAnimal.getAnimalName());
                    animal.setKindAnimal(newAnimal.getKindAnimal());
                    animal.setAnimalAge(newAnimal.getAnimalAge());
                    return animalRepository.save(animal);
                })
                .orElseGet(() -> {
                    newAnimal.setId(id);
                    return animalRepository.save(newAnimal);
                });
    }

    @DeleteMapping("/{id}")
    void deleteAnimal(@PathVariable int id) {
        animalRepository.deleteById(id);
    }
}