
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class FormulaParserTest {
    @Test
    fun `널이거나 빈문자열 아니니`() {
        assertThatThrownBy {
            FormulaParser.execute(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_NULL_OR_EMPTY)

        assertThatThrownBy {
            FormulaParser.execute("")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_NULL_OR_EMPTY)

        assertThatThrownBy {
            FormulaParser.execute("   ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_NULL_OR_EMPTY)

        assertThatThrownBy {
            FormulaParser.execute("$$")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_CHAR_VALID)

        assertDoesNotThrow {
            FormulaParser.execute(" 2 + 3 * 4 / 2 ")
        }

        assertDoesNotThrow {
            FormulaParser.execute("  2 + 3 * 4 / 2.0 ")
        }
    }
    @Test
    fun `잘못된 문자 있니`() {
        assertThatThrownBy {
            FormulaParser.execute("a")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_CHAR_VALID)

        assertThatThrownBy {
            FormulaParser.execute("어디 날 한번 계산해봐")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_CHAR_VALID)

        assertThatThrownBy {
            FormulaParser.execute(" 2 + 3 * 4 / 2 ?")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_CHAR_VALID)
    }

    @Test
    fun `숫자 문제 없니`() {
        assertThatThrownBy {
            FormulaParser.execute("10 0")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_PAIR)

        assertThatThrownBy {
            FormulaParser.execute("100.0.0")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_PAIR)
    }

    @Test
    fun `숫자 기호 숫자 기호 숫자 순서니`() {
        assertThatThrownBy {
            FormulaParser.execute("   2 + 3 * 4 / ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_PAIR)
    }

    @Test
    fun `0으로 나누지는 않니`() {
        assertThatThrownBy {
            FormulaParser.execute("10 + 10 / 0")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_DIVIDE_BY_ZERO)
    }
}
