enum class Relationship {

    EQUAL, SUBLIST, SUPERLIST, UNEQUAL

}

fun List<Any>.relationshipTo (comparedList: List<Any>): Relationship {
    val divideList: MutableList<List<Any>> = mutableListOf()
    when {
        comparedList.size > this.size -> {
            for (i in 0..(comparedList.size - this.size)){
                val tmpList = mutableListOf<Any>()
                for (j in i until (i + this.size)) {
                    tmpList.add(comparedList[j])
                }
                divideList.add(tmpList)
            }
            if (divideList.contains(this)){
                return Relationship.SUBLIST
            }
        }
        this.size > comparedList.size -> {
            for (i in 0..(this.size - comparedList.size)){
                val tmpList = mutableListOf<Any>()
                for (j in i until (i + comparedList.size)) {
                    tmpList.add(this[j])
                }
                divideList.add(tmpList)
            }
            if (divideList.contains(comparedList)){
                return Relationship.SUPERLIST
            }
        }
        this.size == comparedList.size -> {
            divideList.add(this)
            if (divideList.contains(comparedList)) {
                return Relationship.EQUAL
            }
        }
    }
    return Relationship.UNEQUAL
}
