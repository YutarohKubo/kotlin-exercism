class Luhn {
    companion object {
        fun isValid (checkedStr: String): Boolean {
            val noSpaceStr = checkedStr.replace(" ", "")
            if (!noSpaceStr.matches("[0-9]{2,}".toRegex())) {
                return false
            }

            val resultNumberList = ArrayList<Int>()
            noSpaceStr.reversed().forEachIndexed { index, c -> resultNumberList.add(if (index % 2 == 1) changeToDoublingNum(c) else c.toInt()-48) }

            return resultNumberList.sum() % 10 == 0
        }

        private fun changeToDoublingNum (c: Char) = if ((c.toInt() - 48) * 2 > 9) (c.toInt() - 48) * 2 - 9 else (c.toInt() - 48) * 2

    }
}
