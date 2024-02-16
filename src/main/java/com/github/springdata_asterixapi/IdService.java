package com.github.springdata_asterixapi;

import java.util.UUID;

public class IdService {
    public String randomId(){
        return UUID.randomUUID().toString();
    }
}
