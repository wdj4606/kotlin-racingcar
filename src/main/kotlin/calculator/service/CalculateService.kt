package calculator.service

import calculator.service.calculator.Operation

object CalculateService {
    private val operations = Operation.values().associateBy { it.value }

    fun calculate(input: String?): String {
        require(!input.isNullOrBlank()) { throw IllegalArgumentException("input error") }

        val expressions = input.split(" ")
        require(expressions.size % 2 != 0) { throw IllegalArgumentException("input error") }

        var result = expressions[0].toIntOrNull() ?: throw IllegalArgumentException("input error")
        for (i in 1 until expressions.size step 2) {
            val operation = operations[expressions[i]] ?: throw IllegalArgumentException("input error")
            val right = expressions[i + 1].toIntOrNull() ?: throw IllegalArgumentException("input error")
            result = operation.operate(result, right)
        }

        return result.toString()
    }
}
