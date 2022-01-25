package katas.ardalis

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Keeping commented out tests for visibility on change in requirements

class StringCalculatorTest {

    @Test
    fun `given empty string, should return 0`() {
        val actual = StringCalculator.add("")

        assertEquals(0, actual)
    }

//    1. iv
//    Ask was changed in 2.
//    @Test
//    fun `given an input larger than allowed, should throw`() {
//        val exception = assertThrows<IllegalArgumentException> {
//            StringCalculator.add("1,2,3")
//        }
//
//        assertEquals("Can't be more than 2 nums in the input string", exception.message)
//    }

    @Test
    fun `given a valid input with multiple nums, should return sum`() {
        val (num1, num2) = listOf(1, 3)
        val input = "$num1,$num2"

        val expected = num1 + num2

        assertEquals(expected, StringCalculator.add(input))
    }

    // 2.
    @Test
    fun `should handle unknown number of numbers`() {
        val input = "1,2,3,4"
        assertEquals(1 + 2 + 3 + 4, StringCalculator.add(input))
    }

    // 3.
    @Test
    fun `should be able to handle commas AND newlines as delimiters`() {
        val input = "1,2\n3"
        assertEquals(1 + 2 + 3, StringCalculator.add(input))
    }

    // 4. ( Example: "//;\n1;2" returns 3 (the delimiter is ";") )
    @Test
    fun `should handle an additional delimiter at the beginning of the input string`() {
        val input = "//;1,2\n3;4"

        assertEquals(1 + 2 + 3 + 4, StringCalculator.add(input))
    }

    // 5.
    @Test
    fun `given input contains negative num, should throw exception and list all negative nums in input list`() {
        val input = "-1,2"

        val actualException = assertThrows<Exception> {
            StringCalculator.add(input)
        }
        assertEquals("Negatives not allowed: -1", actualException.message)
    }

    @Test
    fun `should ignore numbers greater than 1000`() {
        val input = "1000,1,2,2045"

        assertEquals(1 + 2, StringCalculator.add(input))
    }
}