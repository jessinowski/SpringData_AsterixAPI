package com.github.springdata_asterixapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {

    private String name;
    private int age;
    private String profession;
}
