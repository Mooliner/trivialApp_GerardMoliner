package trivialApp

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class QuestionController {

    ApiService apiService
    SpringSecurityService springSecurityService


    def index() {
        // Verifiquem si l'usuari està autenticat
        def currentUser = springSecurityService?.currentUser
        def isAdmin = currentUser?.authorities?.any { it.authority == 'ROLE_ADMIN' }

        if (currentUser) {
            println "Usuari autenticat: ${currentUser.username}"
            println "Rols de l'usuari actual: ${currentUser.authorities*.authority}"
        } else {
            println "L'usuari no està autenticat"
        }

        // Preguntes desades a la base de dades
        def questions = Question.list()

        // Preguntes generades actualment a la sessió
        def newQuestions = session.newQuestions ?: []

        // Passem les dades a la vista
        render(view: "index", model: [
                questions: questions,
                newQuestions: newQuestions,
                currentUser: currentUser,
                isAdmin: isAdmin
        ])
    }



    def generate() {
        // Generar sempre 5 preguntes noves
        def questions = apiService.fetchQuestions()

        // Afegir les noves preguntes a la sessió
        def currentQuestions = session.newQuestions ?: []
        session.newQuestions = currentQuestions + questions // Afegir les noves preguntes

        // Redirigir a la pàgina principal
        redirect(action: "index")
    }

    def save(String category, String question, String answer) {
        // Desa la pregunta a la base de dades
        new Question(category: category, question: question, answer: answer).save(flush: true)

        // Elimina la pregunta desada de la sessió
        def remaining = session.newQuestions?.findAll {
            it.category != category || it.question != question || it.answer != answer
        }
        session.newQuestions = remaining

        redirect(action: "index")
    }
}
