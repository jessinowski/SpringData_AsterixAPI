package com.github.springdata_asterixapi;

import lombok.With;

@With
public record Character(String id, String name, int age, String profession) {

}
