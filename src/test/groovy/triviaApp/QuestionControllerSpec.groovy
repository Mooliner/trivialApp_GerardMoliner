package triviaApp

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class QuestionControllerSpec extends Specification implements ControllerUnitTest<QuestionController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
