class Flattener {
    companion object {
        fun flatten (inputList: List<Any?>): List<Any?> {
            val outputList = mutableListOf<Any?>()
            listMaker(inputList, outputList)
            return outputList
        }

        /**
         * first parameter に入力されたリストをフラットにし、second parameter に与えられるリストに後ろから追加する。
         *
         * @param inputList フラットにする対象のリスト
         * @param outputList フラットになった結果を格納するリスト。(空以外のリストが与えられた場合は、結果のリストを末尾から追加する)
         * @param index 対象のリスト内の処理を行う最初の要素のindex
         */
        private fun listMaker (inputList: List<Any?>, outputList: MutableList<Any?>, index: Int = 0) {
            val elem = inputList[index]
            //検査するリストの要素が、リストならば、そのリスト内の要素を頭から検査する
            //検査するリストの要素が、リストではなくさらにNullでなければ、FlattenArrayとして作成されるListに追加する
            when {
                elem is List<Any?> -> listMaker(elem, outputList, 0)
                elem != null -> outputList.add(elem)
                else -> { }//リストの要素がnullならば、何もしない
            }

            val nextIndex = index + 1
            //今検査した要素がリストの最後尾の要素ならば、return
            if (inputList.size == nextIndex) {
                return
            }

            //最後尾の要素でなければ、次の要素を検査する
            listMaker(inputList, outputList, nextIndex)
        }
    }
}
