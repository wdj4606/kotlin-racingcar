STEP 4

1. Car 클래스 생성 ( 속성 : name, position )
   - move() 메소드 생성
   
2. RaceGame 클래스 생성 ( 속성 : cars, round )
   - RaceGaem init 함수 생성 ( name 확인 후 객체 초기화 )
   - playGame() 메소드 생성 ( 승리자를 return 함 )
   - moveCars() 메소드 생성
   - randomMove() 메소드 생성 ( 난수 발생 )
   - printCurrentPositions() 메소드 생성 ( car position 출력 )
   - determineWinners() 메소드 생성 ( 승리자 결정 )
   - getMaxPosition() 메소드 생성 ( 최대 position 값 return )
   - getWinners() 메소드 생성 ( 최대 position 값을 가진 car를 문자열로 return )

3. InputView 클래스 생성
   - inputCarNames() 메소드 생성 ( 자동차 이름 입력 )
   - inputRound() 메소드 생성 ( 라운드 입력 )

4. ResultView 클래스 생성
   - printWinners() 메소드 생성 ( 승리자 출력 )

5. main 함수, TestCase 생성
