package step2

object Calculator {
    fun calculate(input: String?): Long {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException() }

        val split = input.split(" ")
        var result: Long = split[0].toLongOrNull() ?: throw IllegalArgumentException()

        for (i in 1 until split.size step 2) {
            val operand: Long = split[i + 1].toLongOrNull() ?: throw IllegalArgumentException()
            result = OperatorType.operate(split[i], result, operand)
        }

        return result
    }
}
