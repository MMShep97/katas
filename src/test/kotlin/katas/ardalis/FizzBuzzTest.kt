package katas.ardalis

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FizzBuzzTest {

    // given:    1, 2, 3, 4, 5, 6, 7, 8, 9...15...
    // expected: 1, 2, FIZZ, 4, BUZZ, FIZZ, 7, 8, FIZZ...FIZZBUZZ...

    @Test
    fun `should print out numbers when not divisible by 3 OR 5, separated by newlines`() {
        val input = 1
        val actual = FizzBuzzKata.fizzBuzz(input)

        assertEquals(input.toString(), actual)
    }

    @Test
    fun `should output Fizz when divisible by 3`() {
        val actual = FizzBuzzKata.fizzBuzz(3)
        assertEquals("Fizz", actual)
    }

    @Test
    fun `should output Buzz when divisible by 5`() {
        val actual = FizzBuzzKata.fizzBuzz(5)
        assertEquals("Buzz", actual)
    }

    @Test
    fun `should output FizzBuzz when divisible by 5 AND 3`() {
        val actual = FizzBuzzKata.fizzBuzz(15)
        assertEquals("FizzBuzz", actual)
    }

    @Test
    fun `should correctly output based on inputs`() {
        val inputToOutputPairs = listOf(
            1 to "1",
            2 to "2",
            3 to "Fizz",
            4 to "4",
            5 to "Buzz",
            6 to "Fizz",
            7 to "7",
            8 to "8",
            9 to "Fizz",
            10 to "Buzz",
            11 to "11",
            12 to "Fizz",
            13 to "13",
            14 to "14",
            15 to "FizzBuzz",
            16 to "16"
        )

        for (inputToOutputPair in inputToOutputPairs) {
            val input = inputToOutputPair.first
            val output = inputToOutputPair.second
            val actual = FizzBuzzKata.fizzBuzz(input)
            assertEquals(output, actual)
        }
    }
}