package calculator.service.calculator

class Addition : Operation {
    override fun calculate(left: Double, right: Double): Double {
        return left + right
    }
}

class Subtraction : Operation {
    override fun calculate(left: Double, right: Double): Double {
        return left - right
    }
}

class Multiplication : Operation {
    override fun calculate(left: Double, right: Double): Double {
        return left * right
    }
}

class Division : Operation {
    override fun calculate(left: Double, right: Double): Double {
        return left / right
    }
}
