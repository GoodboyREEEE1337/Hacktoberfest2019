package dk.louise

fun template(content: () -> Unit) {
    println("Header")
    println("Title")
    content()
    println("Footer")
}

fun main() {
    template() {
        println("Content goes here")
    }
}