package dk.louise

import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.http.content.files
import io.ktor.http.content.static
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.*

fun HTML.myTemplate(pageTitle: String, body: DIV.() -> Unit) {
    head {
        meta(charset = "utf-8")
        title(pageTitle)

        link(rel = "stylesheet", href = "/assets/style.css", type = "text/css")
        link(href = "https://fonts.googleapis.com/css?family=Roboto", rel = "stylesheet", type = "text/css")
    }

    body {
        div(classes = "menu flex-container") {
            a(href = "/") {
                img(src = "/assets/tendie-logo.png", alt = "A delicious tendie")
            }

            a(href = "/#Goodboy-food") {
                +"Proper foods for a goodboy"
            }

            a(href = "/#Anime") {
                +"Anime"
            }

            a(href = "/#Memes") {
                +"Memes"
            }

            a(href = "/#The-war") {
                +"The Great War on Chads"
            }

            a(href = "/Gallery") {
                +"Gallery"
            }

            form(method = FormMethod.get, action = "./") {
                label {
                    span(classes = "login") { +"Login:" }
                    input(type = InputType.text, name = "Username") {
                        placeholder = "Username"
                    }
                    input(type = InputType.password, name = "Password") {
                        placeholder = "Password"
                    }
                    input(type = InputType.submit) {
                        value = "Submit!"
                    }
                }
            }
        }

        div(classes = "main-content with-menu") {
            div(classes = "inner-content") {
                body()
            }
        }
    }
}

fun main() {
    // Starts a server at http://localhost:8080
    embeddedServer(Netty, port = 8080) {
        routing {
            static("/assets") {
                files("assets")
            }

            get("/testPage") {
                call.respondHtml {
                    myTemplate("Testing") {
                        h1 {
                            +"Hello!"
                        }
                    }
                }
            }

            get("/") {
                // You can generate HTML via Kotlin with functions which look like normal HTML
                call.respondHtml {
                    myTemplate("Goodboys only! No normies allowed") {
                        div {
                            h1(classes = "header first-header") {
                                +"Welcome m'goodboys to the land of tendie-wendies and heavenly dewie"
                            }
                            h2(classes = "header") {
                                +"I must stress that because this is a safe space for goodboys and pretty princesses alike, absolutely NO Chads and Stacies are allowed!"
                            }

                            p {
                                +"Below, you will find all sorts of good fun including, but not limited to, "
                                strong {
                                    +"proper foods for a goodboy, anime, memes, The Great War on Chads and a "
                                    a("/Gallery", target = "_blank") {
                                        title = "Go here for some healthy looking boys, tendies, Dewie and more!"
                                        +"gallery"
                                    }
                                    +" of healthy boys."
                                }
                            }
                        }

                        hr(classes = "line")

                        div {
                            h2(classes = "header") {
                                id = "Goodboy-food"
                                +"Proper foods for a goodboy"
                            }
                            img(alt = "Some delicious tendies with hunny mussy.", classes = "media") {
                                src =
                                    "https://lh5.googleusercontent.com/-TAroz6IVZBs/U2m7GT3iJnI/AAAAAAAEhWk/hoIswkbD2hE/s800/crunchy-chicken-tenders-56.jpg"
                            }
                            p {
                                +"This is a short list of food and drinks that are considered healthy for maintaining a goodboy frame"
                            }
                            ul(classes = "dewie-list flex-list") {
                                li { +"Tendies" }
                                li { +"Hunny mussy - the superior condiment" }
                                li { +"Doritos" }
                                li { +"Water (water is ok as ice in dewie)" }
                            }
                            a(href = "/GBFoods", target = "_blank", classes = "link-button") {
                                title = "Also contains info on which foods are unfit for goodboys"
                                +"Click here for further info on foods appropriate for goodboy consumption"
                            }
                            p {
                                +"This is a list of foods that should be avoided at all costs, as they will lead to malnourishment"
                            }
                            ul(classes = "neckbeard-list flex-list") {
                                li { +"Diet dewie" }
                                li { +"All Chad sauces (such as ketchup, bbq and ranch EW!)" }
                                li { +"VEGETALS REEEEEE !!!" }
                            }
                            h3 {
                                +"This is what a healthy goodboy should look like. No malnourishment, only a mighty healthy goodboy frame!"
                            }
                            img(
                                classes = "media",
                                alt = "The goodboy in this picture showcases the ideal frame for any goodboy or pretty princess!"
                            ) {
                                src = "https://i.redd.it/7s1uea3onin01.jpg"
                            }
                        }
                        hr(classes = "line")
                        div {
                            h2(classes = "header") {
                                id = "Anime"
                                +"Anime"
                            }
                            p {
                                +"Every goodboy with respect for himself is an avid anime-watcher. Here is a couple of suggestions for great animes!"
                            }
                            ol(classes = "ordered-list") {
                                li { +"Sailor Moon" }
                                li { +"One Piece" }
                                li { +"Naruto" }
                                li { +"Dragon Ball" }
                                li { +"Love live! School Idol project" }
                                li { +"Sword Art Online" }
                                li { +"Yuri!!! On Ice" }
                                li { +"Attack On Titan" }
                                li { +"Bleach" }
                                li { +"Cowboy Bebop" }
                            }
                            img(classes = "media", alt = "Cute anime girl") {
                                src =
                                    "https://steamusercontent-a.akamaihd.net/ugc/313369601189482705/97B6211EFF5BFC89C624252C78FC5A0D4958E840/"
                            }
                            p {
                                +"Hentai viewing is also allowed, although it must be kept a secret form bitch mummy and Chaddy daddy."
                            }
                        }
                        hr(classes = "line")
                        div {
                            h2(classes = "header") {
                                id = "Memes"
                                +"Memes"
                            }
                            p {
                                +"Except this video is not a meme. It is very serious."
                            }

                            video(classes = "media") {
                                src = "/assets/normiesREEEEEE.mp4"
                                controls = true
                                +"Video not supported"
                            }

                            p {
                                +"All jokes aside... The whole internet seems to treat us goodboys as living memes. We do not like being treated this way, but for now we aknowledge that it is a fight we cannot win in the forseeable future."
                            }
                            p {
                                +"Therefore we just ignore these normies in our everyday lives."
                            }
                            p {
                                +"Some of us are, however, also dank memesters ourselves as illustrated by the memes on r/dankmemes on Reddit."
                            }
                            a(
                                href = "https://www.reddit.com/r/dankmemes/",
                                target = "_blank",
                                classes = "link-button"
                            ) {
                                title = "Still no normies allowed!"
                                +"Go here for the dankest memes in existance"
                            }
                            br {}
                            a(href = "https://www.reddit.com/r/Tendies/", target = "_blank", classes = "link-button") {
                                title = "- REEEEESTRICTED - For goodboys only!"
                                +"Also, here is a safe space on reddit for us good little boys"
                            }
                            p {
                                +"Below is an example of a crude meme that makes fun of our luxurious goodboy lifestyle. REEEEE."
                            }
                            img(classes = "media", alt = "MFW the cook gets the tendies just right") {
                                src = "https://pics.me.me/when-the-chef-gets-the-tendies-just-right-5619229.png"
                            }
                            img(classes = "media", alt = "A goodboy with his uncle(?)") {
                                src = "https://i.redd.it/o43l91t5tlp11.jpg"
                            }
                        }
                        hr(classes = "line")
                        div {
                            h2(classes = "header") {
                                id = "The-war"
                                +"The Great War on Chads"
                            }
                            p {
                                +"As you probably know the relationship between Chads and goodboys is in a very poor state."
                            }
                            p {
                                +"It is as if the Chads have dedicated their lives to annoy the good little boys"
                            }
                            p {
                                +"Here is a list of characteristics that can help "
                                em { +"you" }
                                +"spot a Chad in the wild:"
                            }
                            ol(classes = "ordered-list") {
                                li { +"He is into sports and exercising." }
                                li { +"He likes condiments such as ketchup, barbecue sauce and ranch dressing" }
                                li { +"He would like you to eat vegetals and exercise more in order for you to become more malnourished" }
                                li { +"He shows little to no respect for your hobbies like anime, vidya gaemz, your waifu and Magic cards" }
                                li { +"He tries to influence your bitch mommy to stop cooking tendies for you" }
                            }
                            p {
                                +"All in all, Chads should be treated as your worst enemy. Therefore you ought to prepare defensive measures to counteract his vicious attempts on your life."
                            }
                            p {
                                +"These countermeasures can include: piss jugs, your mighty samurai sword, poop smearings, autistic screeching etc."
                            }
                            p {
                                +"Defensive measures like these can force the Chad to step down and leave you alone, as you so desperately desire."
                            }
                            p {
                                +"Click on the picture below if you just "
                                em { +"love " }
                                +"barbecue sauce on your tendies."
                            }
                            a(href = "/NormieAlert") {
                                img(classes = "media", alt = "Delicious tendies with some yummy barbecue sauce") {
                                    src = "http://cullyskitchen.com/wp-content/uploads/2011/09/cmain.jpg"
                                }
                            }
                        }
                    }
                }
            }

            get("/Gallery") {
                call.respondHtml {
                    myTemplate("The Goodboy Gallery") {
                        h1(classes = "header first-header") {
                            +"This is the goodboy gallery"
                        }
                        img(classes = "media", alt = "A goodboy and his bitch mummy") {
                            src =
                                "https://preview.redd.it/i09rw72u1zq01.jpg?width=960&crop=smart&s=2a2bb09f77cf92b5ce06be22f6814c3ec088980a"
                        }
                        img(classes = "media", alt = "A goodboy aggravated by the insufferable Chads") {
                            src = "https://i.redd.it/ljho9u4pdnh11.jpg"
                        }
                        img(classes = "media", alt = "A goodboy showing off his Dewie collection") {
                            src = "https://pbs.twimg.com/media/C2dMmsyXgAEDqf7.jpg"
                        }
                        img(
                            classes = "media",
                            alt = "A goodboy being spotted on the rare occasion of being outside his lair"
                        ) {
                            src = "https://i.redd.it/qtzscvijp1411.jpg"
                        }
                    }
                }
            }

            get("/GBFoods") {
                call.respondHtml {
                    myTemplate("Goodboy Foods") {
                        h1(classes = "header first-header") {
                            +"This pages contains an assessment of different foods and whether they are appropriate for Goodboy consumption"
                        }
                        table {
                            thead {
                                tr {
                                    th(scope = ThScope.col) { +"Food type" }
                                    th(scope = ThScope.col) { +"Is it appropriate for consumption" }
                                    th(scope = ThScope.col) { +"Explanation" }
                                }
                            }
                            tbody {
                                tr {
                                    td {
                                        colSpan = "1"
                                        rowSpan = "1"
                                        +"Tendies"
                                    }
                                    td {
                                        +"Yes"
                                    }
                                    td {
                                        +"Tendies are the foundation of a healthy diet. Watch out for the spicy variety though!"
                                    }
                                }
                                tr {
                                    td {
                                        colSpan = "1"
                                        rowSpan = "1"
                                        +"Dewie"
                                    }
                                    td {
                                        +"Yes"
                                    }
                                    td {
                                        +"This is the nectar of pure deliciousness. Be sure to avoid diet Dewie at all costs, as it is a beverage as nasty as they come"
                                    }
                                }
                                tr {
                                    td {
                                        colSpan = "1"
                                        rowSpan = "1"
                                        +"Vegetals"
                                    }
                                    td {
                                        +"No"
                                    }
                                    td {
                                        +"All vegetals ("
                                        strong {
                                            +"NO exceptions"
                                        }
                                        +") are to be avoided. They can malnourish even the healthiest of boys in an instant!"
                                    }
                                }
                            }
                            tr {
                                td {
                                    colSpan = "1"
                                    rowSpan = "1"
                                    +"Nuggies"
                                }
                                td {
                                    +"No"
                                }
                                td {
                                    +"These are the cheap knock-off of tendies. Only Chads and normies will eat these. REEEEEEEE."
                                }
                            }
                            tr {
                                td {
                                    colSpan = "1"
                                    rowSpan = "1"
                                    +"Hunny mussie"
                                }
                                td {
                                    +"Yes"
                                }
                                td {
                                    +"The condiment to rule them all. Hunny mussy and tendies go together like neckbeards and bodypillows."
                                }
                            }
                            tr {
                                td {
                                    +"Potater frysies"
                                }
                                td {
                                    +"Yes"
                                }
                                td {
                                    +"Frysies are a great companion for tendies. Should not be eaten on its own though."
                                }
                            }
                            tr {
                                td {
                                    +"Water"
                                }
                                td {
                                    +"(Yes)"
                                }
                                td {
                                    +"It depends. If it is water alone: no. If it is in Dewie as ice, then it is okay. It makes Dewie better that way because it becomes cold."
                                }
                            }
                            tr {
                                td {
                                    +"Mtn Lightning"
                                }
                                td {
                                    +"No"
                                }
                                td {
                                    +"This is a huge NO. Any knock-offs like Mtn Lightning cannot beat the potent powers of REAL Mountain Dewie!"
                                }
                            }
                            tr {
                                td {
                                    +"Sweet Potater Frysies"
                                }
                                td {
                                    +"No"
                                }
                                td {
                                    +"They are the evil twins of frysies in disguise. Avoid them bc they are in reality VEGETALS! REEEEEEE."
                                }
                            }
                            tr {
                                td {
                                    +"Chad sauce"
                                }
                                td {
                                    +"No"
                                }
                                td {
                                    +"Includes all the yucky sauces Chads usually eat: ketchup, bbq and ranch are the most common."
                                }
                            }
                        }
                    }
                }
            }

            get("/NormieAlert") {
                call.respondHtml {
                    head() {
                        meta(charset = "utf-8")
                        title("CHAD DETECTED! - READY THE PISS JUGS M'GOODBOYS")
                        link(rel = "stylesheet", href = "/assets/style.css", type = "text/css")
                        link(
                            href = "https://fonts.googleapis.com/css?family=Roboto",
                            rel = "stylesheet",
                            type = "text/css"
                        )
                    }

                    body(classes = "alert") {
                        div(classes = "main-content") {
                            br
                            h1(classes = "header bordered warning") {
                                strong {
                                    +"NO CHADS OR STACIES ALLOWED. GET OUT, NORMIES! REEEEEEEEEEEEEEEEEEEEEEE."
                                }
                            }
                            h2(classes = "header bordered warning") {
                                +"BTW barbecue sauce on tendies is fucking heresy REEEEEEEEEEEE!!!   "
                            }
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}