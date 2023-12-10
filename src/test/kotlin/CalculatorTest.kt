
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun testCalculate() {
        assertEquals(Calculator.calculate("2 + 3 * 4 / 2"), 10)
    }

    @Test
    fun add() {
        assertEquals(Calculator.add(1, 2), 3)
    }

    @Test
    fun subtract() {
        assertEquals(Calculator.subtract(1, 2), -1)
    }

    @Test
    fun multiply() {
        assertEquals(Calculator.multiply(1, 2), 2)
    }

    @Test
    fun divide() {
        assertEquals(Calculator.divide(4, 2), 2)
    }
}
