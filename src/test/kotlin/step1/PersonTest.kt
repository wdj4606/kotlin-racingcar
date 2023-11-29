package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "이주한", age = 27, nickname = "Jeff")
        assertThat(actual.name).isEqualTo("이주한")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("Jeff")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "이주한", age = 27, nickname = null)
        assertThat(actual.name).isEqualTo("이주한")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("이주한", 27)
        assertThat(actual.name).isEqualTo("이주한")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("이주한")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person("이주한", 27, "Jeff")
        val person2 = Person("이주한", 27, "Jeff")
        assertThat(person1 === person2).isFalse()
        assertThat(person1 == person2).isTrue()
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person("이주한", 27, "Jeff")
        val actual = person.copy(nickname = "kotlin")

        assertThat(person.name).isEqualTo(actual.name)
        assertThat(person.age).isEqualTo(actual.age)
        assertThat(person.nickname).isNotEqualTo(actual.nickname)
    }
}
