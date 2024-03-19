package com.rangerforce.spockexample.domain.repository


import spock.lang.Shared
import spock.lang.Specification

class StarshipsRepositorySpec extends Specification {
    @Shared StarshipsRepository starshipsRepository

    public void setup() {
        starshipsRepository = new PredefinedStarshipsRepository();
    }

    def "when findByRegistryName is called with ncc-1864 then throws RecordNotFoundException"() {
        given:
        def registryName = "ncc-1864"

        when:
        starshipsRepository.findByRegistryName(registryName)

        then:
        RecordNotFoundException e = thrown()
        e.message.equals(String.format("Could not find a starship with registry name %s", registryName))
    }

    def "when findByRegistryName is called with ncc-1701-d then returns a starship"() {
        given:
        def registryName = "ncc-1701-d"

        when:
        var starship = starshipsRepository.findByRegistryName(registryName)

        then:
        Objects.nonNull(starship)
        !starship.name.isEmpty()
    }
}
