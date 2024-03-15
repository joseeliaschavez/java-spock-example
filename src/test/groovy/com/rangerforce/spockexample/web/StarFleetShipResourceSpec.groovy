package com.rangerforce.spockexample.web

import com.rangerforce.spockexample.domain.repository.StarshipsRepository
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
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

    @SpringBean
    private StarshipsRepository starshipsRepository = Stub() {
        findAll() >> [
                "USS Enterprise (NCC-1701)",
                "USS Voyager (NCC-74656)",
                "USS Defiant (NX-74205)"
        ]
    }

    def "when get is performed then the response has status 200 and content is list of strings"() {
        expect: "Status is 200 and the response is list of strings"
        mvc.perform(get("/starships")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("\$", hasSize(3)))
                .andExpect(jsonPath("\$[*]").value(hasItems(instanceOf(String.class))))
    }
}
