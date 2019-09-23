class Series (private val strDigit: String){
    init {
        if (!strDigit.matches("[0-9]*".toRegex())) throw IllegalArgumentException()
    }

    fun getLargestProduct (seriesLength: Int): Int{
        if (strDigit.length < seriesLength || seriesLength < 0) throw IllegalArgumentException()
        if (seriesLength == 0) return 1

        val seriesList = ArrayList<String>()
        for (i in 0..strDigit.length - seriesLength) {
            seriesList.add(strDigit.substring(i until i + seriesLength))
        }

        return seriesList.map { value -> value.toCharArray().fold(1){ result, elem -> result * (elem.toInt() - 48) } }.max()!!
    }
}
