package trivialApp

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.crypto.password.PasswordEncoder

class BootStrap {

    PasswordEncoder passwordEncoder

    def init = { servletContext ->
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(flush: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(flush: true)

        println ">>> BootStrap INIT s'està executant <<<"

        def user = User.findByUsername('usuari1')
        if (!user) {
            user = new User(
                    username: 'usuari1',
                    password: passwordEncoder.encode('1234')
            )
            user.save(flush: true)
            println "Usuari creat: ${user.username} - Hash: ${user.password}"
            new UserRole(user: user, role: userRole).save(flush: true)
            println "Rol assignat a l'usuari '${user.username}': ${userRole.authority}"
        }

        def admin = User.findByUsername('admin')
        if (!admin) {
            admin = new User(
                    username: 'admin',
                    password: passwordEncoder.encode('admin123')
            )
            admin.save(flush: true)
            println "Admin creat: ${admin.username} - Hash: ${admin.password}"
            new UserRole(user: admin, role: adminRole).save(flush: true)
            println "Rol assignat a l'admin '${admin.username}': ${adminRole.authority}"
        }
    }

    def destroy = {}
}
