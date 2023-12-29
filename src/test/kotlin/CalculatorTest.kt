import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
//import io.mockk.spyk
//import io.mockk.every

class CalculatorTest {

    private val epsilon = 1e-10
    @Test
    fun add() {
        val argument = "1+2+3";
        assert(kotlin.math.abs(6 - Calculator.drive(argument)) < epsilon)
    }

    @Test
    fun complexPlusMinus() {
        val argument = "1+2-3"
        assert(kotlin.math.abs(0 - Calculator.drive(argument)) < epsilon)
    }

    @Test
    fun complexPlusMultiply() {
        val argument = "1+2*3"
        assert(kotlin.math.abs(7 - Calculator.drive(argument)) < epsilon)
    }

    @Test
    fun complexPlusDivide() {
        val argument = "1+6/3"
        assert(kotlin.math.abs(3 - Calculator.drive(argument)) < epsilon)
    }
    @Test
    fun complexMinusMultiply() {
        val argument = "1-2*3"
        assert(kotlin.math.abs(-5 - Calculator.drive(argument)) < epsilon)
    }

    @Test
    fun multiply() {
        val argument = "2*3"
        assert(kotlin.math.abs(6 - Calculator.drive(argument)) < epsilon)
    }



    @Test
    fun minus() {
        val argument = "3-2"
        assert(kotlin.math.abs(1 - Calculator.drive(argument)) < epsilon)
    }
    @Test
    fun divide() {
        val argument = "6/2"
        assert(kotlin.math.abs(3 - Calculator.drive(argument)) < epsilon)
    }
//    @Test
//    fun preProcess() {
//        val mockCalculator = spyk<Calculator>(recordPrivateCalls = true)
//        every { mockCalculator["preProcess"]() } returns Pair(mutableListOf(1, 2, 3), mutableListOf('+', '-'))
//        assertEquals(Pair(mutableListOf(1, 2, 3), mutableListOf('+', '-')), mockCalculator.drive("1+2-3"))
//    }
}