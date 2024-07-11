package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class InputViewTest {

    @Test
    fun `자동차 대수가 일치하는지?`() {
        val input = "3\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val carCount = InputView.getCarCount()
        assertEquals(3, carCount)
    }

    @Test
    fun `시도할 횟수가 일치하는지?`() {
        val input = "5\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val roundCount = InputView.getRoundCount()
        assertEquals(5, roundCount)
    }
}
