package step2.model.operation

class AdditionOperation : Operation {
    override fun calculate(operand1: Int, operand2: Int): Int {
        return operand1 + operand2
    }
}
