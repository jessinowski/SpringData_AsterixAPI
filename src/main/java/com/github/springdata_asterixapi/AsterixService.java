package com.github.springdata_asterixapi;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsterixService {
    private final CharacterRepo characterRepo;
    private final IdService idService;

    public List<Character> getAllCharacters(){
        return characterRepo.findAll();
    }

    List<Character> findByName(String name){
        return characterRepo.findByName(name);
    }

    List<Character> findByAge(int age) {
        return characterRepo.findByAge(age);
    }

    List<Character> findByMaximumAge(int age){
        return characterRepo.findAll().stream()
                .filter(character -> character.age()<=age)
                .toList();
    }

    List<Character> findByProfession(String profession) {
        return characterRepo.findByProfession(profession);
    }

    public Optional<Character> findById(String id) {
        return characterRepo.findById(id);
    }

    public Character save(CharacterDto newCharacterDto) {
        Character newCharacter = new Character(idService.randomId(), newCharacterDto.getName(), newCharacterDto.getAge(), newCharacterDto.getProfession());
        return characterRepo.save(newCharacter);
    }
    public Character update(Character updatedCharacter) {
        return characterRepo.save(updatedCharacter);
    }

    public String deleteById(String id) {
        characterRepo.deleteById(id);
        return "Character with ID "+id+" deleted.";
    }


    public List<Character> filterCharacter(String id, String name, int age, String profession) {
        return characterRepo.findAll().stream()
                .filter(character -> character.id().equals(id) ||
                        character.name().equals(name) ||
                        character.age() == age ||
                        character.profession().equals(profession))
                .toList();
    }
}
