object MatchingBrackets {

    private val listBra = listOf('[', '{', '(')
    private val listKet = listOf(']', '}', ')')

    fun isValid(input: String): Boolean {
        //入力文字列に対して、始まり括弧と閉じ括弧のみを抽出
        val inputToChar = input.toCharArray().filter { it in (listBra + listKet) }
        for (i in listBra.indices) {
            //各括弧ごとに、始まり括弧の数と閉じ括弧の数が合わなければ、不正
            if (inputToChar.filter { it == listBra[i] }.size != inputToChar.filter { it == listKet[i] }.size){
                return false
            }
        }
        //出現した始まり括弧を記憶するスタック。同類の閉じ括弧が出現したら、popする。
        val memoryBra = mutableListOf<Char>()
        for (ch in inputToChar) {
            if (ch in listBra) {
                //始まり括弧をスタックに積む
                memoryBra.add(ch)
                continue
            }
            if (ch in listKet) {
                //閉じ括弧から始まった場合、不正
                if (memoryBra.size == 0) {
                    return false
                }
                val indexKet = listKet.indexOf(ch)
                //同類の閉じ括弧が、スタックの一番上に積まれていた場合、スタックに対してpopし、次の入力括弧文字を見る
                if (memoryBra[memoryBra.lastIndex] == listBra[indexKet]) {
                    memoryBra.removeAt(memoryBra.lastIndex)
                }
                //異なる種類の閉じ括弧が、スタックの一番上に積まれていた場合、不正
                else {
                    return false
                }
            }
        }
        return true
    }

}