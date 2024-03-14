package com.rangerforce.spockexample.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@AutoConfigureMockMvc
@WebMvcTest
class StarFleetShipResourceSpec extends Specification {

    @Autowired
    private MockMvc mvc

    def "when get is performed then the response has status 200 and content is list of strings"() {
        expect: "Status is 200 and the response is list of strings"
        mvc.perform(get("/starships"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("\$", hasSize(3)))
                .andExpect(jsonPath("\$[*]").value(hasItems(instanceOf(String.class))))
    }

}
