import java.lang.IllegalArgumentException
import java.lang.StringBuilder

fun transcribeToRna (dna: String): String {

	val builder = StringBuilder()
	for (ch in dna) {

		builder.append(transcribeToRnaChar(ch).toString())
	}

	return builder.toString()
}

fun transcribeToRnaChar(dnaChar: Char): Char = when (dnaChar) {

	'G' -> 'C'
	'C' -> 'G'
	'T' -> 'A'
	'A' -> 'U'
	else -> throw IllegalArgumentException()
}


fun main (args: Array<String>) {

	while (true) {

		println(">input dna")

		val dna = readLine()

		println(transcribeToRna("$dna"))
	}
}
