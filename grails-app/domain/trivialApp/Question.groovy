package trivialApp

class Question {
    String category
    String question
    String answer

    static mapWith = "mongo"

    static constraints = {
        category blank: false
        question blank: false
        answer blank: false
    }
}
