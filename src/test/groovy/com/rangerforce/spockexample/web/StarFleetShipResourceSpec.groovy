package com.rangerforce.spockexample.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.rangerforce.spockexample.domain.model.Starship
import com.rangerforce.spockexample.domain.repository.RecordNotFoundException
import com.rangerforce.spockexample.domain.repository.StarshipsRepository
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Shared
import spock.lang.Specification

import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest(StarFleetShipResource)
class StarFleetShipResourceSpec extends Specification {
    @Autowired
    private MockMvc mvc

    @Shared Starship ussEnterprise

    @SpringBean
    private StarshipsRepository starshipsRepository = Stub() {
        findAll() >> [
                "USS Enterprise (NCC-1701)",
                "USS Voyager (NCC-74656)",
                "USS Defiant (NX-74205)"
        ]
        findByRegistryName("ncc-1701") >> ussEnterprise
        findByRegistryName(_ as String) >> { throw new RecordNotFoundException("Not Found") }
    }

    def setupSpec() {
        var file = new File("src/test/resources/uss-enterprise-ncc-1701.json")
        var json = file.text
        var objectMapper = new ObjectMapper()
        ussEnterprise = objectMapper.readValue(json, Starship.class)
    }

    def "when /starships is performed then the response has status 200 and content is list of strings"() {
        expect: "Status is 200 and the response is list of strings"
        mvc.perform(get("/starships")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("\$", hasSize(3)))
                .andExpect(jsonPath("\$[*]").value(hasItems(instanceOf(String.class))))
    }

    def "when /starship/ncc-1701 is performed then the response has status 200 and content is a starship"() {
        expect: "Status is 200 and the response is a starship"
        mvc.perform(get("/starship/ncc-1701")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("\$.name", containsString("USS Enterprise")))
                .andExpect(jsonPath("\$.name", containsString("NCC-1701")))
                .andExpect(jsonPath("\$.shipStatus", is("Commissioned")))
                .andExpect(jsonPath("\$.shipClass", is("Constitution")))
    }

    def "when /starship/ncc-1701 is performed then the response has status 200 and starship has a crew"() {
        expect: "Status is 200 and the response has crew information"
        mvc.perform(get("/starship/ncc-1701")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("\$.crewCount", is(431)))
                .andExpect(jsonPath("\$.commandCrew", hasSize(7)))
    }

    def "when /starship/ncc-1864 is performed then the response has status 404"() {
        given:
        expect: "Status is 200 and the response is list of strings"
        mvc.perform(get("/starship/ncc-1864")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
    }
}
