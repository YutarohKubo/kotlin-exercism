
class Pangram{

	companion object {
		/**
		 * pangramかどうかの判定を行う
		 *
		 * @args sentence pangram検査対象の文字列
		 * @return 対象文字列がpangramのときtrue, そうではないときfalse
		 */
		fun isPangram (sentence: String): Boolean {

			//アルファベットのセット作成
			val alphabetSet = hashSetOf<Char>()
			for (c in 'a'..'z') {

				alphabetSet.add(c)
			}

			//pangramのチェック
			for (c in sentence.toLowerCase()) {

				alphabetSet.remove(c)
			}

			return (alphabetSet.size == 0)
		}
	}
}


fun main (args: Array<String>) {

	println(Pangram.isPangram("The quick brown fox jumps over the lazy dog."))

}