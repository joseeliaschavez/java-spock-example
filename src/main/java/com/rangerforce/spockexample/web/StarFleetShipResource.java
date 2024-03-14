package com.rangerforce.spockexample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class StarFleetShipResource {
    @GetMapping("/starships")
    public List<String> getShipNames() {
        return Collections.emptyList(); // TODO implement
    }
}
