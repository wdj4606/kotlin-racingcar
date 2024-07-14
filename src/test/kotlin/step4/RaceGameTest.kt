package step4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class RaceGameTest {
    @Test
    fun `자동차 이름을 입력받고 쉼표로 구분된 리스트를 반환한다`() {
        val input = "Peter, Jin, Makto"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val result = InputView.inputCarNames()

        assertEquals(listOf("Peter", "Jin", "Makto"), result)
    }

    @Test
    fun `실행 횟수가 유효하지 않을 경우 에러를 띄운다`() {
        val input = "abc"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            InputView.inputTryCount()
        }
        assertEquals(ERROR_TRY_COUNT, exception.message)
    }

    @Test
    fun `게임 테스트`() {
        val carNames = listOf("Peter", "Jin", "Makto")
        val tryCount = 5
        val game = RaceGame(carNames, tryCount)

        game.playGame()
    }
}
