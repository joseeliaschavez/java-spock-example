/* (C) 2024 */
package com.rangerforce.spockexample.domain.model;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Value
public class CrewMember {
    String name;
    String rank;
    String title;
}
