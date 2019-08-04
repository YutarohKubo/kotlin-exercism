
const val MAX_BINARY_LENGTH = 6

object HandshakeCalculator {

    fun calculateHandshake (dec: Int): List<Signal> {

        val array = arrayListOf<Signal>()
        var binary = Integer.toBinaryString(dec)

        if (binary.length <= MAX_BINARY_LENGTH) {

            binary = "0".repeat(MAX_BINARY_LENGTH - binary.length) + binary
        } else {

            throw IllegalArgumentException()
        }

        if (binary.substring(MAX_BINARY_LENGTH - 5, MAX_BINARY_LENGTH - 5 + 1) == "0") {

            if (binary.substring(MAX_BINARY_LENGTH - 1, MAX_BINARY_LENGTH - 1 + 1) == "1") {

                array.add(Signal.WINK)
            }

            if (binary.substring(MAX_BINARY_LENGTH - 2, MAX_BINARY_LENGTH - 2 + 1) == "1") {

                array.add(Signal.DOUBLE_BLINK)
            }

            if (binary.substring(MAX_BINARY_LENGTH - 3, MAX_BINARY_LENGTH - 3 + 1) == "1") {

                array.add(Signal.CLOSE_YOUR_EYES)
            }

            if (binary.substring(MAX_BINARY_LENGTH - 4, MAX_BINARY_LENGTH - 4 + 1) == "1") {

                array.add(Signal.JUMP)
            }
        } else if (binary.substring(MAX_BINARY_LENGTH - 5, MAX_BINARY_LENGTH - 5 + 1) == "1") {

            if (binary.substring(MAX_BINARY_LENGTH - 4, MAX_BINARY_LENGTH - 4 + 1) == "1") {

                array.add(Signal.JUMP)
            }

            if (binary.substring(MAX_BINARY_LENGTH - 3, MAX_BINARY_LENGTH - 3 + 1) == "1") {

                array.add(Signal.CLOSE_YOUR_EYES)
            }

            if (binary.substring(MAX_BINARY_LENGTH - 2, MAX_BINARY_LENGTH - 2 + 1) == "1") {

                array.add(Signal.DOUBLE_BLINK)
            }

            if (binary.substring(MAX_BINARY_LENGTH - 1, MAX_BINARY_LENGTH - 1 + 1) == "1") {

                array.add(Signal.WINK)
            }
        } else {

            throw IllegalArgumentException()
        }

        return array
    }
}

fun main (args: Array<String>) {

    println(HandshakeCalculator.calculateHandshake(19))
}