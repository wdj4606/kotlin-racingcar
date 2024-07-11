package step3

import org.junit.jupiter.api.Test

class ResultViewTest {

    @Test
    fun `ResultView가 각 라운드 결과를 정확하게 출력하는지 확인`() {
        val cars = listOf(
            Car().apply { position = 1 },
            Car().apply { position = 2 },
            Car().apply { position = 3 }
        )

        ResultView.printRoundResult(cars)
    }
}
