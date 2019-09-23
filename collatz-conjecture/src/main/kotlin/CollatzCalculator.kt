import java.lang.IllegalArgumentException

class CollatzCalculator {
    companion object {
        private var currentStep = 0

        fun computeStepCount (positiveNum: Int): Int {
            if (positiveNum <= 0) throw IllegalArgumentException("Only natural numbers are allowed")
            if (positiveNum == 1) {
                val resultStep = currentStep
                currentStep = 0
                return resultStep
            }

            currentStep++
            return if (positiveNum % 2 == 0) {
                computeStepCount(positiveNum/2)
            } else {
                computeStepCount(positiveNum * 3 + 1)
            }
        }
    }
}
