
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    @Test
    fun testCalculate() {
        assertEquals(Calculator.calculate("2 + 3 * 4 / 2"), 10)
    }

    @Test
    fun testCalculateWithEmptyInput() {
        assertThrows<IllegalArgumentException> {
            Calculator.calculate("")
        }
    }

    @Test
    fun testCalculateWithInvalidInput() {
        assertThrows<NumberFormatException> {
            Calculator.calculate("abc")
        }
    }

    @Test
    fun testCalculateWithSingleNumber() {
        assertEquals(Calculator.calculate("5"), 5)
    }

    @Test
    fun testCalculateWithMultipleOperations() {
        assertEquals(Calculator.calculate("2 + 3 * 4 - 6 / 2"), 7)
    }

    @Test
    fun testCalculateWithNegativeNumbers() {
        assertEquals(Calculator.calculate("-2 + 3"), 1)
    }

    @Test
    fun testCalculateWithDivisionByZero() {
        assertThrows<ArithmeticException> {
            Calculator.calculate("2 / 0")
        }
    }

    @Test
    fun testCalculateWithInvalidOperation() {
        assertThrows(IllegalArgumentException::class.java) {
            Calculator.calculate("2 ? 3")
        }
    }
}
