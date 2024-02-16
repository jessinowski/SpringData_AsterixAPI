package com.github.springdata_asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService service;

    @GetMapping
    public List<Character> getAllCharacters() {
        return service.getAllCharacters();
        //        return List.of(
//                new Character("1", "Asterix", 35, "Krieger"),
//                new Character("2", "Obelix", 35, "Lieferant"),
//                new Character("3", "Miraculix", 60, "Druide"),
//                new Character("4", "Majestix", 60, "Häuptling"),
//                new Character("5", "Troubadix", 25, "Barden"),
//                new Character("6", "Gutemine", 35, "Häuptlingsfrau"),
//                new Character("7", "Idefix", 5, "Hund"),
//                new Character("8", "Geriatrix", 70, "Rentner"),
//                new Character("9", "Automatix", 35, "Schmied"),
//                new Character("10", "Grockelix", 35, "Fischer")
    }

    @GetMapping("/{name}")
    public List<Character> getCharacterByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/{id}")
    public Optional<Character> getCharacterById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/{age}")
    public List<Character> getCharacterByAge(@PathVariable int age) {
        return service.findByAge(age);
    }

    @GetMapping("/{profession}")
    public List<Character> getCharacterByProfession(@PathVariable String profession) {
        return service.findByProfession(profession);
    }

    @GetMapping("/averageAge/{profession}")
    public double getAverageAgeByProfession(@PathVariable String profession) {

        List<Character> charactersByProfession = service.getAllCharacters().stream()
                .filter(character -> character.profession().equals(profession))
                .toList();

        double sum = charactersByProfession.stream()
                .mapToInt(character -> character.age())
                .sum();

        return sum/charactersByProfession.size();
    }

    @PostMapping("/create")
    public Character saveCharacter(@RequestBody CharacterDto newCharacter) {
        return service.save(newCharacter);
    }

    @PutMapping("/update/{id}")
    public Character updateCharacterById(@PathVariable String id, @RequestBody CharacterDto updatedCharacter) {
        return service.save(updatedCharacter);
    }

    @PutMapping("/update/{name}")
    public Character updateCharacterByName(@PathVariable String name, @RequestBody CharacterDto updatedCharacter) {
        return service.save(updatedCharacter);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCharacterById(@PathVariable String id) {
        service.deleteById(id);
        return "Character with ID: " + id + " deleted.";
    }


}
