import java.lang.IllegalArgumentException

object Prime {

    fun nth(index: Int): Int {
        if (index < 1) {
            throw IllegalArgumentException("There is no zeroth prime.")
        }
        var num = 1
        var i = 0
        while (i != index) {
            num++
            var isPrime = true
            for (n in 1..num) {
                if (num % n == 0 && n != 1 && n != num) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) {
                i++
            }
        }
        return num
    }
}