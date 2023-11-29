package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "권지민", age = 28, nickname = "클로이")
        assertThat(actual.name).isEqualTo("권지민")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isEqualTo("클로이")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "권지민", age = 28, nickname = null)
        assertThat(actual.name).isEqualTo("권지민")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "권지민", age = 28)
        assertThat(actual.name).isEqualTo("권지민")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isEqualTo("권지민")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person(name = "권지민", age = 28, "클로이")
        val person2 = Person(name = "권지민", age = 28, "클로이")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person(name = "권지민", age = 28, "클로이")
        val actual = person.copy(nickname = "지미니")

        assertThat(actual.name).isEqualTo("권지민")
        assertThat(actual.age).isEqualTo(28)
        assertThat(actual.nickname).isEqualTo("지미니")
    }
}
