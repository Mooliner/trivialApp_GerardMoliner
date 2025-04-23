package trivialApp

class Role {
    String authority

    static mapWith = "mongo"

    static constraints = {
        authority blank: false, unique: true
    }
}
