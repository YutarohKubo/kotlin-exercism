import java.lang.StringBuilder

class Raindrops {

    companion object {

        fun convert(inputNum: Int): String {

            val builder = StringBuilder()

            if (inputNum % 3 != 0 && inputNum % 5 != 0 && inputNum % 7 != 0) {

                return inputNum.toString()
            }

            if (inputNum % 3 == 0) {

                builder.append("Pling")
            }

            if (inputNum % 5 == 0) {

                builder.append("Plang")
            }

            if (inputNum % 7 == 0) {

                builder.append("Plong")
            }

            return builder.toString()
        }
    }
}