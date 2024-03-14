/* (C) 2024 */
package com.rangerforce.spockexample.web;

import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarFleetShipResource {
    @GetMapping("/starships")
    public List<String> getShipNames() {
        return Collections.emptyList(); // TODO implement
    }
}
