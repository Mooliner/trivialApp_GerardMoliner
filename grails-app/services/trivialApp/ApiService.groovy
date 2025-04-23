package trivialApp

import groovy.json.JsonSlurper
import java.net.HttpURLConnection

class ApiService {

    def fetchQuestions() {
        try {
            def url = new URL("https://opentdb.com/api.php?amount=5")
            def connection = url.openConnection() as HttpURLConnection
            connection.setRequestMethod('GET')
            connection.connect()

            // Si la resposta és 429 (màxim de peticions), intentem de nou després d'un retard
            if (connection.responseCode == 429) {
                println("Limit de peticions superat. Esperant...")
                Thread.sleep(2000) // Esperem 2 segons
                connection.connect() // Tornem a intentar la connexió
            }

            def jsonText = connection.inputStream.text
            def data = new JsonSlurper().parseText(jsonText)

            return data.results.collect {
                new Question(
                        category: it.category,
                        question: it.question,
                        answer: it.correct_answer
                )
            }

        } catch (Exception e) {
            // Si hi ha un error de connexió o altre error, el gestionem aquí
            println("Error al carregar preguntes: ${e.message}")
            return []
        }
    }
}
