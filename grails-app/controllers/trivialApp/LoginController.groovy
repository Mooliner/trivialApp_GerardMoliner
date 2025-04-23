package trivialApp

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class LoginController {

    AuthenticationManager authenticationManager
    SpringSecurityService springSecurityService

    def index() {
        render(view: 'login')
    }

    def authenticate(String username, String password) {
        try {
            def auth = new UsernamePasswordAuthenticationToken(username, password)
            def result = authenticationManager.authenticate(auth)
            SecurityContextHolder.context.authentication = result

            redirect(uri: springSecurityService.redirectUri ?: '/question/index')
        } catch (Exception e) {
            flash.message = "Nom d'usuari o contrasenya incorrecte"
            redirect(action: 'index')
        }
    }

    def logout() {
        springSecurityService.logout()
        redirect(action: "index")
    }
}
