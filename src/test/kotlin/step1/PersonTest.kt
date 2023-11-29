package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인인 자`() {
        val actual = Person("영민", 10, "라쿠운")
        assertThat(actual.name).isEqualTo("영민")
        assertThat(actual.age).isEqualTo(10)
        assertThat(actual.nickname).isEqualTo("라쿠운")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("영민", 10, null)

        assertThat(actual.name).isEqualTo("영민")
        assertThat(actual.age).isEqualTo(10)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("영민", 10)

        assertThat(actual.name).isEqualTo("영민")
        assertThat(actual.age).isEqualTo(10)
        assertThat(actual.nickname).isEqualTo("영민")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person("영민", 10, "라쿠운")
        val person2 = Person("영민", 10, "라쿠운")

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person("영민", 10, "라쿠운")
        val actual = person.copy(nickname = "하디")

        assertThat(actual.name).isEqualTo("영민")
        assertThat(actual.age).isEqualTo(10)
        assertThat(actual.nickname).isEqualTo("하디")
    }
}
