import CarRacing.RacingCar
import CarRacing.ResultView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarRacingResultViewTest {
    @Test
    fun `시작 출력 잘되니?`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        ResultView.showStart()

        val output = outputStream.toString().trim()
        Assertions.assertThat(output).isEqualTo(ResultView.PROMPT_START)
    }

    @Test
    fun `자동차 출력 잘되니?`() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val racingCar = RacingCar(3)
        ResultView.showRacingCar(racingCar)

        val output = outputStream.toString().trim()
        Assertions.assertThat(output).isEqualTo(ResultView.CAR_PROGRESS_SYMBOL.repeat(3))
    }
}
