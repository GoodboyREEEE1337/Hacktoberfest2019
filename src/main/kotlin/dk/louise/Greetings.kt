package dk.louise

import io.ktor.application.call
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    // Starts a server at http://localhost:8080
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondRedirect("/greeting/Louise")
            }

            // You can receive parameters from the URL with "{PARAMETER_NAME}"
            // In this case we bind a name to the "name" parameter. They can be read from
            // call.parameters["PARAMETER_NAME"]
            get("/greeting/{name}") {
                val name = call.parameters["name"]
                call.respondText("Hello, ${name}!")
            }
        }
    }.start(wait = true)
}
