/* (C) 2024 */
package com.rangerforce.spockexample.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Value
public class Starship {
    String name;
    ShipStatus shipStatus;
    ShipClass shipClass;
    Integer crewCount;
    List<CrewMember> commandCrew;

    public enum ShipStatus {
        @JsonProperty("Commissioned")
        COMMISSIONED,
        @JsonProperty("Decommissioned")
        DECOMMISSIONED,
        @JsonProperty("Destroyed")
        DESTROYED,
    }

    public enum ShipClass {
        @JsonProperty("Constitution")
        CONSTITUTION,
        @JsonProperty("Intrepid")
        INTREPID,
        @JsonProperty("Galaxy")
        GALAXY,
        @JsonProperty("Nova")
        NOVA
    }
}
