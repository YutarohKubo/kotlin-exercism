class Atbash {
    companion object {
        fun encode (input: String) = input.filter { ch -> (ch.toInt() in '0'.toInt()..'z'.toInt()) }.toLowerCase().map { ch -> codingProcess(ch) }.joinToString("").chunked(5).joinToString(" ")

        fun decode (input: String) = input.filter { ch -> ch != ' ' }.map { ch -> codingProcess(ch) }.joinToString("")

        private fun codingProcess (char: Char) = if (char in 'A'..'z') ('z'.toInt() - (char.toInt() - 'a'.toInt())).toChar() else char
    }
}

