package step1

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "양무일", nickname = "무어", age = 30)

        assertThat(person.name).isEqualTo("양무일")
        assertThat(person.nickname).isEqualTo("무어")
        assertThat(person.age).isEqualTo(30)
    }

    @Test
    fun `널 타입인지`() {
        val person = Person(name = "양무일", nickname = null, age = 30)

        assertThat(person.name).isEqualTo("양무일")
        assertThat(person.nickname).isNull()
        assertThat(person.age).isEqualTo(30)

//        val nickname = person.nickname ?: throw Exception("닉네임이 Null 입니다.")
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "양무일", age = 30)

        assertThat(person.name).isEqualTo("양무일")
        assertThat(person.nickname).isNull()
        assertThat(person.age).isEqualTo(30)
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person(name = "양무일", nickname = "무어", age = 30)
        val person2 = Person(name = "양무일", nickname = "무어", age = 30)

        // == 는 값 비교
        assertThat(person1 == person2).isTrue()
//        // === 는 참조 비교 (여기서는 주소가 다르니 False가 나오겠지.)
//        assertThat(person1 === person2).isTrue()

        // data class를 선언하면 isEqualTo에서 값 비교를 해준다.
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person(name = "양무일", nickname = "무어", age = 30)
        val person2 = person1.copy(nickname = "무무")

        assertThat(person1.name).isEqualTo("양무일")
        assertThat(person1.nickname).isEqualTo("무어")
        assertThat(person2.nickname).isEqualTo("무무")
    }
}
