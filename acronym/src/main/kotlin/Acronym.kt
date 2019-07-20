
object Acronym {
    fun generate(phrase: String): String {

        var arrangePhrase = "[^a-zA-Z]".toRegex().replace(phrase, " ")
        arrangePhrase = "\\s{2,}".toRegex().replace(arrangePhrase, " ")

        val letters = arrangePhrase.split(" ")
        val acronymBuilder = StringBuilder()

        for (letter in letters) {

            acronymBuilder.append(letter.substring(0, 1).toUpperCase())
        }

        return "$acronymBuilder"
    }
}


fun main(args: Array<String>) {
    println("${Acronym.generate("Something - I made up from thin air")}")
}