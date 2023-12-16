package step4.view

import step4.domain.Car

class InputView() {
    fun inputInfoOfCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
        val infoOfCars = readln().split(",")
        require(0 < infoOfCars.size && infoOfCars.size < 6) { "자동차 이름은 1 이상, 6 미만이어야 합니다." }
        return infoOfCars.map { Car(it) }
    }

    fun inputNumberOfAttempts(): Int {
        println("시도할 회수는 몇 회인가요?")
        val numberofAttempts = readln().toInt()
        require(numberofAttempts > 0) { "시도할 회수는 1 이상이어야 합니다." }
        return numberofAttempts
    }
}
