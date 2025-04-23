package trivialApp

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.crypto.password.PasswordEncoder

@Secured(['ROLE_ADMIN'])
class UserController {

    SpringSecurityService springSecurityService
    PasswordEncoder passwordEncoder

    def status() {
        def currentUser = springSecurityService.currentUser
        if (currentUser) {
            render "Usuari autenticat: ${currentUser.username}"
        } else {
            render "No hi ha cap usuari autenticat"
        }
    }

    def create() {
        render(view: "create")
    }

    def save() {
        def user = new User(username: params.username, password: params.password)
        user.password = passwordEncoder.encode(user.password)
        if (user.save(flush: true)) {
            // Assignar el rol USER al nou usuari
            def userRole = Role.findByAuthority('ROLE_USER')
            new UserRole(user: user, role: userRole).save(flush: true)
            redirect(action: "index", controller: "question")
        } else {
            render(view: "create", model: [user: user])
        }
    }
}
