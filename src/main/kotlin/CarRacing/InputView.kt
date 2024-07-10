package CarRacing

data class InputParameters(val numberOfCar: Int, val numberOfRace: Int)

object InputView {
    private const val PROMPT_GET_NUMBER_OF_CAR = "자동차 대수는 몇 대인가요?"
    private const val PROMPT_GET_NUMBER_OF_RACE = "시도할 횟수는 몇 회인가요?"

    private const val ERR_INPUT_POSITIVE_INTEGER = "양의 정수 입력 실패"
    const val ERR_INPUT_NUMBER_OF_CAR = "자동차 대수 입력이 정상적이지 않습니다."
    const val ERR_INPUT_NUMBER_OF_RACE = "시도 횟수 입력이 정상적이지 않습니다."

    fun run(): InputParameters {
        val numberOfCar = getNumberOfCar()
        val numberOfRace = getNumberOfRace()
        return InputParameters(numberOfCar, numberOfRace)
    }
    private fun getNumberOfCar(): Int {
        println(PROMPT_GET_NUMBER_OF_CAR)
        try {
            return getPositiveInteger()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ERR_INPUT_NUMBER_OF_CAR)
        }
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
