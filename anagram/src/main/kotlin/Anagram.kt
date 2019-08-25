class Anagram(private val anagramStr: String) {

    fun match (wordList: List<String>)
            = if (anagramStr.any { it.isLowerCase() })
        wordList.filter { checkAnagram(it) }.toSet()
    else
        emptySet()

    private fun checkAnagram (word: String)
            = word.toLowerCase().toList().sorted().joinToString("")
            .equals(anagramStr.toLowerCase().toList().sorted().joinToString(""))

}