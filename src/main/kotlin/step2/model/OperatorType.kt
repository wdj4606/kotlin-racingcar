package step2.model

import step2.model.operation.AdditionOperation
import step2.model.operation.DivideOperation
import step2.model.operation.MultiplyOperation
import step2.model.operation.Operation
import step2.model.operation.SubtractionOperation

enum class OperatorType(val operator: String, private val operation: Operation) {
    ADDITION("+", AdditionOperation()),
    SUBTRACTION("-", SubtractionOperation()),
    MULTIPLY("*", MultiplyOperation()),
    DIVIDE("/", DivideOperation());

    fun calculate(operand1: Int, operand2: Int): Int {
        return this.operation.calculate(operand1, operand2)
    }

    companion object {
        fun of(operator: String): OperatorType {
            return values().find { it.operator == operator }
                ?: throw IllegalArgumentException("not supported operator")
        }
    }
}
