class Squares (private val num: Int){

    fun squareOfSum (): Int {

        val array = arrayListOf<Int>()
        for (i in 1..num) {

            array.add(i)
        }

        return Math.pow(array.sum().toDouble(), 2.0).toInt()
    }

    fun sumOfSquares(): Int {

        val array = arrayListOf<Int>()
        for (i in 1..num) {

            array.add(i)
        }

        return array.map { n: Int -> n * n }.sum()
    }

    fun difference (): Int = squareOfSum() - sumOfSquares()
}

fun main (args: Array<String>) {

    println(Squares(5).squareOfSum())
    println(Squares(5).sumOfSquares())
    println(Squares(5).difference())
}