/* (C) 2024 */
package com.rangerforce.spockexample.web;

import com.rangerforce.spockexample.domain.repository.StarshipsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StarFleetShipResource {
    private final StarshipsRepository starshipsRepository;

    @GetMapping("/starships")
    public List<String> getShipNames() {
        return starshipsRepository.findAll();
    }
}
