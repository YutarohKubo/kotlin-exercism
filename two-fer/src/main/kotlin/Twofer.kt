

fun twofer (name: String = "you"): String = "One for $name, one for me."


fun main (args: Array<String>) {

	while (true) {

		println(">input your name")

		val yourName = readLine()

		if (yourName.equals("break")) return

		println(twofer("$yourName"))

	}
}