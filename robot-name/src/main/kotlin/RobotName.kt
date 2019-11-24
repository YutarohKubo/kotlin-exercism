import kotlin.random.Random

class Robot {

    companion object {
        const val ASCII_A = 65
        const val ASCII_Z = 90

         val nameList = mutableListOf<String>()
    }

    lateinit var name: String

    fun reset() {
        createName()
    }

    init {
        createName()
    }

    private fun createName () {
        var tmpName = ""
        for (i in 0..1) {
            tmpName += (Random.nextInt(ASCII_Z - ASCII_A) + ASCII_A).toChar()
        }
        tmpName += String.format("%03d", Random.nextInt(1000))
        if (nameList.contains(tmpName)) {
            rename(tmpName)
        } else {
            name = tmpName
            nameList.add(name)
        }
    }

    private fun rename (duplicatedName: String) {
        var newName = ""
        val firstLetter = duplicatedName[0]
        val secondLetter = duplicatedName[1]
        val numLetter = duplicatedName.substring(2, 5)
        newName = when {
            Integer.parseInt(numLetter) < 999 -> {
                val newNumLetter = Integer.parseInt(numLetter) + 1
                firstLetter.toString() + secondLetter.toString() + String.format("%03d", newNumLetter)
            }
            secondLetter != 'Z' -> {
                val newSecondLetter = secondLetter + 1
                val newNumLetter = 0
                firstLetter.toString() + newSecondLetter.toString() + String.format("%03d", newNumLetter)
            }
            else -> {
                val newFirstLetter = firstLetter + 1
                val newSecondLetter = 'A'
                val newNumLetter = 0
                newFirstLetter.toString() + newSecondLetter.toString() + String.format("%03d", newNumLetter)
            }
        }
        if (nameList.contains(newName)) {
            rename(newName)
        } else {
            name = newName
            nameList.add(name)
        }
    }

}

