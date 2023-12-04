package step2

import calculator.service.CalculateService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculateServiceTest {

    private fun assertCalculate(input: String, expected: String) {
        val actual = CalculateService.calculate(input)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "1 + 2 +", "1 + 2 + a", "1 + 2 + 3 +", "1 + + 2 + 3", "1 2 3", "1 + 2 3", "1 + 2 + 3 4", "1 % 2"])
    fun inputError(input: String) {
        // when
        val exception = assertThrows<IllegalArgumentException> {
            CalculateService.calculate(input)
        }

        // then
        assertEquals("input error", exception.message)
    }

    @Test
    fun calculate1() {
        // given
        val input = "2 + 3"
        val expected = "5"

        assertCalculate(input, expected)
    }

    @Test
    fun calculate2() {
        // given
        val input = "2 + 3 * 4"
        val expected = "20"

        assertCalculate(input, expected)
    }

    @Test
    fun calculate3() {
        // given
        val input = "2 + 3 * 4 / 2"
        val expected = "10"

        assertCalculate(input, expected)
    }
}
