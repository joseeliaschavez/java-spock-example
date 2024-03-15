/* (C) 2024 */
package com.rangerforce.spockexample.domain.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PredefinedStarshipsRepository implements StarshipsRepository {
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
}
