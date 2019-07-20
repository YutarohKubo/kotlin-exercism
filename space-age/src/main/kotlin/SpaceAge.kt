import java.math.BigDecimal

const val EARTH_ORBITAL_SECOND: Double = 31557600.0
const val MERCURY_ORBITAL_SECOND: Double = 0.2408467 * EARTH_ORBITAL_SECOND
const val VENUS_ORBITAL_SECOND: Double = 0.61519726 * EARTH_ORBITAL_SECOND
const val MARS_ORBITAL_SECOND: Double = 1.8808158 * EARTH_ORBITAL_SECOND
const val JUPITER_ORBITAL_SECOND: Double = 11.862615 * EARTH_ORBITAL_SECOND
const val SATURN_ORBITAL_SECOND: Double = 29.447498 * EARTH_ORBITAL_SECOND
const val URANUS_ORBITAL_SECOND: Double = 84.016846 * EARTH_ORBITAL_SECOND
const val NEPTUNE_ORBITAL_SECOND: Double = 164.79132 * EARTH_ORBITAL_SECOND


class SpaceAge (private val second: Long) {

	fun onEarth (): Double {

		return BigDecimal(second.toDouble()/EARTH_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}

	fun onMercury(): Double {

		return BigDecimal(second.toDouble()/MERCURY_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}

	fun onVenus(): Double {
		return BigDecimal(second.toDouble()/VENUS_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}

	fun onMars(): Double {
		return BigDecimal(second.toDouble()/MARS_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}

	fun onJupiter(): Double {
		return BigDecimal(second.toDouble()/JUPITER_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}

	fun onSaturn (): Double {
		return BigDecimal(second.toDouble()/SATURN_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}

	fun onUranus (): Double {
		return BigDecimal(second.toDouble()/URANUS_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}

	fun onNeptune (): Double {
		return BigDecimal(second.toDouble()/NEPTUNE_ORBITAL_SECOND).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
	}
}

fun main (args: Array<String>) {

	val age = SpaceAge(189839836)
	println(age.onVenus())
}