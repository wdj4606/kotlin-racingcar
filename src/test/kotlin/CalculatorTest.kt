import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @Test
    fun `덧셈 잘되니`() {
        assertThat(Calculator.execute("1+ 1")).isEqualTo(2.0)
    }

    @Test
    fun `뺄셈 잘되니`() {
        assertThat(Calculator.execute("1- 1")).isEqualTo(0.0)
    }

    @Test
    fun `곱셈 잘되니`() {
        assertThat(Calculator.execute("2 * 4")).isEqualTo(8.0)
    }

    @Test
    fun `나눗셈 잘되니`() {
        assertThat(Calculator.execute("9/2")).isEqualTo(4.5)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "2 + 3 * 4 / 2",
            " 2 + 3 * 2 ",
            "10 + 10 / 4 +    5   ",
            "10",
            "10.000",
            "5.5 - 0.5 *2"
        ]
    )
    fun `복잡한거 계산 잘되니`(formula: String?) {
        assertThat(Calculator.execute(formula)).isEqualTo(10.0)
    }
}
