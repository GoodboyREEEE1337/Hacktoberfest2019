package dk.louise

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    // Starts a server at http://localhost:8080
    embeddedServer(Netty, port = 8080) {
        routing {
            // Responds with "Hello, World!" when you go to http://localhost:8080/
            // Your browser will automatically use "get" for most requests.
            get("/") {
                call.respondText("Hello, World!")
            }

            // Responds with "Welcome to my page" when you go to http://localhost:8080/page
            get("/page") {
                call.respondText("Welcome to my page")
            }

            // TODO add a new page
            get("/page/pagepage") {
                call.respondText("Reeeee")
            }
        }
    }.start(wait = true)
}
