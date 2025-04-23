package triviaApp

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class QuestionSpec extends Specification implements DomainUnitTest<Question> {

     void "test domain constraints"() {
        when:
        Question domain = new Question()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
