object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()
        for (i in 0 until rows) {
            val listOfRow = mutableListOf<Int>()
            if (i == 0) {
                listOfRow.add(1)
                resultList.add(listOfRow)
                continue
            }
            for (j in 0..i) {
                if (j == 0) {
                    listOfRow.add(resultList[i-1][j])
                    continue
                }
                if (j == i) {
                    listOfRow.add(resultList[i-1][j-1])
                    resultList.add(listOfRow)
                    continue
                }
                listOfRow.add(resultList[i-1][j-1] + resultList[i-1][j])
            }
        }
        return resultList
    }
}
