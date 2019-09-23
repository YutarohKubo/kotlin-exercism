import kotlin.RuntimeException

enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber < 1) throw RuntimeException()

    val factors = (1 until naturalNumber).filter { naturalNumber % it == 0 }
    return when {
        factors.sum() == naturalNumber -> Classification.PERFECT
        factors.sum() > naturalNumber -> Classification.ABUNDANT
        else -> Classification.DEFICIENT
    }
}

