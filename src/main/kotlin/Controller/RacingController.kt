package Controller

import Model.Car
import Model.Race
import kotlin.random.Random

class RacingController(private val race: Race) {
    var raceLog = mutableListOf<MutableList<Int>>()
    fun run() {
        initRaceLog()

        for (i in 1..race.attempt) {
            raceLog.add(mutableListOf<Int>())
            race.participant.forEachIndexed { j, car ->
                raceLog[i].add(raceLog[i - 1][j] + moveForward(car))
            }
        }
    }

    private
    fun initRaceLog() { // 시작 위치 설정
        raceLog.add(mutableListOf<Int>())
        for (i in 1..race.participant.size) raceLog[0].add(0)
    }

    private
    fun moveForward(car: Car): Int { // 뭔가 차량 별 능력 같은게 생기지 않을까 ㅇ3ㅇ
        return when (4 <= Random.nextInt(10)) {
            true -> 1
            false -> 0
        }
    }
}
