package trivialApp

class User {
    String username
    String password
    boolean enabled = true

    static mapWith = "mongo"

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }
}
