
class Year (year: Int){

	val isLeap = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
}


fun main (args: Array<String>) {

	println(Year(2100).isLeap)
}