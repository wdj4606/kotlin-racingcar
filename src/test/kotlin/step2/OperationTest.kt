package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step2.model.operation.AdditionOperation
import step2.model.operation.DivideOperation
import step2.model.operation.MultiplyOperation
import step2.model.operation.SubtractionOperation

class OperationTest {
    @Test
    fun `덧셈`() {
        assertThat(AdditionOperation().calculate(2, 2)).isEqualTo(4)
    }

    @Test
    fun `뺄셈`() {
        assertThat(SubtractionOperation().calculate(2, 2)).isEqualTo(0)
    }

    @Test
    fun `나누기`() {
        assertThat(DivideOperation().calculate(2, 2)).isEqualTo(1)
    }

    @Test
    fun `곱하기`() {
        assertThat(MultiplyOperation().calculate(2, 2)).isEqualTo(4)
    }
}
