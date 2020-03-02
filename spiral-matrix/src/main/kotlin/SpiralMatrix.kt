object SpiralMatrix {

    enum class AssignType{
        RIGHT,DOWN,LEFT,UP
    }

    fun ofSize(size: Int): Array<IntArray> {
        val sMatrix = Array<IntArray>(size) {
            IntArray(size) { 0 }
        }

        var i = 0
        var j = 0
        var num = 1
        var type = AssignType.RIGHT
        for (iter in 1..size*size) {
            sMatrix[i][j] = num
            when (type) {
                AssignType.RIGHT -> {
                    if (j == size - 1 || sMatrix[i][j + 1] != 0) {
                        type = AssignType.DOWN
                        i++
                    } else {
                        j++
                    }
                }
                AssignType.DOWN -> {
                    if (i == size - 1 || sMatrix[i + 1][j] != 0) {
                        type = AssignType.LEFT
                        j--
                    } else {
                        i++
                    }
                }
                AssignType.LEFT -> {
                    if (j == 0 || sMatrix[i][j - 1] != 0) {
                        type = AssignType.UP
                        i--
                    } else {
                        j--
                    }
                }
                AssignType.UP -> {
                    if (i == 0 || sMatrix[i - 1][j] != 0) {
                        type = AssignType.RIGHT
                        j++
                    } else {
                        i--
                    }
                }
            }
            num++
        }

        return sMatrix
    }
}
