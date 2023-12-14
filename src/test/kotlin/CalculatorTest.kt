import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun add() {
        val calculator = Calculator()
        assertEquals(3, calculator.add(1, 2))
    }

    @Test
    fun multiply() {
        val calculator = Calculator()
        assertEquals(6, calculator.multiply(2, 3))
    }

    @Test
    fun minus() {
        val calculator = Calculator()
        assertEquals(1, calculator.minus(3, 2))
    }
    @Test
    fun divide() {
        val calculator = Calculator()
        assertEquals(2, calculator.divide(4, 2))
    }
    @Test
    fun preProcess() {
        val calculator = Calculator()
        assertEquals(Pair(mutableListOf(1, 2, 3), mutableListOf('+', '-')), calculator.preProcess("1+2-3"))
    }
}