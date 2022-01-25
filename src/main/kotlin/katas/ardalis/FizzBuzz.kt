package katas.ardalis

object FizzBuzz {
    fun fizzBuzz(num: Int): String {
        if (num % 5 == 0 && num % 3 == 0) return "FizzBuzz"
        if (num % 3 == 0) return "Fizz"
        if (num % 5 == 0) return "Buzz"

        return num.toString()
    }
}