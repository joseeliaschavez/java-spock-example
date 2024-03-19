/* (C) 2024 */
package com.rangerforce.spockexample.web;

import com.rangerforce.spockexample.domain.model.Starship;
import com.rangerforce.spockexample.domain.repository.RecordNotFoundException;
import com.rangerforce.spockexample.domain.repository.StarshipsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class StarFleetShipResource {
    private final StarshipsRepository starshipsRepository;

    @GetMapping("/starships")
    public List<String> getShipNames() {
        return starshipsRepository.findAll();
    }

    @GetMapping("/starship/{name}")
    public Starship getStarship(@PathVariable String name) {
        try {
            return starshipsRepository.findByRegistryName(name);
        } catch (RecordNotFoundException notFoundException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, notFoundException.getMessage());
        }
    }
}
