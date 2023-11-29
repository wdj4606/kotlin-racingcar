package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김인혁", nickname = "개발자", age = 30)
        assertThat(actual.name).isEqualTo("김인혁")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("김인혁", null, "개발자")
        assertThat(actual.age).isEqualTo(null)
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("김인혁", 30)
        assertThat(actual.name).isEqualTo("김인혁")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("김인혁")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person("김인혁", 30)
        val person2 = Person("김인혁", 30)
        // == 동등성 비교
        // === 주소값 비교

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person("김인혁", 30)
        val actual = person.copy(name = "개발자")
        assertThat(actual.nickname).isEqualTo("김인혁")
    }
}
