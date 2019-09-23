class ChangeCalculator(private val changeList: List<Int>) {

    fun computeMostEfficientChange(amountCharge: Int): List<Int> {
        if (amountCharge < 0) {
            throw IllegalArgumentException("Negative totals are not allowed.")
        }
        if (amountCharge > 0 && changeList.min()!! > amountCharge) {
            throw IllegalArgumentException("The total $amountCharge cannot be represented in the given currency.")
        }
        val sortedChangeList = changeList.sorted().reversed()
        val coefficientList = ArrayList<Int>()
        for (coin in sortedChangeList) {
            for (i in 0..amountCharge) {
                if (coin * (i + 1) > amountCharge) {
                    coefficientList.add(i)
                    break
                }
            }
        }
        return changeCalculator(coefficientList, sortedChangeList, amountCharge)
    }

    private fun changeCalculator(coefficientList: List<Int>, changeList: List<Int>, amountCharge: Int): List<Int> {
        val tableRowCoefficientList = (1..coefficientList.size).map { 0 }.toMutableList()
        for (i in 0..coefficientList[coefficientList.size - 1]) {
            if (coefficientList.size < 2) {
                val determinedChange = determineChange(tableRowCoefficientList, changeList)
                if (determinedChange.sum() == amountCharge) {
                    return determinedChange
                }
                tableRowCoefficientList[tableRowCoefficientList.size - 1]++
                continue
            }
            tableRowCoefficientList[tableRowCoefficientList.size - 2] = 0
            for (j in 0..coefficientList[coefficientList.size - 2]) {
                if (coefficientList.size < 3) {
                    val determinedChange = determineChange(tableRowCoefficientList, changeList)
                    if (determinedChange.sum() == amountCharge) {
                        return determinedChange
                    }
                    tableRowCoefficientList[tableRowCoefficientList.size - 2]++
                    continue
                }
                tableRowCoefficientList[tableRowCoefficientList.size - 3] = 0
                for (k in 0..coefficientList[coefficientList.size - 3]) {
                    if (coefficientList.size < 4) {
                        val determinedChange = determineChange(tableRowCoefficientList, changeList)
                        if (determinedChange.sum() == amountCharge) {
                            return determinedChange
                        }
                        tableRowCoefficientList[tableRowCoefficientList.size - 3]++
                        continue
                    }
                    tableRowCoefficientList[tableRowCoefficientList.size - 4] = 0
                    for (l in 0..coefficientList[coefficientList.size - 4]) {
                        if (coefficientList.size < 5) {
                            val determinedChange = determineChange(tableRowCoefficientList, changeList)
                            if (determinedChange.sum() == amountCharge) {
                                return determinedChange
                            }
                            tableRowCoefficientList[tableRowCoefficientList.size - 4]++
                            continue
                        }
                        tableRowCoefficientList[tableRowCoefficientList.size - 5] = 0
                        for (m in 0..coefficientList[coefficientList.size - 5]) {
                            if (coefficientList.size < 6) {
                                val determinedChange = determineChange(tableRowCoefficientList, changeList)
                                if (determinedChange.sum() == amountCharge) {
                                    return determinedChange
                                }
                                tableRowCoefficientList[tableRowCoefficientList.size - 5]++
                                continue
                            }
                            tableRowCoefficientList[tableRowCoefficientList.size - 6] = 0
                            for (n in 0..coefficientList[coefficientList.size - 6]) {
                                if (coefficientList.size < 7) {
                                    val determinedChange = determineChange(tableRowCoefficientList, changeList)
                                    if (determinedChange.sum() == amountCharge) {
                                        return determinedChange
                                    }
                                    tableRowCoefficientList[tableRowCoefficientList.size - 6]++
                                    continue
                                }
                                tableRowCoefficientList[tableRowCoefficientList.size - 7] = 0
                                for (o in 0..coefficientList[coefficientList.size - 7]) {
                                    if (coefficientList.size < 8) {
                                        val determinedChange = determineChange(tableRowCoefficientList, changeList)
                                        if (determinedChange.sum() == amountCharge) {
                                            return determinedChange
                                        }
                                        tableRowCoefficientList[tableRowCoefficientList.size - 7]++
                                        continue
                                    }
                                    tableRowCoefficientList[tableRowCoefficientList.size - 8] = 0
                                    for (p in 0..coefficientList[coefficientList.size - 8]) {
                                        if (coefficientList.size < 9) {
                                            val determinedChange = determineChange(tableRowCoefficientList, changeList)
                                            if (determinedChange.sum() == amountCharge) {
                                                return determinedChange
                                            }
                                            tableRowCoefficientList[tableRowCoefficientList.size - 8]++
                                            continue
                                        }
                                        tableRowCoefficientList[tableRowCoefficientList.size - 8]++
                                    }
                                    tableRowCoefficientList[tableRowCoefficientList.size - 7]++
                                }
                                tableRowCoefficientList[tableRowCoefficientList.size - 6]++
                            }
                            tableRowCoefficientList[tableRowCoefficientList.size - 5]++
                        }
                        tableRowCoefficientList[tableRowCoefficientList.size - 4]++
                    }
                    tableRowCoefficientList[tableRowCoefficientList.size - 3]++
                }
                tableRowCoefficientList[tableRowCoefficientList.size - 2]++
            }
            tableRowCoefficientList[tableRowCoefficientList.size - 1]++
        }

        throw IllegalArgumentException("The total $amountCharge cannot be represented in the given currency.")
    }

    private fun determineChange(coefficientList: List<Int>, changeList: List<Int>): List<Int> {
        val tmpList = ArrayList<List<Int>>()
        for (i in 0 until coefficientList.size) {
            if (coefficientList[i] > 0) tmpList.add((1..coefficientList[i]).map { changeList[i] })
        }

        println(tmpList.flatten())
        return tmpList.flatten().reversed()
    }

}
