package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "유민서", age = 24, nickname = "하디")

        assertThat(actual.name).isEqualTo("유민서")
        assertThat(actual.age).isEqualTo(24)
        assertThat(actual.nickname).isEqualTo("하디")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "유민서", age = 24, nickname = null)

        assertThat(actual.name).isEqualTo("유민서")
        assertThat(actual.age).isEqualTo(24)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "유민서", age = 24)

        assertThat(actual.name).isEqualTo("유민서")
        assertThat(actual.age).isEqualTo(24)
        assertThat(actual.nickname).isEqualTo("유민서")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person(name = "유민서", age = 24, nickname = "하디")
        val person2 = Person(name = "유민서", age = 24, nickname = "하디")

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person(name = "유민서", age = 24, nickname = "하디")
        val actual = person.copy(nickname = "하디하디")

        assertThat(actual.name).isEqualTo("유민서")
        assertThat(actual.age).isEqualTo(24)
        assertThat(actual.nickname).isEqualTo("하디하디")
    }
}
