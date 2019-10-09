package dk.louise

import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.*

fun main() {
    // Starts a server at http://localhost:8080
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                // You can generate HTML via Kotlin with functions which look like normal HTML
                call.respondHtml {
                    // Equivalent to:
                    // <head>
                    //   <title>My page!</title>
                    // </head>
                    head {
                        title("My page!")
                    }

                    // Equivalent to:
                    // <body>
                    //   <h1>Hello, World</h1>
                    //   <img src="https://fie.dog/fie2.jpg">
                    // </body>
                    body {
                        h1 {
                            +"Hello, World"
                        }

                        img(src = "https://fie.dog/fie2.jpg")

                        // TODO try and add some more content!
                        h2 {
                            +"Fie er en hund"
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}
