package calculator.service.calculator

enum class Operation(val value: String, val operate: (Int, Int) -> Int) {
    ADD("+", { x, y -> x + y }),
    SUBTRACT("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });
}
