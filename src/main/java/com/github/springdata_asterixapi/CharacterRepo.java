package com.github.springdata_asterixapi;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {
   List<Character> findByName(String name);

   List<Character> findByAge(int age);

   List<Character> findByProfession(String profession);
}
