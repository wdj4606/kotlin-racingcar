package CarRacing.View

import CarRacing.Domain.InputParameters

object InputView {
    private const val PROMPT_GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분):"
    private const val PROMPT_GET_NUMBER_OF_RACE = "시도할 횟수는 몇 회인가요?"

    private const val ERR_INPUT_CAR_NAMES = "자동차 이름 입력 실패"
    private const val ERR_INPUT_POSITIVE_INTEGER = "양의 정수 입력 실패"
    private const val ERR_INPUT_NUMBER_OF_RACE = "시도 횟수 입력이 정상적이지 않습니다."

    private const val SEPERATOR = ","

    fun run(): InputParameters {
        val carNames = getCarNames()
        val numberOfRace = getNumberOfRace()
        return InputParameters(carNames, numberOfRace)
    }
    private fun getCarNames(): List<String> {
        println(PROMPT_GET_CAR_NAMES)
        val input = readlnOrNull()
        requireNotNull(input) { ERR_INPUT_CAR_NAMES }
        val carNames = input.split(SEPERATOR).map { it.trim() }
        return carNames
    }

    private fun getNumberOfRace(): Int {
        println(PROMPT_GET_NUMBER_OF_RACE)
        try {
            return getPositiveInteger()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ERR_INPUT_NUMBER_OF_RACE)
        }
    }

    private fun getPositiveInteger(): Int {
        val input: String = readln()

        require(input.isNotEmpty()) { ERR_INPUT_POSITIVE_INTEGER }
        val positiveInteger = input.toIntOrNull()
        require(positiveInteger != null) { ERR_INPUT_POSITIVE_INTEGER }
        require(positiveInteger > 0) { ERR_INPUT_POSITIVE_INTEGER }
        return positiveInteger
    }
}
