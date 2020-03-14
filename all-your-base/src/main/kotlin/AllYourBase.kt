import kotlin.math.pow

class BaseConverter(private val baseNumber: Int, private val value: IntArray) {

    init {
        if (baseNumber < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        }
        if (value.size >= 2 && value[0] == 0) {
            throw IllegalArgumentException("Digits may not contain leading zeros.")
        }
        if (value.isEmpty()) {
            throw IllegalArgumentException("You must supply at least one digit.")
        }
        if (!value.all { it < baseNumber }) {
            throw IllegalArgumentException("All digits must be strictly less than the base.")
        }
        if (!value.all { it >= 0 }) {
            throw IllegalArgumentException("Digits may not be negative.")
        }
    }

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        }
        var convertedValueBase10 = 0.0
        value.forEachIndexed { index, v ->
            convertedValueBase10 += v * baseNumber.toDouble().pow((value.size - 1 - index).toDouble())
        }

        var diffedValue = convertedValueBase10.toInt()
        val newValueList = mutableListOf<Int>()
        while (diffedValue >= newBase) {
            newValueList.add(diffedValue % newBase)
            diffedValue /= newBase
        }
        newValueList.add(diffedValue % newBase)
        newValueList.reverse()

        return newValueList.toIntArray()
    }
}
