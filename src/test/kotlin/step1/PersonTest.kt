package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "정동원", age = 28, nickname = "richard")
        assertThat(actual.name).isEqualTo("정동원")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isEqualTo("richard")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "정동원", age = 28, nickname = null)
        assertThat(actual.name).isEqualTo("정동원")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(age = 28, nickname = null)
        assertThat(actual.name).isEqualTo("이름")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person(age = 28, nickname = null)
        val person2 = Person(age = 28, nickname = null)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person(age = 28, nickname = null)
        val actual = person.copy(name = "정동원")

        assertThat(actual.name).isEqualTo("정동원")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isNull()
    }
}
