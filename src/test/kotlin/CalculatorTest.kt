import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
//import io.mockk.spyk
//import io.mockk.every

class CalculatorTest {

    private val epsilon = 1e-10
    @Test
    fun add() {
        val calculator = Calculator()
        val argument = "1+2+3";
        assert(kotlin.math.abs(6 - calculator.drive(argument)) < epsilon)
    }

    @Test
    fun multiply() {
        val calculator = Calculator()
        val argument = "2*3"
        assert(kotlin.math.abs(6 - calculator.drive(argument)) < epsilon)
    }

    @Test
    fun minus() {
        val calculator = Calculator()
        val argument = "3-2"
        assert(kotlin.math.abs(1 - calculator.drive(argument)) < epsilon)
    }
    @Test
    fun divide() {
        val calculator = Calculator()
        val argument = "6/2"
        assert(kotlin.math.abs(3 - calculator.drive(argument)) < epsilon)
    }
//    @Test
//    fun preProcess() {
//        val mockCalculator = spyk<Calculator>(recordPrivateCalls = true)
//        every { mockCalculator["preProcess"]() } returns Pair(mutableListOf(1, 2, 3), mutableListOf('+', '-'))
//        assertEquals(Pair(mutableListOf(1, 2, 3), mutableListOf('+', '-')), mockCalculator.drive("1+2-3"))
//    }
}