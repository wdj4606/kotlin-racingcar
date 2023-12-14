fun Calculator() {
    //문자열 입력받음
    //사칙연산 순서 X
    fun preProcess(argument: String) : Pair<mutableListOf<int>, mutableListOf<Char>> {
        val numberList = mutableListOf<Int>()
        val operatorList = mutableListOf<Char>()
        var number = 0
        for (token in argument){
            when {
                token.matches(Regex("[0-9]")) -> number = number * 10 + (token - '0')
                token.matches(Regex("[+\\-*/]")) -> {
                    numberList.add(number)
                    operatorList.add(token)
                    number = 0
                }
            }
        }
        numberList.add(number)
        return Pair(numberList, operatorList)
    }


}