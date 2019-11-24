class ChangeCalculator(private var changeList: List<Int>) {

    private val outputList = mutableListOf<List<Int>>()
    private var startTime: Long = 0
    companion object {
        private const val TIME_OUT_VALUE = 5000
    }

    fun computeMostEfficientChange(amountCharge: Int): List<Int>? {
        require(amountCharge >= 0){ "Negative totals are not allowed." }
        if (amountCharge == 0) {
            return emptyList()
        }
        changeList = changeList.filter { it <= amountCharge }.sorted().reversed()
        require(changeList != emptyList<Int>()){ "The total $amountCharge cannot be represented in the given currency." }
        startTime = System.currentTimeMillis()
        for (i in 0 until changeList.size) {
            calc(remainCharge = amountCharge, index = i)
        }
        require(outputList != emptyList<Int>()){ "The total $amountCharge cannot be represented in the given currency." }
        return outputList.minBy { it.size }?.reversed()
    }

    /**
     * changeListの要素の組み合わせで、和が丁度amountChargeとなるものをoutputListに詰めていく。
     *
     * @param coinList changeListの要素を検査していく過程で、和が0またはそれ以下になるまで、検査した要素を詰めていくリスト
     * @param remainCharge remainChargeが0か0以下になるまで、chargeListの検査された要素をremainChargeから引き、coinListを作成する
     * @param index changeListの要素を検査していくためのインデックス
     */
    private fun calc (coinList: MutableList<Int> = mutableListOf(), remainCharge: Int, index: Int = 0) {
        //タイムアウト5秒
        if (System.currentTimeMillis() - startTime > TIME_OUT_VALUE) {
            return
        }

        val newRemainCharge = remainCharge - changeList[index]
        val cList = if (coinList == emptyList<Int>()) mutableListOf() else coinList

        if (newRemainCharge == 0) {
            val cListClone = cList.map { it }.toMutableList()
            cListClone.add(changeList[index])
            outputList.add(cListClone)
            return
        }

        if (newRemainCharge < 0) {
            return
        }

        val cListClone = cList.map { it }.toMutableList()
        cListClone.add(changeList[index])
        for (i in index until changeList.size) {
            calc(cListClone, newRemainCharge, i)
        }
    }
}
