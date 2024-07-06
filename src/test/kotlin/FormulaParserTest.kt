import org.assertj.core.api.Assertions.assertThat
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

        assertDoesNotThrow {
            FormulaParser.execute(" 2 + 3 * 4 / 2 ")
        }
    }
    @Test
    fun `잘못된 문자 있니`() {
        assertThatThrownBy {
            FormulaParser.checkCharValid("a")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_CHAR_VALID)

        assertThatThrownBy {
            FormulaParser.checkCharValid("어디 날 한번 계산해봐")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_CHAR_VALID)

        assertThatThrownBy {
            FormulaParser.checkCharValid(" 2 + 3 * 4 / 2 ?")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_CHAR_VALID)

        assertDoesNotThrow {
            FormulaParser.checkCharValid(" 2 + 3 * 4 / 2 ")
        }
    }

    @Test
    fun `수식 분해 잘 되니`() {
        val subFormulas1 = FormulaParser.splitByOperator("10+ 10")
        assertThat(subFormulas1.size).isEqualTo(3)
        val subFormulas2 = FormulaParser.splitByOperator("100")
        assertThat(subFormulas2.size).isEqualTo(1)
        val subFormulas3 = FormulaParser.splitByOperator(" 2 + 3 * 4 / 2 ")
        assertThat(subFormulas3.size).isEqualTo(7)
        val subFormulas4 = FormulaParser.splitByOperator("  ")
        assertThat(subFormulas4.size).isEqualTo(0)
        val subFormulas5 = FormulaParser.splitByOperator("  2 + 3 * 4 / 2.0 ")
        assertThat(subFormulas5.size).isEqualTo(7)
        val subFormulas6 = FormulaParser.splitByOperator("  2 + 3 * 4 / 2.0.0 ")
        assertThat(subFormulas6.size).isEqualTo(7)
    }

    @Test
    fun `숫자 문제 없니`() {
        assertThatThrownBy {
            FormulaParser.convertNumber("str")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_NUMBER_STRING)

        assertThatThrownBy {
            FormulaParser.convertNumber("10 0")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_NUMBER_STRING)

        assertThat(FormulaParser.convertNumber("100")).isEqualTo(100.0)
        assertThat(FormulaParser.convertNumber("100.0")).isEqualTo(100.0)
    }

    @Test
    fun `연산자 문제 없니`() {
        assertThatThrownBy {
            FormulaParser.checkOperator("100")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_STRING)

        assertThatThrownBy {
            FormulaParser.checkOperator("$$")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_STRING)

        assertDoesNotThrow {
            FormulaParser.checkOperator("+")
            FormulaParser.checkOperator("-")
            FormulaParser.checkOperator("*")
            FormulaParser.checkOperator("/")
        }
    }

    @Test
    fun `숫자 기호 숫자 기호 숫자 순서니`() {
        assertThatThrownBy {
            val subFormulas = FormulaParser.splitByOperator("10 + 10 / ")
            FormulaParser.checkSplitStringOrder(subFormulas)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_PAIR)

        assertThatThrownBy {
            val subFormulas = FormulaParser.splitByOperator("10 + + 10 / ")
            FormulaParser.checkSplitStringOrder(subFormulas)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_PAIR)

        assertThatThrownBy {
            val subFormulas = FormulaParser.splitByOperator("+ 3 * 4 / 2 ")
            FormulaParser.checkSplitStringOrder(subFormulas)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_OPERATOR_PAIR)

        assertDoesNotThrow {
            val subFormulas = FormulaParser.splitByOperator(" 2 + 3 * 4 / 2 ")
            FormulaParser.checkSplitStringOrder(subFormulas)
        }
    }

    @Test
    fun `0으로 나누지는 않니`() {
        assertThatThrownBy {
            val subFormulas = FormulaParser.splitByOperator("10 + 10 / 0")
            FormulaParser.checkDivisionByZero(subFormulas)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(FormulaParser.ERR_DIVIDE_BY_ZERO)

        assertDoesNotThrow {
            val subFormulas = FormulaParser.splitByOperator(" 2 + 3 * 4 / 2 ")
            FormulaParser.checkDivisionByZero(subFormulas)
        }
    }
}
