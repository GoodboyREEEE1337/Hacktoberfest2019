package dk.louise

import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.request.receiveParameters
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.*

// We define a "Comment" to be a [user] and a [message]
data class Comment(
    val user: String,
    val message: String
)

// The system already has some comments:
val comments = arrayListOf(
    Comment("Fie", "Jeg er en hund"),
    Comment("Dan", "Noget med Kotlin")
)

fun main() {
    // Starts a server at http://localhost:8080
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondHtml {
                    head {
                        title("Comments")
                    }

                    body {
                        h1 {
                            +"Your comments"
                        }

                        // We can display all of the comments with a normal for loop
                        for (comment in comments) {
                            div {
                                i { +(comment.user) }
                                +" said: "
                                +(comment.message)
                            }
                        }

                        // On the '/' page we write a form:
                        // We ask the browser to submit the form via 'post' to '/submit'
                        form(method = FormMethod.post, action = "/submit") {
                            style = "margin-top: 30px" // We can even add CSS!

                            label {
                                +"Name"

                                br()

                                // The name property determines where we can find the data.
                                input(name = "yourName", type = InputType.text) {
                                    placeholder = "Louise"
                                }

                                br()
                            }

                            label {
                                +"Comment"
                                br()
                                // The name property determines where we can find the data.
                                input(name = "yourComment", type = InputType.text) {
                                    placeholder = "Awesome stuff!"
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

            // TODO Try and implement a comment system by filling in the method below:
            post("/submit") {
                // We can read data submitted via form like this:
                val parameters = call.receiveParameters()

                val yourName = parameters["yourName"].takeIf { !it.isNullOrBlank() } ?: "Anon"
                val yourComment = parameters["yourComment"] ?: ""

                comments.add(Comment(yourName, yourComment))

                call.respondRedirect("/")
            }
        }
    }.start(wait = true)
}
