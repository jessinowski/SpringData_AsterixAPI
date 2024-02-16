package com.github.springdata_asterixapi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {
    private final CharacterRepo repo = mock(CharacterRepo.class);
    private final IdService idService =mock(IdService.class);
    AsterixService service = new AsterixService(repo,idService);
    @Test
    void getAllCharacters_shouldReturnEmptyList_whenCalledInitially() {
        //GIVEN
        List<Character> expected = new ArrayList<>();
        when(repo.findAll()).thenReturn(new ArrayList<>());
        //WHEN
        List<Character> actual = service.getAllCharacters();
        //THEN
        assertEquals(expected,actual);
    }
    @Test
    void getAllCharacters_shouldReturnListWithOneCharacter() {
        //GIVEN
        List<Character> expected = List.of(new Character("1","Jessi",30,"Boulderer"));
        when(repo.findAll()).thenReturn(List.of(new Character("1","Jessi",30,"Boulderer")));
        //WHEN
        List<Character> actual = service.getAllCharacters();
        //THEN
        assertEquals(expected,actual);
    }

    @Test
    void findById_shouldReturnCharWithId1_whenSearchingForId1() {
        //GIVEN
        Optional<Character> expected = Optional.of(new Character("1","Jessi",30,"Boulderer"));
        when(repo.findById("1")).thenReturn(Optional.of(new Character("1", "Jessi", 30, "Boulderer")));
        //WHEN
        Optional<Character> actual = service.findById("1");
        //THEN
        assertEquals(expected,actual);
    }

    @Test
    void deleteById() {
        //GIVEN
        Character character1 = new Character("1","Jessi",30,"Boulderer");
        Character character2 = new Character("2","Georg",32,"Boulderer");
        List<Character> characters = List.of(character1, character2);
        String expected = "Character with ID 2 deleted.";
        //WHEN
        String actual = service.deleteById("2");
        //THEN
        assertEquals(expected, actual);
        verify(repo).deleteById("2");
    }

    @Test
    void save() {
        //GIVEN
        CharacterDto newCharacter= new CharacterDto("Jessi",30,"Boulderer");
        Character expected= new Character("1","Jessi",30,"Boulderer");
        when(idService.randomId()).thenReturn("1");
        when(repo.save(new Character("1","Jessi",30,"Boulderer"))).thenReturn(expected);
        //THEN
        Character actual = service.save(newCharacter);
        //WHEN
        assertEquals(expected,actual);
        verify(idService).randomId();
    }
}