class SumOfMultiples {

    companion object {

        fun sum (multiNumSet: Set<Int>, naturalNum: Int): Int {

            val multiples = hashSetOf<Int>()

            for (i in multiNumSet) {

                for (j in 1 until naturalNum) {

                    if (j % i == 0) {

                        multiples.add(j)
                    }
                }
            }

            return multiples.sum()
        }
    }
}