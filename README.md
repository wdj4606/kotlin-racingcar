# kotlin-racingcar

<h2>class</h2>

Car : 자동차 정보를 가지는 데이터 클래스

InputItem.kt: Input에 대한 정보를 가지는 데이터 클래스


CarRacing.kt
- 변수 
  - carList `List<Car>`
- fun
  - goRacing
  - plusCount
  - getFinalResult

View.kt
- InputView
  - getInputItem: 자동차와 시도 횟수를 받는 함수
    - return `InputItem`
- ResultView
  - showNowResult
    - input: carList `List<Car>`
  - showResult
    - input: firstCars `String`