package trivialApp

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ApiServiceSpec extends Specification implements ServiceUnitTest<ApiService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
