import kotlin.RuntimeException

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {

    if (naturalNumber < 1) {

        throw RuntimeException()
    }

    val factors = arrayListOf<Int>()

    for (i in 1 until naturalNumber) {

        if (naturalNumber%i == 0) {

            factors.add(i)
        }
    }

    return when {

        factors.sum() == naturalNumber -> Classification.PERFECT
        factors.sum() > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}
