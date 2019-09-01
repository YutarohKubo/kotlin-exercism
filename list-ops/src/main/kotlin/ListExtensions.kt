

fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val resultList = arrayListOf<T>()
    resultList.addAll(this)
    resultList.addAll(list)
    return resultList
}

fun <T> List<List<T>>.customConcat(): List<T> {
    val resultList = arrayListOf<T>()
    for (elem in this) {
        resultList.addAll(elem)
    }
    return resultList
}

fun <T> List<T>.customFilter(condition: (T)->Boolean): List<T> {
    val resultList = arrayListOf<T>()
    for (elem in this) {
        if (condition(elem)) {
            resultList.add(elem)
        }
    }
    return resultList
}

val <T> List<T>.customSize: Int
get() {
    var count = 0
    for (elem in this) {
        count++
    }
    return count
}

fun <T, R> List<T>.customMap(transform: (T)->R): List<R> {
    val resultList = arrayListOf<R>()
    for (elem in this) {
        resultList.add(transform(elem))
    }
    return resultList
}

fun <T, R> List<T>.customFoldLeft(initial: R, operation: (R, T) -> R): R {
    var result = initial
    for (elem in this) {
        result = operation(result, elem)
    }
    return result
}

fun <T, R> List<T>.customFoldRight(initial: R, operation: (T, R) -> R): R {
    var result = initial
    for (i in customSize-1 downTo 0) {
        result = operation(this[i], result)
    }
    return result
}

fun <T> List<T>.customReverse(): List<T> {
    val resultList = arrayListOf<T>()
    for (i in customSize - 1 downTo  0) {
        resultList.add(this[i])
    }
    return resultList
}