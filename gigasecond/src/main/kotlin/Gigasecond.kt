import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

const val GIGA_SECOND: Long = 1000000000

class Gigasecond{

	val date: LocalDateTime

	constructor(givenSecond: LocalDateTime) {

		this.date = givenSecond.plusSeconds(GIGA_SECOND)
	}

	constructor(givenSecond: LocalDate) {

		this.date = givenSecond.atStartOfDay().plusSeconds(GIGA_SECOND)
	}

	override fun toString(): String = date.format(DateTimeFormatter.ISO_DATE_TIME)
}

fun main (args: Array<String>) {

	val gigasecond = Gigasecond (LocalDate.of(2011, Month.APRIL, 25))
	println(gigasecond)
}