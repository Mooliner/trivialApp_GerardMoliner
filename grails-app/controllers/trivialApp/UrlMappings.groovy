package trivialApp

class UrlMappings {
    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/user/create"(controller: "user", action: "create")
        "/user/save"(controller: "user", action: "save")
        "/user/status"(controller: "user", action: "status")

        "/login"(controller: "login", action: "index")
        "/logout"(controller: "login", action: "logout")


        "/"(controller: "question", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
