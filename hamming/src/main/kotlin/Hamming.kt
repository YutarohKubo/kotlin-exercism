class Hamming {
	companion object {

		/**
		 * 文字列のハミング距離を計算する
		 *
		 * @param dna1 比較する文字列
		 * @param dna2 比較される文字列
		 * @return 2つの文字列のハミング距離
		 */
		fun compute (dna1: String, dna2: String): Int {

			if (dna1.length != dna2.length) {

				throw IllegalArgumentException("left and right strands must be of equal length.")
			}

			var indexDna2 = 0
			var distance = 0

			for (c in dna1) {

				if (dna2[indexDna2] != c) {

					distance++
				}

				indexDna2++
			}

			return distance
		}
	}
}

fun main (args: Array<String>) {

	while (true) {

		println(">input your dna1")

		val dna1 = readLine()

		if (dna1.equals("break")) return

		println(">input your dna2")

		val dna2 = readLine()

		if (dna2.equals("break")) return

		println(Hamming.compute("$dna1", "$dna2"))

	}

}

