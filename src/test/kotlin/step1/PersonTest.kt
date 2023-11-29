package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김인혁", age = 30, nickname = "Axl")
        assertThat(actual.name).isEqualTo("김인혁")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("Axl")
    }

    @Test
    fun nullTypeTest() {
        val actual = Person(name = "김인혁", age = 30, nickname = null)
        assertThat(actual.name).isEqualTo("김인혁")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun test() {
        val tt = Person("윤현준", 30)

        assertThat(tt.name).isEqualTo("윤현준")
        assertThat(tt.age).isEqualTo(30)
        assertThat(tt.nickname).isEqualTo("윤현준")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person("김인혁", 30)
        val person2 = Person("김인혁", 30)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("김인혁", 30)
        val person2 = person1.copy(nickname = "Endrew")
        assertThat(person2.nickname).isEqualTo("Endrew")
    }
}
