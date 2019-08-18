class Anagram(private val anagramStr: String) {

    fun match(wordList: List<String>): Set<String> {
        val outputSet = hashSetOf<String>()

        outFor@ for (str in wordList) {
            val chList = arrayListOf<Char>()
            for ((index, c) in anagramStr.toCharArray().withIndex()) {
                if (index != 0 && c.isUpperCase()) {
                    continue@outFor
                }
                chList.add(c.toLowerCase())
            }

            for (c in str.toLowerCase()) {
                if (!chList.contains(c)) {
                    continue@outFor
                }
                chList.removeAt(chList.indexOf(c))
            }

            if (chList.size == 0) {
                outputSet.add(str)
            }
        }

        return outputSet
    }
}