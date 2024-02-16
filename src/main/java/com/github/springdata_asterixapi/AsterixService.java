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
    private IdService idService;

    public List<Character> getAllCharacters(){
        return characterRepo.findAll();
    }

    List<Character> findByName(String name) {
        return characterRepo.findByName(name);
    }

    List<Character> findByAge(int age) {
        return characterRepo.findByAge(age);
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

    public void deleteById(String id) {
        characterRepo.deleteById(id);
    }
}
