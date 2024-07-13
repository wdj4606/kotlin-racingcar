package CarRacing

data class InputParameters(val carNames: List<String>, val numberOfRace: Int)

object InputView {
    private const val PROMPT_GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분):"
    private const val PROMPT_GET_NUMBER_OF_RACE = "시도할 횟수는 몇 회인가요?"

    private const val ERR_INPUT_CAR_NAMES = "자동차 이름 입력 실패"
    private const val ERR_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다"
    private const val ERR_INPUT_POSITIVE_INTEGER = "양의 정수 입력 실패"
    private const val ERR_INPUT_NUMBER_OF_RACE = "시도 횟수 입력이 정상적이지 않습니다."

    fun run(): InputParameters {
        val numberOfCar = getCarNames()
        val numberOfRace = getNumberOfRace()
        return InputParameters(numberOfCar, numberOfRace)
    }
    private fun getCarNames(): List<String> {
        println(PROMPT_GET_CAR_NAMES)
        val input = readlnOrNull()
        require(input != null) { ERR_INPUT_CAR_NAMES }
        val carNames = input.split(",").map { it.trim() }

        carNames.forEach { name ->
            require(name.length <= 5) { ERR_NAME_LENGTH }
        }
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
