/* (C) 2024 */
package com.rangerforce.spockexample.domain.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rangerforce.spockexample.domain.model.Starship;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class PredefinedStarshipsRepository implements StarshipsRepository {
    private final Map<String, Starship> starships = new HashMap<>();

    @Override
    public List<String> findAll() {
        return List.of(
                "USS Enterprise (NCC-1701)",
                "USS Voyager (NCC-74656)",
                "USS Defiant (NX-74205)",
                "USS Discovery (NCC-1031)",
                "USS Excelsior (NX-2000/NCC-2000)",
                "USS Enterprise-D (NCC-1701-D)",
                "USS Enterprise-E (NCC-1701-E)",
                "USS Enterprise-A (NCC-1701-A)",
                "USS Reliant (NCC-1864)",
                "USS Titan (NCC-80102)",
                "USS Columbia (NX-02)",
                "USS Saratoga (NCC-1887)",
                "USS Stargazer (NCC-2893)",
                "USS Kelvin (NCC-0514)",
                "USS Grissom (NCC-638)",
                "USS Farragut (NCC-60597)",
                "USS Sao Paulo (NCC-75633)",
                "USS Yorktown (NCC-1717)",
                "USS Prometheus (NX-59650)",
                "USS Pasteur (NCC-58925)");
    }

    @Override
    public Starship findByRegistryName(String registryName) {
        if (registryName.equalsIgnoreCase("NCC-1701-D")) {
            if (!starships.containsKey(registryName)) {
                readStarshipFile(registryName, "src/main/resources/uss-enterprise-ncc-1701-d.json");
            }

            return starships.get(registryName);
        }
        throw new RecordNotFoundException(
                String.format("Could not find a starship with registry name %s", registryName));
    }

    private void readStarshipFile(String registryName, String filePath) {
        var objectMapper = new ObjectMapper();
        try {
            var jsonFile = new File(filePath);
            var starship = objectMapper.readValue(jsonFile, Starship.class);
            starships.put(registryName, starship);
        } catch (IOException exception) {
            throw new RecordNotFoundException(
                    String.format("Could not find a starship with registry name %s", registryName));
        }
    }
}
