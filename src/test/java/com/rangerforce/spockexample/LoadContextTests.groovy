package com.rangerforce.spockexample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTests extends Specification {

	@Autowired (required = false)
	private HelloController helloController

	def "when context is loaded then all expected beans are created"() {
		expect: "the HelloController is created"
		helloController
	}

}
