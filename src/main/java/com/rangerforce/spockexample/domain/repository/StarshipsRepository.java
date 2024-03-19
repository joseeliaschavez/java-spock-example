/* (C) 2024 */
package com.rangerforce.spockexample.domain.repository;

import com.rangerforce.spockexample.domain.model.Starship;
import java.util.List;

public interface StarshipsRepository {
    List<String> findAll();

    Starship findByRegistryName(String name);
}
