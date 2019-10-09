package dk.louise

import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.request.receiveParameters
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.*

fun main() {
    // Starts a server at http://localhost:8080
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                // Forms allow you to submit data to the server!
                call.respondHtml {
                    head {
                        title("Forms!")
                    }

                    body {
                        h1 {
                            +"Hello, World"
                        }

                        // On the '/' page we write a form:
                        // We ask the browser to submit the form via 'post' to '/submit'
                        form(method = FormMethod.post, action = "/submit") {
                            label {
                                +"Name"

                                br()

                                // The name property determines where we can find the data.
                                input(name = "yourName", type = InputType.text) {
                                    placeholder = "Placeholder"
                                }

                                br()
                            }
                            label {
                                +"alsoName"

                                br()

                                // The name property determines where we can find the data.
                                input(name = "alsoYourName", type = InputType.text) {
                                    placeholder = "Placeholder"
                                }

                                br()
                            }

                            input(type = InputType.submit) {
                                value = "Submit"
                            }
                        }
                    }
                }
            }

            // This must match what the form says
            post("/submit") {
                // We can read data submitted via form like this:
                val parameters = call.receiveParameters()
                val yourName = parameters["yourName"]!!

                call.respondHtml {
                    head {
                        title("Hello, $yourName")
                    }

                    body {
                        h1 {
                            +"Hello, $yourName"
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}
